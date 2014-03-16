package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BaseDAO;
import model.Manager;

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
}
