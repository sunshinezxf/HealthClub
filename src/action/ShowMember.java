package action;

import java.util.ArrayList;

import model.VIP;
import service.AttendantService;

@SuppressWarnings("serial")
public class ShowMember extends BaseAction {
	private String a_id;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		ArrayList<VIP> vipList = attendantService.getVIPList();
		if (vipList == null) {
			System.out.println("No VIP Contained!");
			return "failure";
		} else {
			request.setAttribute("vipList", vipList);
			System.out.println("Num of VIPs: " + vipList.size());
			return "success";
		}
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
}
