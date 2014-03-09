package service;

import java.util.ArrayList;

import model.VIP;
import model.card.HomeVIPCard;
import model.card.SingleVIPCard;
import model.card.VIPCard;

public interface VIPService {
	public boolean registerVIP(VIP vip);

	public boolean login(String username, String password);

	public ArrayList<VIPCard> viewCard(int v_id);

	public SingleVIPCard applySGCard(String sg_id, int v_id);

	public HomeVIPCard applyHMCard(String hm_id, int v_id);

	public boolean cancelVIP(String username);

	public VIP checkVIP(String column, String value);

	public boolean modifyVIP(VIP vip);
	
	public boolean withdrawVIP(int v_id);
}
