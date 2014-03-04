package action;

import service.VIPService;
import util.IDGenerator;

@SuppressWarnings("serial")
public class ApplySGVIP extends BaseAction {
	private String cardType;
	private VIPService vipService;
	private int v_id;

	public VIPService getVIPService() {
		String sg_id = IDGenerator.generateSGVIP();
		vipService.applySGCard(sg_id, v_id);
		return vipService;
	}

	public void setVIPService(VIPService vipService) {
		this.vipService = vipService;
	}

	public String execute() throws Exception {
		return null;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
