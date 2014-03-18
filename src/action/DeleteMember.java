package action;

import service.AttendantService;

@SuppressWarnings("serial")
public class DeleteMember extends BaseAction {
	private String v_id;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		int id = Integer.parseInt(v_id);
		boolean status = attendantService.deleteVIP(id);
		if (status) {
			request.setAttribute("prompt",
					"Congratulation! You succeed to delete a vip!");
			return "success";
		} else {
			request.setAttribute("prompt",
					"Sorry, something's wrong during the operation!");
			return "failure";
		}
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
}
