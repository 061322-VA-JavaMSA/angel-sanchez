package com.revature.DAO;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDAO{
	
	@Override
	public User createUser(User u) throws IOException{
		String sql = "insert into users (username, password, isAdmin) values (?,?,?) returning id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setBoolean(3, u.getAdmin());
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				u.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	
	@Override
	public User retrieveUserById(int id) {
		String sql = "select * from users where id = ?;";
		User user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st ? in the sql String
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> retrieveUsers(){
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			// no user inout taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				// extract each field from rs for each record, map them to a User object and add them to the users array list
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
			}
	
	@Override
	public User retrieveUserByUsername(String username) throws IOException{
		String sql = "select * from users where username  = ?;";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAdmin(rs.getBoolean("isAdmin"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	
//	@Override
//	public User retrieveUserById(int id) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
//	@Override
//	public boolean updateUser(User u) {
//		String sql = "update users set username = ?, password = ? where id = ?;";
//		int rowsChanged = -1;
//		
//		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
//			PreparedStatement ps = c.prepareStatement(sql);
//			
//			ps.setString(1, u.getUsername());
//			ps.setString(2, u.getPassword());
//			ps.setInt(3, u.getId());
//			
//			rowsChanged = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(rowsChanged < 1) {
//			return false;
//		}
//		return true;
//	}
	
//	@Override
//	public boolean deleteUserById(int id) {
//		String sql = "delete from users where id = ?;";
//		int rowsChanged = -1;
//		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
//			PreparedStatement ps = c.prepareStatement(sql);
//			
//			ps.setInt(1, id);
//			
//			rowsChanged = ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if(rowsChanged < 1) {
//			return false;
//		}
//		return true;
//	}

}