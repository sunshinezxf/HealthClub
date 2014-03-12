package service;

import java.util.ArrayList;

import model.Attendant;
import model.VIP;

public interface AttendantService {
	public Attendant login(String username, String password);
	
	public ArrayList<VIP> getVIPList();
}
