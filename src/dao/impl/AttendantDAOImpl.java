package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Attendant;
import model.CreditCard;
import model.Gender;
import model.Phone;
import model.VIP;
import dao.AttendantDAO;
import dao.BaseDAO;

public class AttendantDAOImpl implements AttendantDAO {
	private BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public Attendant find(String column, String value) {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from attendant where " + column + " = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, value);
			rs = ps.executeQuery();
			rs.beforeFirst();
			if (rs.next()) {
				Attendant attendant = new Attendant();
				int a_id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				attendant.setA_id(a_id);
				attendant.setUsername(username);
				attendant.setPassword(password);
				attendant.setName(name);
				return attendant;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs);
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return null;
	}

	public ArrayList<VIP> getVIP() {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from vip order by v_id, type";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection inner_con = null;
		PreparedStatement inner_ps = null;
		ResultSet inner_rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<VIP> vipList = new ArrayList<VIP>();
			rs.beforeFirst();
			while (rs.next()) {
				VIP vip = new VIP();
				int v_id = rs.getInt(1);
				String username = rs.getString(2);
				String name = rs.getString(3);
				String gender_string = rs.getString(4);
				Gender gender = (gender_string.equals("male")) ? Gender.MALE
						: Gender.FEMALE;
				String phone_string = rs.getString(5);
				Phone phone = new Phone(phone_string);
				int age = rs.getInt(6);
				String password = rs.getString(7);
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
				baseDAO.closeResultSet(inner_rs);
				baseDAO.closePreparedStatement(inner_ps);
				baseDAO.closeConnection(inner_con);
				vip.setV_id(v_id);
				vip.setUsername(username);
				vip.setName(name);
				vip.setGender(gender);
				vip.setPhone(phone);
				vip.setAge(age);
				vip.setPassword(password);
				vipList.add(vip);
			}
			if (vipList.size() > 0) {
				return vipList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs);
			baseDAO.closePreparedStatement(ps);
			baseDAO.closeConnection(connection);
		}
		return null;
	}
}
