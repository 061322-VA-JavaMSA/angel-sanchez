package dao;

import model.User;

public class UserDAO {
	public abstract User insertUser(User u);
	public abstract User getById(int id);

}
