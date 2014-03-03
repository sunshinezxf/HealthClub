package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDAO {
	private static BaseDAO baseDAO = new BaseDAO();

	private static InitialContext jndiContext = null;
	private static Connection connection = null;
	private static DataSource dataSource = null;

	private BaseDAO() {
		Properties properties = new Properties();
		properties.put(Context.PROVIDER_URL, "jnp:///");
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.naming.java.javaURLContextFactory");
		try {
			jndiContext = new InitialContext(properties);
			dataSource = (DataSource) jndiContext
					.lookup("java:comp/env/jdbc/healthclub");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static BaseDAO getInstance() {
		return baseDAO;
	}

	public static Connection getConnection() {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
