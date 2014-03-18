package service;

import java.util.ArrayList;

import model.Activity;
import model.Attendant;
import model.VIP;
import model.record.ActivityRecord;

public interface AttendantService {
	public Attendant login(String username, String password);

	public ArrayList<VIP> getVIPList();

	public VIP check(int v_id);
	
	public boolean addActivity(Activity activity);
	
	public ArrayList<Activity> checkActivities(int a_id);
	
	public boolean update(VIP vip);
	
	public boolean deleteVIP(int v_id);
	
	public Activity viewActivity(int ac_id);
	
	public ArrayList<ActivityRecord> getRecord(int ac_id);
}
