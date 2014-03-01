package model;

import util.IDGenerator;

public class HomeVIPCard extends VIPCard {
	private final static double ACTIVATE = 100;
	private final static double RENT_COUPLE = 55;
	private final static double RENT_CHILD = 10;

	public HomeVIPCard() {
		super();
		setCode(IDGenerator.generateHMVIP());
		setActivatePrice(ACTIVATE);
	}

	@Override
	public double calculatePrice() {
		return 0;
	}

}
