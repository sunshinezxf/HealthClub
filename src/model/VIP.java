package model;

public abstract class VIP {
	private String code;
	private double price;

	public VIP() {
		code = "";
		price = 0;
	}

	public VIP(final String code, final double price) {
		this.code = code;
		this.price = price;
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

}
