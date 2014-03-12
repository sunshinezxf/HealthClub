package service.impl;

import java.util.ArrayList;

import model.Attendant;
import model.VIP;
import service.AttendantService;
import dao.AttendantDAO;

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

	public ArrayList<VIP> getVIPList() {
		return attendantDAO.getVIP();
	}

	public VIP check(int v_id) {
		return attendantDAO.check(v_id);
	}
}
