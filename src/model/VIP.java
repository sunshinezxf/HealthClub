package model;

import java.util.ArrayList;

import util.manager.ActivityManager;
import util.manager.PayManager;
import util.manager.VIPManager;
import model.card.VIPCard;
import model.record.ActivityRecord;
import model.record.PayRecord;

public class VIP {
	private String v_id;
	private ArrayList<VIPCard> cardList;
	private String username;
	private String name;
	private Gender gender;
	private Phone phone;
	private int age;
	private String password;
	private ArrayList<ActivityRecord> activityRecord;

	public VIP() {
		v_id = "";
		cardList = new ArrayList<VIPCard>();
		activityRecord = new ArrayList<ActivityRecord>();
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public ArrayList<VIPCard> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<VIPCard> cardList) {
		this.cardList = cardList;
	}

	public ArrayList<ActivityRecord> getActivityRecord() {
		return activityRecord;
	}

	public void setActivityRecord(ArrayList<ActivityRecord> activityRecord) {
		this.activityRecord = activityRecord;
	}

	public void addCard(VIPCard card) {
		cardList.add(card);
	}

	public ArrayList<VIPCard> removeCard(VIPCard card) {
		cardList.remove(card);
		return cardList;
	}

	/**
	 * function register *
	 * 
	 * @return whether the register action is success
	 */
	public boolean register() {
		if (username == null || username.equals(""))
			return false;
		if (name == null || name.equals(""))
			return false;
		if (age < 10 || age > 60)
			return false;
		return VIPManager.registerVIP(this);
	}

	/**
	 * function to modify vip information *
	 * 
	 * @param name
	 * @param password
	 * @return whether the modify action is success
	 */
	public boolean modifyInfo(String name, String password) {
		setName(name);
		setPassword(password);
		return true;
	}

	/**
	 * function to activate the card *
	 * 
	 * @param card
	 * @param money
	 * @return whether the activate action is success
	 */
	public boolean activate(VIPCard card, double money) {
		return card.activate(money);
	}

	/**
	 * function to pay the rent every month *
	 * 
	 * @param card
	 * @param money
	 * @return whether the pay action is success
	 */
	public boolean pay(VIPCard card, double money) {
		return card.pay(money);
	}

	/**
	 * * function to check the activity record of the vip himself/herself
	 * 
	 * @return the record list
	 */
	public ArrayList<ActivityRecord> checkActivityRecord() {
		return ActivityManager.checkActivityRecord(username);
	}

	/**
	 * function to check the pay record of the vip himself/herself *
	 * 
	 * @return the record list
	 */
	public ArrayList<PayRecord> checkPayRecord() {
		return PayManager.checkPayRecord(username);
	}

	/**
	 * function to cancel the vip himself/herself *
	 * 
	 * @return whether the action is success
	 */
	public boolean cancelVIP() {
		return VIPManager.cancelVIP(username);
	}

	/**
	 * function to reserve activity *
	 * 
	 * @param a_id
	 * @return whether the reserve action is success or not
	 */
	public boolean reserveActivity(String a_id) {
		return ActivityManager.reserveActivity(a_id, v_id);
	}
}
