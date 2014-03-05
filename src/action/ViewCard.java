package action;

import java.util.ArrayList;

import model.card.VIPCard;
import service.VIPService;

@SuppressWarnings("serial")
public class ViewCard extends BaseAction {
	String v_id;
	private VIPService vipService;

	public VIPService getVIPService() {
		return vipService;
	}

	public void setVIPService(VIPService vipService) {
		this.vipService = vipService;
	}

	public String execute() throws Exception {
		int id = Integer.parseInt(v_id);
		ArrayList<VIPCard> cardList = vipService.viewCard(id);
		if (cardList == null) {
			System.out.println("用户当前还没有会员卡!");
		} else {
			System.out.println("您当前拥有" + cardList.size() + "张会员卡");
		}
		return "success";
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
}
