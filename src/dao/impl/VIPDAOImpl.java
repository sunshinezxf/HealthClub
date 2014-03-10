package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BaseDAO;
import dao.VIPDAO;
import model.CreditCard;
import model.Gender;
import model.Phone;
import model.VIP;
import model.card.CardType;
import model.card.HomeVIPCard;
import model.card.SingleVIPCard;
import model.card.VIPCard;

public class VIPDAOImpl implements VIPDAO {
	private BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public boolean addVIP(VIP vip) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String username = vip.getUsername();
		String name = vip.getName();
		String gender = (vip.getGender() == Gender.MALE) ? "male" : "female";
		String phone = vip.getPhone().getNo();
		int age = vip.getAge();
		String password = vip.getPassword();
		String cr_no = vip.getCreditCard().getCr_no();
		String sql = "insert into vip(username, name, gender, phone, age, password, cr_no) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, phone);
			ps.setInt(5, age);
			ps.setString(6, password);
			ps.setString(7, cr_no);
			int i = ps.executeUpdate();
			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return false;
	}

	public boolean deleteVIP(String username) {
		Connection connection = baseDAO.getConnection();
		String sql = "delete from vip where username = ?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return false;
	}

	public VIP find(String column, String value) {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from vip where " + column + " = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection inner_con = null;
		PreparedStatement inner_ps = null;
		ResultSet inner_rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, value);
			rs = ps.executeQuery();
			rs.beforeFirst();
			if (rs.next()) {
				VIP vip = new VIP();
				int t_v_id = rs.getInt(1);
				String t_username = rs.getString(2);
				String t_name = rs.getString(3);
				String t_gender_string = rs.getString(4);
				Gender t_gender = (t_gender_string.equals("male")) ? Gender.MALE
						: Gender.FEMALE;
				String t_phone_string = rs.getString(5);
				Phone t_phone = new Phone(t_phone_string);
				int t_age = rs.getInt(6);
				String t_password = rs.getString(7);
				String cr_no = rs.getString(8);
				String inner_sql = "select * from credit where cr_no = ?";
				inner_con = baseDAO.getConnection();
				inner_ps = inner_con.prepareStatement(inner_sql);
				inner_ps.setString(1, cr_no);
				inner_rs = inner_ps.executeQuery();
				inner_rs.beforeFirst();
				if (inner_rs.next()) {
					CreditCard credit = new CreditCard();
					double balance = inner_rs.getDouble(2);
					credit.setCr_no(cr_no);
					credit.setBalance(balance);
					vip.setCreditCard(credit);
				}
				vip.setV_id(t_v_id);
				vip.setUsername(t_username);
				vip.setName(t_name);
				vip.setGender(t_gender);
				vip.setPhone(t_phone);
				vip.setAge(t_age);
				vip.setPassword(t_password);
				return vip;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(inner_rs);
			baseDAO.closePreparedStatement(inner_ps);
			baseDAO.closeConnection(inner_con);
			baseDAO.closeResultSet(rs);
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return null;
	}

	public boolean update(VIP vip) {
		return true;
	}

	public ArrayList<VIPCard> viewCard(int v_id) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from card where v_id = ?";
		ResultSet rs = null;
		ArrayList<VIPCard> cardList = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			cardList = new ArrayList<VIPCard>();
			while (rs.next()) {
				VIPCard card = null;
				String cardType = rs.getString(4);
				if (cardType.equals("SG")) {
					card = new SingleVIPCard();
				} else {
					card = new HomeVIPCard();
				}
				int c_id = rs.getInt(1);
				String c_code = rs.getString(2);
				String c_token = rs.getString(3);
				String c_type = rs.getString(4);
				boolean c_activated = rs.getBoolean(5);
				boolean c_payed = rs.getBoolean(6);
				double c_activatePrice = rs.getDouble(7);
				double c_rent = rs.getDouble(8);
				card.setC_id(c_id);
				card.setCode(c_code);
				card.setToken(c_token);
				CardType type = (c_type.equals("SG")) ? CardType.SINGLE
						: CardType.HOME;
				card.setType(type);
				card.setActivated(c_activated);
				card.setPayed(c_payed);
				card.setActivatePrice(c_activatePrice);
				card.setRent(c_rent);
				card.setV_id(v_id);
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs);
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		if (cardList.size() == 0)
			return null;
		return cardList;
	}

	public boolean deleteVIP(int v_id) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from vip where v_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v_id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return false;
	}

	public boolean applySG(VIPCard card) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String code = card.getCode();
		String token = card.getToken();
		String type = (card.getType() == CardType.SINGLE) ? "SG" : "HM";
		boolean activated = card.getActivated();
		boolean payed = card.getPayed();
		double activatePrice = card.getActivatePrice();
		double rent = card.getRent();
		int v_id = card.getV_id();
		String sql = "insert into card(code, token, type, activated, payed, activatePrice, rent, v_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, token);
			ps.setString(3, type);
			ps.setBoolean(4, activated);
			ps.setBoolean(5, payed);
			ps.setDouble(6, activatePrice);
			ps.setDouble(7, rent);
			ps.setInt(8, v_id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return false;
	}
}
