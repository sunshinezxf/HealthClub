package util.manager;

import model.VIP;
import dao.VIPDAO;

public class VIPManager {

	public static boolean registerVIP(VIP vip) {
		return VIPDAO.addVIP(vip);
	}

	public static boolean cancelVIP(String username) {
		return VIPDAO.deleteVIP(username);
	}

	public static VIP checkVIP(String username) {
		return VIPDAO.find(username);
	}

	public static boolean modifyVIP(VIP vip) {
		return VIPDAO.modifyVIP(vip);
	}
}
