package com.revature.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Offers;
import com.revature.models.Pokemon;
//import com.revature.models.Pokemon;

public interface OffersDAO {
	
	List<Offers> retrieveOffers() throws SQLException, IOException;
	
	public Offers updateOffer(Offers o) throws SQLException, IOException;
	
	Offers makeAnOffer(Offers o) throws SQLException, IOException;
	
}
