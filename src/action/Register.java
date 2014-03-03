package action;

import model.Gender;
import model.Phone;
import model.VIP;
import util.IDGenerator;

@SuppressWarnings("serial")
public class Register extends BaseAction {
	private String name;
	private Gender gender;
	private Phone phone;
	private int age;
	private String password;

	public String execute() throws Exception {
		String username = IDGenerator.generateUsername();
		VIP vip = new VIP();
		vip.setUsername(username);
		vip.setName(name);
		vip.setPassword(password);
		boolean status = vip.register();
		if (status)
			return "success";
		return "failure";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
