package service;

import model.VIP;

public interface VIPService {
	public boolean registerVIP(VIP vip);

	public boolean cancelVIP(String username);

	public VIP checkVIP(String column, String value);

	public boolean modifyVIP(VIP vip);
}
