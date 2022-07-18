package com.revature.Servlets;

import java.io.IOException;
import java.io.InputStream;
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
import com.revature.Exceptions.RNotCreatedException;
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
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		res.addHeader("Content-Type", "application/x-www-form-urlencoded");
		String path = req.getPathInfo();
//		HttpSession session = req.getSession();
//		User principal = om.readValue(session.getAttribute("principal").toString(), User.class);

		
//		List<Reimbursement> reimbursements = rs.getReimbursements();
		PrintWriter pw = res.getWriter();
//		pw.write(om.writeValueAsString(reimbursements));
		
		if(path == null) { 
//			if(principal != null && principal.getRole().getRole().equals("Manager")) {
				List<Reimbursement> reims = rs.getReimbursements();
				List<ReimbursementDTO> reimsDTO = new ArrayList<>();
				reims.forEach(r -> reimsDTO.add(new ReimbursementDTO(r)));
				
				pw.write(om.writeValueAsString(reimsDTO));
//				pw.write(om.writeValueAsString(reims));
//			}else if(principal != null && principal.getRole().getRole().equals("Employee")) {
//				List<Reimbursement> reimb = rs.getReimbursementByAuthor(principal);
//				List<ReimbursementDTO> reimDTO = new ArrayList<>();
//				pw.write(om.writeValueAsString(reimDTO));
				pw.close();
			}else {
				res.sendError(401, "Unauthorized");
			}
		}
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String path = req.getPathInfo();
		HttpSession session = req.getSession();
		InputStream reqB = req.getInputStream();
//		User principal = om.readValue(session.getAttribute("principal").toString(), User.class);
//		System.out.println(principal);
		
			Reimbursement nr;
			nr = om.readValue(reqB, Reimbursement.class);
			rs.insertReimbursement(nr);
			
			res.setStatus(200);
		}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		CorsFix.addCorsHeader(req.getRequestURI(), res);
		String info = req.getPathInfo();
		InputStream reqB = req.getInputStream();
		
		Reimbursement r = om.readValue(req.getInputStream(), Reimbursement.class);
		int id = Integer.parseInt(info.substring(1));
		rs.updateReimbursement(r);
		
		try {
			ReimbursementDTO rDTO = new ReimbursementDTO(rs.getByID(id));
		}

//		if(r == "Approved" || r == "Denied") {
//			res.setStatus(202);
//		} else {
//			res.setStatus(304);
//		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		super.doDelete(req, res);
	}

}
