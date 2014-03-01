package model;

import java.util.Calendar;

public class ActivityRecord {
	private Calendar date;
	private VIP vip;
	private Place place;

	public ActivityRecord() {
		date = null;
		vip = new VIP();
		place = null;
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
