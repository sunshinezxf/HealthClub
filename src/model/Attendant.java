package model;

import java.util.ArrayList;

import model.record.ActivityRecord;
import model.record.PayRecord;
import util.manager.ActivityManager;
import util.manager.PayManager;
import util.manager.VIPManager;

public class Attendant {
	private String ad_id;
	private String ad_no;
	private String name;
	private String password;

	public Attendant() {
		ad_id = "";
		ad_no = "";
		name = "";
		password = "";
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_no() {
		return ad_no;
	}

	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VIP checkVIPInformation(String username) {
		return VIPManager.checkVIP(username);
	}

	public ArrayList<ActivityRecord> checkActivityRecord(String username) {
		return ActivityManager.checkActivityRecord(username);
	}
	
	public ArrayList<PayRecord> checkPayRecord(String username) {
		return PayManager.checkPayRecord(username);
	}
	
	public boolean modifyVIPInfomation(VIP vip) {
		return VIPManager.modifyVIP(vip);
	}
	
	public boolean modifyVIPActivityRecord(VIP vip) {
		return ActivityManager.modifyVIPActivityRecord(vip);
	}
	
	
}
