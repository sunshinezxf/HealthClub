package model;

public abstract class VIPCard {
	private String code;
	protected double activatePrice;
	protected double rent;
	private CardType type;

	public VIPCard() {
		code = "";
		activatePrice = 0;
		rent = 0;
		type = null;
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

	public abstract double calculatePrice();

	public void setType(CardType type) {
		this.type = type;
	}

	public CardType getType() {
		return type;
	}
}
