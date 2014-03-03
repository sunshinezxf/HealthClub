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

	public String execute() throws Exception {
		String v_id = IDGenerator.generateV_id();
		VIP vip = new VIP();
		vip.setV_id(v_id);
		vip.setName(name);
		return null;
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
}
