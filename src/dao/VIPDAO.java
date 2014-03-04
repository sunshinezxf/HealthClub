package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Gender;
import model.Phone;
import model.VIP;

public class VIPDAO {

	public static boolean addVIP(VIP vip) {
		Connection connection = BaseDAO.getConnection();
		PreparedStatement ps = null;
		String username = vip.getUsername();
		String name = vip.getName();
		String gender = (vip.getGender() == Gender.MALE) ? "male" : "female";
		String phone = vip.getPhone().getNo();
		int age = vip.getAge();
		String password = vip.getPassword();
		String sql = "insert into vip(username, name, gender, phone, age, password) values (?, ?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, phone);
			ps.setInt(5, age);
			ps.setString(6, password);
			int i = ps.executeUpdate();
			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDAO.closePreparedStatement(ps);
			BaseDAO.closeConnection(connection);
		}
		return false;
	}

	public static boolean deleteVIP(String username) {
		Connection connection = BaseDAO.getConnection();
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
			BaseDAO.closePreparedStatement(ps);
			BaseDAO.closeConnection(connection);
		}
		return false;
	}

	public static VIP find(String column, String value) {
		Connection connection = BaseDAO.getConnection();
		String sql = "select * from vip where " + column + " = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
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
			BaseDAO.closeResultSet(rs);
			BaseDAO.closePreparedStatement(ps);
			BaseDAO.closeConnection(connection);
		}
		return null;
	}

	public static boolean modifyVIP(VIP vip) {
		return true;
	}
}
