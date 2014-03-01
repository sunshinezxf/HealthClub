package model;

import java.util.ArrayList;

public class SingleVIP {
	private ArrayList<VIPCard> cardList;
	private String name;
	private String password;

	public SingleVIP() {
		cardList = new ArrayList<VIPCard>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<VIPCard> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<VIPCard> cardList) {
		this.cardList = cardList;
	}

	public void addCard(VIPCard card) {
		cardList.add(card);
	}

	public ArrayList<VIPCard> removeCard(VIPCard card) {
		cardList.remove(card);
		return cardList;
	}

	/**
	 * function register *
	 * 
	 * @param name
	 * @param password
	 * @return whether the register action is success
	 */
	public boolean register(String name, String password) {
		setName(name);
		setPassword(password);
		return true;
	}

	/**
	 * function to modify vip information *
	 * 
	 * @param name
	 * @param password
	 * @return whether the modify action is success
	 */
	public boolean modifyInfo(String name, String password) {
		setName(name);
		setPassword(password);
		return true;
	}

	public boolean pay(VIPCard card, double money) {

		return true;
	}
}
