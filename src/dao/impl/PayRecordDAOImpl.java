package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.record.PayRecord;
import model.record.PayType;
import dao.BaseDAO;
import dao.PayRecordDAO;

public class PayRecordDAOImpl implements PayRecordDAO {
	private BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public ArrayList<PayRecord> getPayRecord(int v_id) {
		Connection connection = baseDAO.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from payrecord where v_id = ?";
		ResultSet rs = null;
		ArrayList<PayRecord> payList = new ArrayList<PayRecord>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next()) {
				PayRecord record = new PayRecord();
				int p_id = rs.getInt(1);
				int c_id = rs.getInt(3);
				String username = rs.getString(4);
				String code = rs.getString(5);
				double price = rs.getDouble(6);
				PayType payType = (rs.getString(7).equals("activate")) ? PayType.ACTIVATE
						: PayType.RENT;
				Date date = rs.getDate(8);
				record.setP_id(p_id);
				record.setV_id(v_id);
				record.setC_id(c_id);
				record.setUsername(username);
				record.setCode(code);
				record.setPrice(price);
				record.setPayType(payType);
				record.setDate(date);
				payList.add(record);
			}
			if (payList.size() > 0) {
				return payList;
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

	public boolean insert(PayRecord record) {
		Connection connection = baseDAO.getConnection();
		String sql = "insert into payrecord(v_id, c_id, username, code, price, payType, date) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, record.getV_id());
			ps.setInt(2, record.getC_id());
			ps.setString(3, record.getUsername());
			ps.setString(4, record.getCode());
			ps.setDouble(5, record.getPrice());
			ps.setString(6,
					(record.getPayType() == PayType.ACTIVATE) ? "activate"
							: "rent");
			ps.setString(7, record.getDate() + "");
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
