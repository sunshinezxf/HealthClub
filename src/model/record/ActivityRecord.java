package model.record;

import java.util.Calendar;

import model.Place;
import model.VIP;

public class ActivityRecord {
	private String a_id;
	private Calendar date;
	private VIP vip;
	private Place place;

	public ActivityRecord() {
		a_id = "";
		date = null;
		vip = new VIP();
		place = null;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public VIP getVip() {
		return vip;
	}

	public void setVip(VIP vip) {
		this.vip = vip;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
