package action;

import model.Activity;
import model.Place;
import service.AttendantService;

@SuppressWarnings("serial")
public class ConfirmActivity extends BaseAction {
	private String ac_id;
	private String ac_name;
	private String a_id;
	private String location;
	private String startDate;
	private String endDate;
	private String coach_no;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		Activity activity = new Activity();
		activity.setA_id(Integer.parseInt(a_id));
		activity.setAc_name(ac_name);
		activity.setAc_id(Integer.parseInt(ac_id));
		activity.setPlace(new Place(location));

		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		return "success";
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCoach_no() {
		return coach_no;
	}

	public void setCoach_no(String coach_no) {
		this.coach_no = coach_no;
	}

}
