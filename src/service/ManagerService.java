package service;

import model.Data;
import model.Manager;

public interface ManagerService {
	public Manager login(String username, String password);

	public Data[] genderSum();
}
