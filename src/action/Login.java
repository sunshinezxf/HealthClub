package action;

@SuppressWarnings("serial")
public class Login extends BaseAction {
	private String username;
	private String password;

	public String execute() throws Exception {
		return null;
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
