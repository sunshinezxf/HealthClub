package model;

public abstract class VIPCard {
	private String code;
	private double activatePrice;
	private double rent;
	private CardType type;

	public VIPCard() {
		code = "";
		activatePrice = 0;
		rent = 0;
		type = null;
	}

	public VIPCard(final String code, final double activatePrice, final double rent, final CardType type) {
		this.code = code;
		this.activatePrice = activatePrice;
		this.rent = rent;
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setActivatePrice(double activatePrice) {
		this.activatePrice = activatePrice;
	}
	
	public double getActivatePrice() {
		return activatePrice;
	}
	
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	public double getRent() {
		return rent;
	}
	
	public abstract void calculatePrice();

	public void setType(CardType type) {
		this.type = type;
	}

	public CardType getType() {
		return type;
	}
}
