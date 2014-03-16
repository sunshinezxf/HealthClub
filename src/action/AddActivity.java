package action;

import java.util.Date;

import model.Activity;
import model.Place;
import service.AttendantService;

@SuppressWarnings("serial")
public class AddActivity extends BaseAction {
	private String ac_name;
	private String location;
	private String start;
	private String end;
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

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		Activity activity = new Activity();
		activity.setAc_name(ac_name);
		System.out.println(ac_name);
		Place place = new Place(location);
		System.out.println(place.getLocation());
		activity.setPlace(place);
		System.out.println(start);
		System.out.println(end);
		String[] startDateString = start.split("-");
		@SuppressWarnings("deprecation")
		Date startDate = new Date(Integer.parseInt(startDateString[0]),
				Integer.parseInt(startDateString[1]),
				Integer.parseInt(startDateString[2]));
		System.out.println(startDate.getYear());
		return "failure";
	}

}
