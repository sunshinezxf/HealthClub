package action;

import java.util.ArrayList;

import model.Activity;
import model.record.ActivityRecord;
import service.AttendantService;

@SuppressWarnings("serial")
public class RequestModifyActivity extends BaseAction {
	private String a_id;
	private String ac_id;
	private AttendantService attendantService;

	public AttendantService getAttendantService() {
		return attendantService;
	}

	public void setAttendantService(AttendantService attendantService) {
		this.attendantService = attendantService;
	}

	public String execute() throws Exception {
		Activity activity = attendantService.viewActivity(Integer
				.parseInt(ac_id));
		if (activity == null) {
			request.setAttribute("prompt", "Activity Not Exist!");
			return "failure";
		} else {
			request.setAttribute("activity", activity);
			ArrayList<ActivityRecord> records = attendantService
					.getRecord(Integer.parseInt(ac_id));
			request.setAttribute("record", records);
			return "success";
		}
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}
}
