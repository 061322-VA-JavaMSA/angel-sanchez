package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.DAO.OfferPostgres;
import com.revature.DAO.OffersDAO;
import com.revature.models.Offers;

public class PokeOfferService {
	private OffersDAO od = new OfferPostgres();
	
	public List<Offers> getOffers() throws SQLException, IOException{
		return od.retrieveOffers();
	}
	
	public Offers ChangeOfferStatus(Offers o) throws SQLException, IOException{
		return od.updateOffer(o);
	}
	
	public Offers makeOffer(Offers o) throws IOException, SQLException{
		return od.makeAnOffer(o);
	}

}
