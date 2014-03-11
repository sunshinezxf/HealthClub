package action;

@SuppressWarnings("serial")
public class AttendantLogin extends BaseAction {
	private String a_id;
	private String password;

	public String execute() throws Exception {
		return null;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
