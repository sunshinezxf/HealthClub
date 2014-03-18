package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Activity;
import model.Attendant;
import model.CreditCard;
import model.Gender;
import model.Phone;
import model.Place;
import model.VIP;
import model.card.HomeVIPCard;
import model.card.SingleVIPCard;
import model.card.VIPCard;
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
		String sql = "select * from vip order by v_id";
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

	public VIP check(int v_id) {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from vip where v_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			if (rs.next()) {
				VIP vip = new VIP();
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
				String address = rs.getString(9);
				Connection inner_con = baseDAO.getConnection();
				String s_1 = "select * from credit where cr_no = ?";
				PreparedStatement inner_ps = null;
				ResultSet inner_rs = null;
				inner_ps = inner_con.prepareStatement(s_1);
				inner_ps.setString(1, cr_no);
				inner_rs = inner_ps.executeQuery();
				inner_rs.beforeFirst();
				if (inner_rs.next()) {
					CreditCard card = new CreditCard();
					double balance = inner_rs.getDouble(2);
					card.setCr_no(cr_no);
					card.setBalance(balance);
					vip.setCreditCard(card);
				}
				String s_2 = "select * from card where v_id = ?";
				inner_ps = inner_con.prepareStatement(s_2);
				inner_ps.setInt(1, v_id);
				ArrayList<VIPCard> cardList = new ArrayList<VIPCard>();
				inner_rs = inner_ps.executeQuery();
				inner_rs.beforeFirst();
				while (inner_rs.next()) {
					VIPCard card = null;
					String type = inner_rs.getString(4);
					if (type.equals("SG")) {
						card = new SingleVIPCard();
					} else {
						card = new HomeVIPCard();
					}
					int c_id = inner_rs.getInt(1);
					String code = inner_rs.getString(2);
					String token = inner_rs.getString(3);
					boolean activated = inner_rs.getBoolean(5);
					boolean payed = inner_rs.getBoolean(6);
					double activatePrice = inner_rs.getDouble(7);
					double rent = inner_rs.getDouble(8);
					card.setC_id(c_id);
					card.setCode(code);
					card.setToken(token);
					card.setActivated(activated);
					card.setPayed(payed);
					card.setActivatePrice(activatePrice);
					card.setRent(rent);
					card.setV_id(v_id);
					cardList.add(card);
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
				vip.setAddress(address);
				vip.setPassword(password);
				vip.setCardList(cardList);
				return vip;
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

	public boolean addActivity(Activity activity) {
		Connection connection = baseDAO.getConnection();
		String sql = "insert into activity(ac_name, a_id, location, start, end, co_no) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, activity.getAc_name());
			ps.setInt(2, activity.getA_id());
			ps.setString(3, activity.getLocation());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date sd = activity.getStartDate();
			String start = format.format(sd);
			ps.setString(4, start);
			Date ed = activity.getEndDate();
			String end = format.format(ed);
			ps.setString(5, end);
			ps.setString(6, activity.getCoach_no());
			int row = ps.executeUpdate();
			if (row > 0) {
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

	public ArrayList<Activity> checkActivities(int a_id) {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from activity where a_id = ?";
		PreparedStatement ps_1 = null;
		ResultSet rs_1 = null;
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		try {
			ps_1 = connection.prepareStatement(sql);
			ps_1.setInt(1, a_id);
			rs_1 = ps_1.executeQuery();
			rs_1.beforeFirst();
			while (rs_1.next()) {
				Activity activity = new Activity();
				int ac_id = rs_1.getInt(1);
				String ac_name = rs_1.getString(2);
				Place place = new Place(rs_1.getString(4));
				Date start = rs_1.getDate(5);
				Date end = rs_1.getDate(6);
				activity.setAc_id(ac_id);
				activity.setAc_name(ac_name);
				activity.setA_id(a_id);
				activity.setPlace(place);
				activity.setStartDate(start);
				activity.setEndDate(end);
				activityList.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs_1);
			baseDAO.closePreparedStatement(ps_1);
		}
		String sql_2 = "select * from activity where a_id <> ? order by a_id";
		PreparedStatement ps_2 = null;
		ResultSet rs_2 = null;
		try {
			ps_2 = connection.prepareStatement(sql_2);
			ps_2.setInt(1, a_id);
			rs_2 = ps_2.executeQuery();
			rs_2.beforeFirst();
			while (rs_2.next()) {
				Activity activity = new Activity();
				int ac_id = rs_1.getInt(1);
				String ac_name = rs_1.getString(2);
				Place place = new Place(rs_1.getString(4));
				Date start = rs_1.getDate(5);
				Date end = rs_1.getDate(6);
				activity.setAc_id(ac_id);
				activity.setAc_name(ac_name);
				activity.setA_id(a_id);
				activity.setPlace(place);
				activity.setStartDate(start);
				activity.setEndDate(end);
				activityList.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs_2);
			baseDAO.closePreparedStatement(ps_2);
			baseDAO.closeConnection(connection);
		}
		if (activityList.size() > 0) {
			return activityList;
		}
		return null;
	}

	public boolean update(VIP vip) {
		Connection connection = baseDAO.getConnection();
		String sql = "update vip set name = ?, gender = ?, phone = ?, age = ?, cr_no = ?, address = ? where username = ?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, vip.getName());
			ps.setString(2, (vip.getGender() == Gender.MALE) ? "male"
					: "female");
			ps.setString(3, vip.getPhone().getNo());
			ps.setInt(4, vip.getAge());
			ps.setString(5, vip.getCreditCard().getCr_no());
			ps.setString(6, vip.getAddress());
			ps.setString(7, vip.getUsername());
			int count = ps.executeUpdate();
			if (count > 0) {
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

	public boolean deleteVIP(int v_id) {
		Connection connection = baseDAO.getConnection();
		String sql = "delete from vip where v_id = ?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v_id);
			int count = ps.executeUpdate();
			if (count > 0) {
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
