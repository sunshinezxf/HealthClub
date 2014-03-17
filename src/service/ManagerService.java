package service;

import model.Manager;

public interface ManagerService {
	public Manager login(String username, String password);

	public int[] genderSum();
}
