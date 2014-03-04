package service.impl;

import model.VIP;
import service.VIPService;
import dao.VIPDAO;

public class VIPServiceImpl implements VIPService {
	private VIPDAO vipDAO;

	public VIPDAO getVIPDAO() {
		return vipDAO;
	}

	public void setVIPDAO(VIPDAO vipDAO) {
		this.vipDAO = vipDAO;
	}

	public boolean registerVIP(VIP vip) {
		if (vip.getUsername() == null || vip.getUsername().equals(""))
			return false;
		if (vip.getName() == null || vip.getName().equals(""))
			return false;
		if (vip.getAge() < 10 || vip.getAge() > 60)
			return false;
		return vipDAO.addVIP(vip);
	}

	public boolean cancelVIP(String username) {
		return vipDAO.deleteVIP(username);
	}

	public VIP checkVIP(String column, String value) {
		return vipDAO.find(column, value);
	}

	public boolean modifyVIP(VIP vip) {
		return vipDAO.update(vip);
	}
}
