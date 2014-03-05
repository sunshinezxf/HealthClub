package service;

import model.VIP;
import model.card.HomeVIPCard;
import model.card.SingleVIPCard;

public interface VIPService {
	public boolean registerVIP(VIP vip);

	public boolean login(String username, String password);

	public SingleVIPCard applySGCard(String sg_id, int v_id);

	public HomeVIPCard applyHMCard(String hm_id, int v_id);

	public boolean cancelVIP(String username);

	public VIP checkVIP(String column, String value);

	public boolean modifyVIP(VIP vip);
}
