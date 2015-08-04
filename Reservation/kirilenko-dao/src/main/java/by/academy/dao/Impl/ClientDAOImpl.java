package by.academy.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.academy.dao.interfaces.AbstractDAO;
import by.academy.utils.ResourseManager;
import by.academy.entity.Client;

public class ClientDAOImpl extends AbstractDAO<Client> {
	private static volatile ClientDAOImpl instance;

	
	private ClientDAOImpl() {

	}

	public static ClientDAOImpl getInstance() {
		if (instance == null) {
			synchronized (ClientDAOImpl.class) {
				if (instance == null) {
					instance = new ClientDAOImpl();
				}
			}
		}
		return instance;
	}

	@Override
	protected Client resultSetToObject(ResultSet resultSet) throws SQLException {
		Client client = null;
		if (resultSet.next()) {
			client = new Client();
			client.setName(resultSet.getString("name"));
			client.setSurname(resultSet.getString("surname"));
			client.setPassword(resultSet.getString("password"));
			client.setAge(resultSet.getInt("age"));
			client.setPhone(resultSet.getInt("phone"));
		}
		return client;
	}

	@Override
	protected List<Client> resultSetToListObject(ResultSet resultSet) throws SQLException {
		List<Client> clients = new ArrayList<Client>();
		if (resultSet.next()) {
			Client client = new Client();
			client.setName(resultSet.getString("name"));
			client.setSurname(resultSet.getString("surname"));
			client.setPassword(resultSet.getString("password"));
			client.setAge(resultSet.getInt("age"));
			client.setPhone(resultSet.getInt("phone"));
			clients.add(client);
		}
		return clients;
}

	@Override
	protected void setStatementParam(String string, PreparedStatement statement, Client client) throws SQLException {
		if(string.equals("selectById")){
			//in AbstractDAO
		}else if(string.equals("insert")){
			statement.setString(1, client.getName());
			statement.setString(2, client.getSurname());
			statement.setString(3, client.getPassword());
			statement.setInt(4, client.getAge());
			statement.setInt(5, client.getPhone());
		}else if(string.equals("update")){
			statement.setString(1, client.getName());
			statement.setString(2, client.getSurname());
			statement.setString(3, client.getPassword());
			statement.setInt(4, client.getAge());
			statement.setInt(5, client.getPhone());
			statement.setInt(6, client.getId());
		}
	}

	@Override
	protected String getSQL(String str) {
		if(str.equals("find_by_id")){
			return ResourseManager.SQL.getKey("QUERY_FIND_CLIENT");
		}else if(str.equals("find_all")){
			return ResourseManager.SQL.getKey("QUERY_FIND_CLIENTS");
		}else if(str.equals("insert")){
			return ResourseManager.SQL.getKey("QUERY_ADD_CLIENT");
		}else if(str.equals("update")){
			return ResourseManager.SQL.getKey("QUERY_UPDATE_CLIENT");
		}else if(str.equals("delete")){
			return ResourseManager.SQL.getKey("QUERY_DELETE_CLIENT");
		}
		
		return null;
	}
	
	
}
