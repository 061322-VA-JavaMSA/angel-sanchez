package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offers;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OffersDAO{
	
	public List<Offers> retrieveOffers() throws SQLException, IOException {
		String sql = "select * from offers;";
		List<Offers> offers = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv();) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Offers o = new Offers();
				o.setOfferId(rs.getInt("offer_id"));
				o.setStatus(rs.getString("status"));
				o.setItemId(rs.getInt("item_id"));
				o.setAmount(rs.getInt("amount"));
				o.setUserId(rs.getInt("user_id"));
				offers.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

	@Override
	public boolean updateOffer(Offers o) {
		return false;
	}

}
