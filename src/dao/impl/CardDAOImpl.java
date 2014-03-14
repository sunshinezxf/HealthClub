package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public boolean activate(int c_id, int v_id) {
		Connection connection = baseDAO.getConnection();
		String s_1 = "select * from card where c_id = ?";
		String s_2 = "select * from vip where v_id = ?";
		PreparedStatement ps_1 = null;
		PreparedStatement ps_2 = null;
		ResultSet rs_1 = null;
		ResultSet rs_2 = null;
		double price = 0;
		try {
			ps_1 = connection.prepareStatement(s_1);
			ps_1.setInt(1, c_id);
			rs_1 = ps_1.executeQuery();
			rs_1.beforeFirst();
			if (rs_1.next()) {
				boolean activated = rs_1.getBoolean(5);
				if (activated) {
					return false;
				}
				price = rs_1.getDouble(7);
			}
			baseDAO.closeResultSet(rs_1);
			baseDAO.closePreparedStatement(ps_1);
			ps_2 = connection.prepareStatement(s_2);
			ps_2.setInt(1, v_id);
			rs_2 = ps_2.executeQuery();
			rs_2.beforeFirst();
			if (rs_2.next()) {
				String cr_no = rs_2.getString(8);
				String s_3 = "select * from credit where cr_no = ?";
				PreparedStatement ps_3 = null;
				ResultSet rs_3 = null;
				ps_3 = connection.prepareStatement(s_3);
				ps_3.setString(1, cr_no);
				rs_3 = ps_3.executeQuery();
				rs_3.beforeFirst();
				if (rs_3.next()) {
					double balance = rs_3.getDouble(2);
					if (balance > price) {
						String s_4 = "update credit set balance = "
								+ (balance - price) + " where cr_no = " + cr_no;
						PreparedStatement ps_4 = connection
								.prepareStatement(s_4);
						int row = ps_4.executeUpdate();
						baseDAO.closePreparedStatement(ps_4);
						baseDAO.closeResultSet(rs_3);
						baseDAO.closePreparedStatement(ps_3);
						if (row > 0) {
							String s_5 = "update card set activated = " + true
									+ " where c_id = " + c_id;
							PreparedStatement ps_5 = connection
									.prepareStatement(s_5);
							row = ps_5.executeUpdate();
							baseDAO.closePreparedStatement(ps_5);
							if (row > 0) {
								return true;
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs_2);
			baseDAO.closePreparedStatement(ps_2);
			baseDAO.closeResultSet(rs_1);
			baseDAO.closePreparedStatement(ps_1);
			baseDAO.closeConnection(connection);
		}
		return false;
	}

	public boolean pay(int c_id, int v_id) {
		Connection connection = baseDAO.getConnection();
		String s_1 = "select * from card where c_id = ?";
		String s_2 = "select * from vip where v_id = ?";
		PreparedStatement ps_1 = null;
		PreparedStatement ps_2 = null;
		ResultSet rs_1 = null;
		ResultSet rs_2 = null;
		double rent = 0;
		try {
			ps_1 = connection.prepareStatement(s_1);
			ps_1.setInt(1, c_id);
			rs_1 = ps_1.executeQuery();
			rs_1.beforeFirst();
			if (rs_1.next()) {
				boolean payed = rs_1.getBoolean(6);
				if (payed) {
					return false;
				}
				rent = rs_1.getDouble(8);
			}
			baseDAO.closeResultSet(rs_1);
			baseDAO.closePreparedStatement(ps_1);
			ps_2 = connection.prepareStatement(s_2);
			ps_2.setInt(1, v_id);
			rs_2 = ps_2.executeQuery();
			rs_2.beforeFirst();
			if (rs_2.next()) {
				String cr_no = rs_2.getString(8);
				String s_3 = "select * from credit where cr_no = ?";
				PreparedStatement ps_3 = null;
				ResultSet rs_3 = null;
				ps_3 = connection.prepareStatement(s_3);
				ps_3.setString(1, cr_no);
				rs_3 = ps_3.executeQuery();
				rs_3.beforeFirst();
				if (rs_3.next()) {
					double balance = rs_3.getDouble(2);
					if (balance > rent) {
						String s_4 = "update credit set balance = "
								+ (balance - rent) + " where cr_no = " + cr_no;
						PreparedStatement ps_4 = connection
								.prepareStatement(s_4);
						int row = ps_4.executeUpdate();
						baseDAO.closePreparedStatement(ps_4);
						baseDAO.closeResultSet(rs_3);
						baseDAO.closePreparedStatement(ps_3);
						if (row > 0) {
							String s_5 = "update card set payed = " + true
									+ " where c_id = " + c_id;
							PreparedStatement ps_5 = connection
									.prepareStatement(s_5);
							row = ps_5.executeUpdate();
							baseDAO.closePreparedStatement(ps_5);
							if (row > 0) {
								return true;
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			baseDAO.closeResultSet(rs_2);
			baseDAO.closePreparedStatement(ps_2);
			baseDAO.closeResultSet(rs_1);
			baseDAO.closePreparedStatement(ps_1);
			baseDAO.closeConnection(connection);
		}
		return false;
	}
}
