package com.revature.DAO;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offers;
import com.revature.models.Pokemon;
import com.revature.util.ConnectionUtil;

public class PokemonPostgres implements PokemonDAO{

	@Override
	public Pokemon createPokemon(Pokemon p) throws IOException {
		String sql = "insert into pokemon (p_name, price, description) values (?,?,?) returning p_id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getpName());
			ps.setInt(2, p.getPrice());
			ps.setString(3, p.getDescription());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				p.setpId(rs.getInt("p_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Pokemon> retrievePokemon() throws SQLException, IOException {
		// TODO Auto-generated method stub
		// retrieving all pokemon from the pokemon table
		String sql = "select * from pokemon order by p_id;";
		List<Pokemon> pokemon = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()) {
			java.sql.Statement s = c.createStatement();
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while(rs.next()) {
				Pokemon p = new Pokemon();
				p.setpId(rs.getInt("p_id"));
				p.setpName(rs.getString("p_name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));
				p.setOwnerId(rs.getInt("owner_id"));
				pokemon.add(p);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pokemon;
	}
	
	public boolean deletePokemon(int id) throws IOException {
		String sql = "delete from pokemon where p_id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

	
}
