package action;

import java.util.ArrayList;

import model.Activity;
import service.AttendantService;

@SuppressWarnings("serial")
public class ShowActivity extends BaseAction {
	private String a_id;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		int attendant_id = Integer.parseInt(a_id);
		ArrayList<Activity> activities = attendantService
				.checkActivities(attendant_id);
		request.setAttribute("activities", activities);
		return "success";
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
}
