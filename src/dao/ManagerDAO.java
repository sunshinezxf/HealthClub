package dao;

import model.Manager;

public interface ManagerDAO {
	public Manager login(String username, String password);
}
