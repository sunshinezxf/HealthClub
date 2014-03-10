package service.impl;

import dao.CardDAO;
import service.CardService;

public class CardServiceImpl implements CardService {
	private CardDAO cardDAO;

	public CardDAO getCardDAO() {
		return cardDAO;
	}

	public void setCardDAO(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

	public boolean deleteCard(int c_id) {
		return cardDAO.delete(c_id);
	}
}
