package com.revature.Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.UserDTO;
import com.revature.Exceptions.UserNotCreatedException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.Role;
import com.revature.Models.User;
import com.revature.Services.RolesService;
import com.revature.Services.UserService;
import com.revature.utils.CorsFix;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private UserService us = new UserService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();
	private static Logger log = LogManager.getLogger(UserServlet.class);

	/*-
	 * All GET request made to the /users endpoint are funneled to this doGet method
	 * 		- /users
	 * 			- returns all users
	 * 		- /users/{id}
	 * 			- returns a user of a specific id
	 * Have to determine which behavior to execute based on the URL request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");


		/*-
		 * Extra path information associated with the URL the client sent when it made this request
		 * 	- ie:
		 * 		- "/1" if /users/1
		 * 		- null if /users
		 */
		String pathInfo = req.getPathInfo();
		/*-
		 *  HttpSession allows us to retrieve information placed in the session object passed in a previous HttpResponse
		 *  	- in this case, the Session is set in the AuthServlet
		 */
		HttpSession session = req.getSession();
		
//		User principal = om.readValue(session.getAttribute("principal"), User.class);

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) { /*&& principal.getRole().getRole().equals("Manager")) {*/

//			RolesService rs = new RolesService();
			try {
				PrintWriter pw = res.getWriter();

				List<User> users;
				List<UserDTO> usersDTO = new ArrayList<>();
				users = us.getUsers();
				users.forEach(u -> usersDTO.add(new UserDTO(u)));
				pw.write(om.writeValueAsString(usersDTO));
				
				pw.close();

			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			List<UserDTO> usersDTO = new ArrayList<>();

//				users = us.getUserByRole(rs.getRole("Employee"));
//				users.forEach(u -> usersDTO.add(new UserDTO()));

			} 
//			catch (UserNotFoundException e) {
//				log.error(e.getMessage());
//				res.sendError(404, "Not found.");
//			}

//		} 
//		else if (principal.getRole().getRole().equals("Employee")) {
//			pathInfo = pathInfo.substring(1);
//			if (Integer.parseInt(pathInfo) == principal.getId()) {
//				PrintWriter pw = res.getWriter();
//				pw.write(om.writeValueAsString(principal));
			 
//				else {
//				int id = Integer.parseInt(pathInfo.substring(1));
//
//				try (PrintWriter pw = res.getWriter()) {
//					User u = us.getUserById(id);
//					UserDTO uDTO = new UserDTO();
//
//					pw.write(om.writeValueAsString(uDTO));
//
//					res.setStatus(200);
//				} catch (UserNotFoundException e) {
//					log.error(e.getMessage());
//					res.setStatus(404);
//				}
//			}
//		} 
	else {
			log.info("Sent error, 401 unauthorized.");
			res.sendError(401, "Unauthorized request.");
		}
	}
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		InputStream reqBody = req.getInputStream();

		User newUser = om.readValue(reqBody, User.class);
		us.createUser(newUser);

		res.setStatus(201); // Status: Created
		
	}
	
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
//		CorsFix.AddCorsHeader(req.getRequestURI(), res);
//		InputStream reqBody = req.getInputStream();
//		String path = req.getPathInfo();
//		int id = Integer.parseInt(path.substring(1));
//		User u = om.readValue(reqBody, User.class);
//		u.setId(id);
//		HttpSession session = req.getSession();
//		if(us.getUserById(req,res,id)) {
//			
//		}
//	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		super.doOptions(req, res);
		CorsFix.addCorsHeader(req.getRequestURI(), res);
	}
}