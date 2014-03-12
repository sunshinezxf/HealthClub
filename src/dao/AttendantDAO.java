package dao;

import java.util.ArrayList;

import model.Attendant;
import model.VIP;

public interface AttendantDAO {
	public Attendant find(String column, String value);
	
	public ArrayList<VIP> getVIP();
}
