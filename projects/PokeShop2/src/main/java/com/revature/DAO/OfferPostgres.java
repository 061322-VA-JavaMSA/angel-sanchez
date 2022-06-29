package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offers;
import com.revature.models.Pokemon;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OffersDAO{
	
	public List<Offers> retrieveOffers() throws SQLException, IOException {
		String sql = "select * from offers;";
		List<Offers> offers = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Offers o = new Offers();
				o.setOfferId(rs.getInt("offer_id"));
				o.setStatus(rs.getString("status"));
				o.setpId(rs.getInt("p_id"));
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
	public Offers updateOffer(Offers o) throws SQLException, IOException{
		String sql = "update offers set status = (?) where offer_id = (?);";
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, o.getStatus());
			ps.setInt(2, o.getOfferId());
			ps.executeUpdate();
//			ResultSet rs = ps.executeQuery(sql);
//
//			while(rs.next()) {
//				((Offers) ps).setStatus(rs.getString("status"));
//
//			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@Override
	public Offers makeAnOffer(Offers o){
		String sql = "insert into offers (p_id, amount, user_id) values (?,?,?) returning offer_id, p_id, amount, user_id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getpId());
			ps.setInt(2, o.getAmount());
			ps.setInt(3, o.getUserId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				o.setOfferId(rs.getInt("offer_id"));
				o.setpId(rs.getInt("p_id"));
				o.setAmount(rs.getInt("amount"));
				o.setUserId(rs.getInt("user_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

}
