package service.impl;

import java.util.ArrayList;

import model.Activity;
import model.Attendant;
import model.VIP;
import model.record.ActivityRecord;
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

	public boolean addActivity(Activity activity) {
		return attendantDAO.addActivity(activity);
	}

	public ArrayList<Activity> checkActivities(int a_id) {
		return attendantDAO.checkActivities(a_id);
	}

	public boolean update(VIP vip) {
		return attendantDAO.update(vip);
	}

	public boolean deleteVIP(int v_id) {
		return attendantDAO.deleteVIP(v_id);
	}

	public Activity viewActivity(int ac_id) {
		return attendantDAO.view(ac_id);
	}

	public ArrayList<ActivityRecord> getRecord(int ac_id) {
		return attendantDAO.getRecord(ac_id);
	}
}
