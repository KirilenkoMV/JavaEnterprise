package by.academy.dao;

import by.academy.utils.ResourseManager;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {
	private static volatile ConnectionPool instanse;
	private BasicDataSource dataSource;

	private ConnectionPool() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(ResourseManager.CONNECTION.getKey("database-driver"));
		dataSource.setUrl(ResourseManager.CONNECTION.getKey("database-url"));
		dataSource.setUsername(ResourseManager.CONNECTION.getKey("database-user"));
		dataSource.setPassword(ResourseManager.CONNECTION.getKey("database-password"));
	}

	public static ConnectionPool getInstanse() {
		if (instanse == null) {
			synchronized (ConnectionPool.class) {
				if (instanse == null) {
					instanse = new ConnectionPool();
				}
			}
		}
		return instanse;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void closeConnection() throws SQLException {
		dataSource.close();
	}
}
