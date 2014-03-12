package action;

import model.Attendant;
import service.AttendantService;

@SuppressWarnings("serial")
public class AttendantLogin extends BaseAction {
	private String username;
	private String password;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		System.out.println("haha");
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		Attendant attendant = attendantService.login(username, password);
		if (attendant == null) {
			return "failure";
		} else {
			session.put("attendant", attendant);
			return "success";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
