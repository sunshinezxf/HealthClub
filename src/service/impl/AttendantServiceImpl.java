package service.impl;

import model.Attendant;
import dao.AttendantDAO;
import service.AttendantService;

public class AttendantServiceImpl implements AttendantService {
	private AttendantDAO attendantDAO;

	public AttendantDAO getAttendantDAO() {
		return attendantDAO;
	}

	public void setAttendantDAO(AttendantDAO attendantDAO) {
		this.attendantDAO = attendantDAO;
	}

	public Attendant login(String username, String password) {
		Attendant attendant = attendantDAO.find("username", username);
		if (attendant == null)
			return null;
		if (attendant.getPassword().equals(password))
			return attendant;
		return null;
	}
}
