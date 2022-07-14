package com.revature.Servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.ReimbursementDTO;
import com.revature.Exceptions.RNotFoundException;
import com.revature.Models.R_status;
import com.revature.Models.R_type;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;
import com.revature.Services.RStatusService;
import com.revature.Services.RTypeService;
import com.revature.Services.ReimbursementService;
import com.revature.utils.CorsFix;

public class ReimbursementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		User principal = om.readValue(session.getAttribute("principal").toString(), User.class);
		
		List<Reimbursement> reimbursements = rs.getReimbursements();
		PrintWriter pw = res.getWriter();
		pw.write(om.writeValueAsString(reimbursements));
		
		if(path == null) { 
			if(principal != null && principal.getRole().getRole().equals("Manager")) {
				List<Reimbursement> reims = rs.getReimbursements();
				List<ReimbursementDTO> reimsDTO = new ArrayList<>();
				pw.write(om.writeValueAsString(reimsDTO));
				pw.write(om.writeValueAsString(reims));
			}else if(principal != null && principal.getRole().getRole().equals("Employee")) {
				List<Reimbursement> reimb = rs.getReimbursementByAuthor(principal);
				List<ReimbursementDTO> reimDTO = new ArrayList<>();
				pw.write(om.writeValueAsString(reimDTO));
			}else {
				res.sendError(401, "Unauthorized");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		User principal = om.readValue(session.getAttribute("principal").toString(), User.class);
		System.out.println(principal);
		
		if (path == null && principal != null && session.getAttribute("u_role").equals("Employee")) { //employee posting
			RStatusService rss = new RStatusService();
			RTypeService rts = new RTypeService();
			try {
				R_status status = rss.getStatus(3); //1 = approved, 2 = denied, 3 = pending
				R_type type = rts.getTypeByName(req.getParameter("type"));
				Timestamp submit = new Timestamp(System.currentTimeMillis());
				int amount = Integer.parseInt(req.getParameter("amount"));
				String description = req.getParameter("description");
				Reimbursement newR = new Reimbursement();
				newR.setAmount(amount);
				newR.setAuthor(principal);
				newR.setDescription(description);
				newR.setSubmitted(submit);
				newR.setT_id(type); //1 = LODGING, 2 = TRAVEL, 3 = FOOD, 4 = OTHER
				newR.setStatus_id(status);
				
				rs.insertReimbursement(newR);
				res.setStatus(201);
			} catch (RNotFoundException e) {
				e.printStackTrace();
			}
		}	else {
			res.sendError(401, "Restricted Access.");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		CorsFix.AddCorsHeader(req.getRequestURI(), res);
		Reimbursement r = om.readValue(req.getInputStream(), Reimbursement.class);
		boolean updated = rs.updateReimbursement(r);

		if(updated) {
			res.setStatus(202);
		} else {
			res.setStatus(304);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		super.doDelete(req, res);
	}

}
