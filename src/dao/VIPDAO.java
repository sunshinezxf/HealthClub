package dao;

import model.VIP;

public interface VIPDAO {
	public boolean addVIP(VIP vip);
	
	public boolean deleteVIP(String username);
	
	public VIP find(String column, String value);
	
	public boolean update(VIP vip);
}
