package model;

public class SingleVIP extends VIP {
	public SingleVIP() {
		super();
		setType(VIPType.SINGLE);
	}

	public SingleVIP(String code, double price) {
		super(code, price, VIPType.SINGLE);
	}

	@Override
	public void calculatePrice() {

	}

	@Override
	public void setType(VIPType type) {

	}

}
