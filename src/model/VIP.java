package model;

public abstract class VIP {
	private String code;
	private double price;
	private VIPType type;

	public VIP() {
		code = "";
		price = 0;
		type = null;
	}

	public VIP(final String code, final double price, final VIPType type) {
		this.code = code;
		this.price = price;
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public abstract void calculatePrice();

	public void setType(VIPType type) {
		this.type = type;
	}

	public VIPType getType() {
		return type;
	}
}
