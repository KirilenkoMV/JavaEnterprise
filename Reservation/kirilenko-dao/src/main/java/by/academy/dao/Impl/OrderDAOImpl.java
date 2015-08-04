package by.academy.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.academy.dao.interfaces.AbstractDAO;
import by.academy.dao.interfaces.GenericDAO;
import by.academy.utils.ResourseManager;
import by.academy.entity.Client;
import by.academy.entity.Order;
import by.academy.entity.Table;

public class OrderDAOImpl extends AbstractDAO<Order> {
	private static volatile OrderDAOImpl instance;

	
	private OrderDAOImpl() {

	}

	public static OrderDAOImpl getInstance() {
		if (instance == null) {
			synchronized (OrderDAOImpl.class) {
				if (instance == null) {
					instance = new OrderDAOImpl();
				}
			}
		}
		return instance;
	}

	@Override
	protected Order resultSetToObject(ResultSet resultSet) throws SQLException {
		Order order = null;
		if (resultSet.next()) {
			order = new Order();
			order.setDate(new Date(resultSet.getString("date")));
			GenericDAO<Client> client = ClientDAOImpl.getInstance();
	    	order.setClient(client.findById(resultSet.getInt("client_id")));
	    	GenericDAO<Table> table = TableDAOImpl.getInstance();
	    	order.setTable(table.findById(resultSet.getInt("table_id")));
		}
		return order;
	}

	@Override
	protected List<Order> resultSetToListObject(ResultSet resultSet) throws SQLException {
		List<Order> orders = new ArrayList<Order>();
		if (resultSet.next()) {
			Order order = new Order();
			order.setDate(new Date(resultSet.getString("date")));
			GenericDAO<Client> client = ClientDAOImpl.getInstance();
	    	order.setClient(client.findById(resultSet.getInt("client_id")));
	    	GenericDAO<Table> table = TableDAOImpl.getInstance();
	    	order.setTable(table.findById(resultSet.getInt("table_id")));
	    	orders.add(order);
		}
		return orders;
}

	@Override
	protected void setStatementParam(String string, PreparedStatement statement, Order order) throws SQLException {
		if(string.equals("selectById")){
			//in AbstractDAO
		}else if(string.equals("insert")){
			statement.setString(1, (new java.sql.Timestamp(order.getDate().getTime())).toString());
			statement.setInt(2, order.getClient().getId());
			statement.setInt(3, order.getTable().getId());
		}else if(string.equals("update")){
			statement.setString(1, (new java.sql.Timestamp(order.getDate().getTime())).toString());
			statement.setInt(2, order.getClient().getId());
			statement.setInt(3, order.getTable().getId());
			statement.setInt(4, order.getId());
		}
	}

	@Override
	protected String getSQL(String str) {
		if(str.equals("find_by_id")){
			return ResourseManager.SQL.getKey("QUERY_FIND_ORDER");
		}else if(str.equals("find_all")){
			return ResourseManager.SQL.getKey("QUERY_FIND_ORDERS");
		}else if(str.equals("insert")){
			return ResourseManager.SQL.getKey("QUERY_ADD_ORDER");
		}else if(str.equals("update")){
			return ResourseManager.SQL.getKey("QUERY_UPDATE_ORDER");
		}else if(str.equals("delete")){
			return ResourseManager.SQL.getKey("QUERY_DELETE_ORDER");
		}
		
		return null;
	}
	
	
}
