package dao;

import java.util.ArrayList;

import model.Activity;
import model.Attendant;
import model.VIP;
import model.record.ActivityRecord;

public interface AttendantDAO {
	public Attendant find(String column, String value);

	public ArrayList<VIP> getVIP();

	public VIP check(int v_id);

	public boolean addActivity(Activity activity);

	public ArrayList<Activity> checkActivities(int a_id);

	public boolean update(VIP vip);

	public boolean deleteVIP(int v_id);

	public Activity view(int ac_id);
	
	public ArrayList<ActivityRecord> getRecord(int ac_id);
}
