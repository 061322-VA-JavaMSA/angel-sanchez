package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.DAO.ReimbursementDAO;
import com.revature.Exceptions.RNotFoundException;
import com.revature.Exceptions.RNotUpdatedException;
import com.revature.Models.R_status;
import com.revature.Models.R_type;
import com.revature.Models.Reimbursement;
import com.revature.Models.Role;
import com.revature.Models.User;
import com.revature.Services.ReimbursementService;

@ExtendWith(MockitoExtension.class)
public class ReimbursementServiceTest {
	
	@Mock
	private static ReimbursementDAO mockRDao;
	@InjectMocks
	private static ReimbursementService srt;
	
	@BeforeAll
	public static void setup() {
		srt = new ReimbursementService();
	}

	@Test
	public void getByIDExists() throws RNotFoundException {
	
		R_status rs = new R_status();
		rs.setId(1);
		rs.setStatus("pending");
		
		R_type rt = new R_type();
		rt.setId(1);
		rt.setReim_type("lodging");
		
		Reimbursement rdaoExpected = new Reimbursement();
		rdaoExpected.setId(1);
		rdaoExpected.setAmount(19);
		rdaoExpected.setDescription("Reimbursement");
		rdaoExpected.setStatus_id(rs);
		rdaoExpected.setT_id(rt);
		
		Mockito.when((mockRDao).getReimbursementByResolverId(1)).thenReturn((List<Reimbursement>) rdaoExpected);
		
		Reimbursement rActual = (Reimbursement) srt.getReimbursementsByResolverId(1);
		
		assertEquals(rdaoExpected, rActual);
	}
	
	@Test
	public void getByIDNotExists() throws RNotFoundException {
 
		Mockito.when(mockRDao.getReimbursementByResolverId(3)).thenReturn(null);
		
		assertThrows(RNotFoundException.class, () -> (srt).getByID(3));
	}
	
	@Test
	public void updateExists() throws RNotUpdatedException {
		int userID = 4;
		Role role = new Role();
		role.setRole_id(2);
		role.setRole("manager");;

		User approverUser = new User();
		approverUser.setId(33);
		approverUser.setUsername("manager");
		approverUser.setPassword("12345");
		approverUser.setFirstName("Norbies");
		approverUser.setLastName("Golagles");;
		approverUser.setEmail("ngolagleyt@sourceforge.net");;
 		approverUser.setRole(role);
		
		R_status rs = new R_status();
		rs.setId(2);
		rs.setStatus("approved");
		int approverID = 33;
		
		boolean checkExpected = true;

 		Mockito.when(mockRDao.setStatusById(userID, approverUser, rs)).thenReturn(checkExpected);
		
 		
		boolean  booleanActual =srt.setStatusById(userID, approverID, "approved");
		assertEquals(booleanActual, checkExpected);
	}
	
	@Test
	public void updateNOTExists() throws RNotUpdatedException {
		int userID = 4000;
		Role role = new Role();
		role.setRole_id(2);
		role.setRole("manager");;

		User approverUser = new User();
		approverUser.setId(33);
		approverUser.setUsername("manager");
		approverUser.setPassword("12345");
		approverUser.setFirstName("Norbies");
		approverUser.setLastName("Golagles");;
		approverUser.setEmail("ngolagleyt@sourceforge.net");;
 		approverUser.setRole(role);
		
		R_status rs = new R_status();
		rs.setId(2);
		rs.setStatus("approved");
		int approverID = 33;
		
 		Mockito.when((mockRDao).setStatusById(userID, approverUser, rs)).thenReturn(false);
		
		assertThrows(RNotUpdatedException.class, () -> srt.setStatusById(userID, approverID, "approved"));
	}

}
