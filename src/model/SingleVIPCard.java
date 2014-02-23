package model;

public class SingleVIPCard extends VIPCard {
	private final static double ACTIVATE = 75;
	private final static double RENT = 40;

	public SingleVIPCard() {
		super();
		setActivatePrice(ACTIVATE);
		setRent(RENT);
	}

	public SingleVIPCard(String code) {
		setCode(code);
		activatePrice = ACTIVATE;
		rent = RENT;
		setType(CardType.SINGLE);
	}

	@Override
	public double calculatePrice() {
		return rent;
	}

}
