package com.revature.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Offers;

public interface OffersDAO {
	
	List<Offers> retrieveOffers() throws SQLException, IOException;
	
	boolean updateOffer(Offers o);
	
}
