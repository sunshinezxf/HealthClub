package dao;

import java.util.ArrayList;

import model.VIP;
import model.card.VIPCard;

public interface VIPDAO {
	public boolean addVIP(VIP vip);
	
	public boolean deleteVIP(String username);
	
	public VIP find(String column, String value);
	
	public boolean update(VIP vip);
	
	public ArrayList<VIPCard> viewCard(int v_id);
	
	public boolean deleteVIP(int v_id);
}
