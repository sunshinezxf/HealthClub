package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.BaseDAO;
import dao.CardDAO;

public class CardDAOImpl implements CardDAO {
	private BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public boolean delete(int c_id) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from card where c_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, c_id);
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
