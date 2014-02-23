package model;

public class SingleVIPCard extends VIPCard {
	
	public SingleVIPCard() {
		super();
		setActivatePrice(75);
		setRent(40);
	}

	@Override
	public void calculatePrice() {

	}

	@Override
	public void setType(CardType type) {

	}

}
