package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Attendant;
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
}
