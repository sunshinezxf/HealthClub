package action;

import model.VIP;
import service.AttendantService;

@SuppressWarnings("serial")
public class ViewMember extends BaseAction {
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
		VIP vip = attendantService.check(id);
		request.setAttribute("vip", vip);
		if (vip == null) {
			return "failure";
		}
		return "success";
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
}
