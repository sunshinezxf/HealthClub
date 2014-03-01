package model;

public abstract class VIPCard {
	private String code;
	protected double activatePrice;
	protected double rent;
	private String token;
	private CardType type;
	private boolean activated = false;
	private boolean payed = false;

	public VIPCard() {
		code = "";
		activatePrice = 0;
		rent = 0;
		token = "";
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

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public CardType getType() {
		return type;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean getActivated() {
		return activated;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public boolean getPayed() {
		return payed;
	}

	public boolean activate(double money) {
		if (money >= activatePrice)
			activated = true;
		else
			activated = false;
		return activated;
	}

	public boolean pay(double money) {
		if (money >= rent)
			payed = true;
		else
			payed = false;
		return payed;
	}

	public CardType distinguishCardType() {
		if (code.startsWith("SG"))
			return CardType.SINGLE;
		if (code.startsWith("HM"))
			return CardType.HOME;
		return null;
	}
}
