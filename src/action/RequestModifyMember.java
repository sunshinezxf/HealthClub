package action;

import service.AttendantService;

@SuppressWarnings("serial")
public class RequestModifyMember extends BaseAction{
	private String v_id;
	private AttendantService attendantService;
	
	public AttendantService getAttendantService() {
		return attendantService;
	}
	
	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}
	
	public String execute() throws Exception {
		return "success";
	}
	
	public String getV_id() {
		return v_id;
	}
	
	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
}
