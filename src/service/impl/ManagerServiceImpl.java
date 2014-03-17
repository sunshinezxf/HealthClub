package service.impl;

import model.Data;
import model.Manager;
import dao.ManagerDAO;

public class ManagerServiceImpl {
	private ManagerDAO managerDAO;

	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	public Manager login(String username, String password) {
		return managerDAO.login(username, password);
	}

	public Data[] genderSum() {
		return managerDAO.genderSum();
	}
	
	
}
