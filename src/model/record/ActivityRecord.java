package model.record;

import java.util.Calendar;

import model.Place;

public class ActivityRecord {
	private int ar_id;
	private int a_id;
	private int v_id;
	private int co_id;
	private Calendar date;
	private Place place;

	public int getAr_id() {
		return ar_id;
	}

	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public ActivityRecord() {
		date = null;
		place = null;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
