package com.revature.Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.UserDTO;
import com.revature.Exceptions.UserNotCreatedException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.Role;
import com.revature.Models.User;
import com.revature.Services.UserService;
import com.revature.utils.CorsFix;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

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
		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");


		/*-
		 * Extra path information associated with the URL the client sent when it made this request
		 * 	- ie: 
		 * 		- "/1" if /users/1
		 * 		- null if /users
		 */
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {

			/*-
			 *  HttpSession allows us to retrieve information placed in the session object passed in a previous HttpResponse 
			 *  	- in this case, the Session is set in the AuthServlet
			 */
			HttpSession session = req.getSession();

			if (true) {
				// retrieving users from db using UserService
				List<User> users = us.getUsers();
				List<UserDTO> usersDTO = new ArrayList<>();

				// converting Users to UserDTOs for data transfer
				users.forEach(u -> usersDTO.add(new UserDTO(u)));

				// retrieving print writer to write to the Response body
				PrintWriter pw = res.getWriter();
				// writing toString representation of Users to body
				pw.write(om.writeValueAsString(usersDTO));

				pw.close();
			}else {
				// if the user making the request is not an admin
				res.sendError(401, "Unauthorized request.");
			}
		} else {
			// /1, /11, /{some-value}
			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				User u = us.getUserById(id);
				UserDTO uDTO = new UserDTO(u);

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(uDTO));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				// return 404, user not found
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		InputStream reqBody = req.getInputStream();

		User newUser = om.readValue(reqBody, User.class);

		try {
			us.createUser(newUser);

			res.setStatus(201); // Status: Created
		} catch (UserNotCreatedException e) {
//			res.setStatus(400);
			res.sendError(400, "Unable to create new user.");
			e.printStackTrace();
		}
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
//		if()
//	}
}