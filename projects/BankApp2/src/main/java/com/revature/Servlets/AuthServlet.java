package com.revature.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.UserDTO;
import com.revature.Exceptions.LoginException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.User;
import com.revature.Services.AuthService;
import com.revature.utils.CorsFix;

public class AuthServlet extends HttpServlet{
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User principal = as.login(username, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("userId", principal.getId());
			session.setAttribute("userRole", principal.getRole());
			session.setAttribute("principal", om.writeValueAsString(principal));
			
			// To make Chrome work with our cookie
			String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			res.setHeader("Set-Cookie", cookie);;
			
			UserDTO principalDTO = new UserDTO(principal);
			try(PrintWriter pw = res.getWriter()){
				pw.write(om.writeValueAsString(principalDTO));
				res.setStatus(200);
			}

		} catch (UserNotFoundException | LoginException e) {
			res.sendError(400, "Login unsuccessful.");
			e.printStackTrace();
		} 
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		
		HttpSession session = req.getSession();
		
		session.invalidate();
	}
	
	//to prevent CORS preflight issue
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		super.doOptions(req, res);
	}
}
