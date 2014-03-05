package action;

import model.card.SingleVIPCard;
import service.VIPService;
import util.IDGenerator;

@SuppressWarnings("serial")
public class ApplySGVIP extends BaseAction {
	private String cardType;
	private VIPService vipService;
	private int v_id;

	public VIPService getVIPService() {
		return vipService;
	}

	public void setVIPService(VIPService vipService) {
		this.vipService = vipService;
	}

	public String execute() throws Exception {
		v_id = (Integer)session.get("v_id");
		String sg_id = IDGenerator.generateSGVIP();
		SingleVIPCard card = vipService.applySGCard(sg_id, v_id);
		if(card == null) {
			return "failure";
		}
		else {
			
		}
		return null;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
