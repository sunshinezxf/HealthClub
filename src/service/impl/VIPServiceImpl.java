package service.impl;

import java.util.ArrayList;

import model.VIP;
import model.card.HomeVIPCard;
import model.card.VIPCard;
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

	public boolean login(String username, String password) {
		VIP vip = vipDAO.find("username", username);
		if (vip == null)
			return false;
		if (vip.getPassword().equals(password))
			return true;
		return false;
	}

	public ArrayList<VIPCard> viewCard(int v_id) {
		return vipDAO.viewCard(v_id);
	}

	public boolean applySGCard(VIPCard card) {
		return vipDAO.applySG(card);
	}

	public HomeVIPCard applyHMCard(String hm_id, int v_id) {
		return null;
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

	public boolean withdrawVIP(int v_id) {
		return true;
	}

	public VIP requestActivate(int c_id, int v_id) {
		return vipDAO.request(c_id, v_id);
	}

	public VIP requestPay(int c_id, int v_id) {
		return vipDAO.request(c_id, v_id);
	}
}
