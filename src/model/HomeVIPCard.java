package model;

public class HomeVIPCard extends VIPCard {
	private final static double ACTIVATE = 100;
	private final static double RENT_COUPLE = 55;
	private final static double RENT_CHILD = 10;

	public HomeVIPCard() {
		super();
		setActivatePrice(ACTIVATE);
	}

	public HomeVIPCard(String code) {
		setCode(code);
		activatePrice = ACTIVATE;
	}

	@Override
	public double calculatePrice() {
		return 0;
	}

}
