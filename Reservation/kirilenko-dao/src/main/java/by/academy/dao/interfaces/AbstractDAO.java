package by.academy.dao.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.academy.dao.ConnectionPool;
import by.academy.dao.DBUtils;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	public T findById(int id) {
		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		T result = null;
		try {
			connection = connectionPool.getConnection();
			statement = connection.prepareStatement(getSQL("find_by_id"));
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			result = resultSetToObject(resultSet);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return result;
	}

	public List<T> findAll() {
		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> result = new ArrayList<T>();
		try {
			connection = connectionPool.getConnection();
			statement = connection.prepareStatement(getSQL("find_all"));
			resultSet = statement.executeQuery();
			result = resultSetToListObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return result;
	}

	public void insert(T object) {
		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionPool.getConnection();
			statement = connection.prepareStatement(getSQL("insert"));
			setStatementParam("insert",statement,object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, null);
		}
	}

	public void update(T object) {
		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionPool.getConnection();
			statement = connection.prepareStatement(getSQL("update"));
			setStatementParam("update", statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, null);
		}

	}

	public void delete(int id) {
		ConnectionPool connectionPool = ConnectionPool.getInstanse();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = connectionPool.getConnection();
			statement = connection.prepareStatement(getSQL("delete"));
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, null);
		}

	}

	protected abstract T resultSetToObject(ResultSet resultSet) throws SQLException;
	protected abstract List<T> resultSetToListObject(ResultSet resultSet) throws SQLException;
	protected abstract void setStatementParam(String string, PreparedStatement statement,T object) throws SQLException;
	protected abstract String getSQL(String str);
}
