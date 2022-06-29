package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.OfferPostgres;
import com.revature.DAO.OffersDAO;
import com.revature.models.Offers;

public class PokeOfferService {
	private OffersDAO od = new OfferPostgres();
	private static Logger log = LogManager.getLogger(PokeOfferService.class);
	
	public List<Offers> getOffers() throws SQLException, IOException{
		return od.retrieveOffers();
	}
	
	public Offers ChangeOfferStatus(Offers o) throws SQLException, IOException{
		return od.updateOffer(o);
	}
	
	public Offers makeAnOffer(Offers o) throws IOException, SQLException{
		Offers os = od.makeAnOffer(o);
		log.info("Your offer " + os + " has been taken in.");
		return os;
	}

}
