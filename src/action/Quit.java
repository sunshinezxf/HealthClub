package action;

@SuppressWarnings("serial")
public class Quit extends BaseAction {
	private String v_id;

	public String execute() throws Exception {
		session.clear();
		return "success";
	}

	public String getV_id() {
		return v_id;
	}

	public void setId(String v_id) {
		this.v_id = v_id;
	}
}
