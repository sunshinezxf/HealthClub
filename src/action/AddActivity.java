package action;

import java.util.Date;

import model.Activity;
import model.Attendant;
import model.Place;
import service.AttendantService;

@SuppressWarnings("serial")
public class AddActivity extends BaseAction {
	private String ac_name;
	private String location;
	private String start;
	private String end;
	private String co_no;
	private AttendantService attendantService;

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCo_no() {
		return co_no;
	}

	public void setCo_no(String co_no) {
		this.co_no = co_no;
	}

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		Activity activity = new Activity();
		int a_id = ((Attendant) session.get("attendant")).getA_id();
		Place place = new Place(location);
		String[] startDateString = start.split("-");
		String[] endDateString = end.split("-");
		@SuppressWarnings("deprecation")
		Date startDate = new Date(Integer.parseInt(startDateString[0]) - 1900,
				Integer.parseInt(startDateString[1]) - 1,
				Integer.parseInt(startDateString[2]));
		@SuppressWarnings("deprecation")
		Date endDate = new Date(Integer.parseInt(endDateString[0]) - 1900,
				Integer.parseInt(endDateString[1]) - 1,
				Integer.parseInt(endDateString[2]));
		activity.setAc_name(ac_name);
		activity.setPlace(place);
		activity.setStartDate(startDate);
		activity.setEndDate(endDate);
		activity.setA_id(a_id);
		activity.setCoach_no(co_no);
		boolean status = attendantService.addActivity(activity);
		if (status) {
			request.setAttribute("prompt",
					"Congratulation! You succeed to publish a new activity!");
			return "success";
		} else {
			request.setAttribute("prompt",
					"Sorry, something's wrong during the operation.");
			return "failure";
		}
	}

}
