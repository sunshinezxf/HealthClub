package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Manager;
import dao.BaseDAO;

public class ManagerDAOImpl {
	BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public Manager login(String username, String password) {
		Connection connection = baseDAO.getConnection();
		String sql = "select * from manager where username = ? and password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			rs.beforeFirst();
			if (rs.next()) {
				Manager manager = new Manager();
				int m_id = rs.getInt(1);
				String name = rs.getString(4);
				manager.setM_id(m_id);
				manager.setUsername(username);
				manager.setPassword(password);
				manager.setName(name);
				return manager;
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

	public int[] genderSum() {
		int[] sum = new int[2];
		Connection connection = baseDAO.getConnection();
		String sql_1 = "select count(*) from vip where gender = 'male'";
		String sql_2 = "select count(*) from vip where gender = 'female'";
		PreparedStatement ps_1 = null;
		PreparedStatement ps_2 = null;
		ResultSet rs_1 = null;
		ResultSet rs_2 = null;
		try {
			ps_1 = connection.prepareStatement(sql_1);
			ps_2 = connection.prepareStatement(sql_2);
			rs_1 = ps_1.executeQuery();
			rs_1.beforeFirst();
			sum[0] = rs_1.getInt(1);
			rs_2 = ps_2.executeQuery();
			rs_2.beforeFirst();
			sum[1] = rs_2.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
