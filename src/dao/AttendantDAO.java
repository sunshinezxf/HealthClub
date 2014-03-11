package dao;

import model.Attendant;

public interface AttendantDAO {
	public Attendant find(String column, String value);
}
