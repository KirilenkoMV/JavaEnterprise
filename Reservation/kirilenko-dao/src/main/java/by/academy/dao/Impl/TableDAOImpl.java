package by.academy.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.academy.dao.interfaces.AbstractDAO;
import by.academy.utils.ResourseManager;
import by.academy.entity.Table;

public class TableDAOImpl extends AbstractDAO<Table> {
	private static volatile TableDAOImpl instance;

	
	private TableDAOImpl() {

	}

	public static TableDAOImpl getInstance() {
		if (instance == null) {
			synchronized (TableDAOImpl.class) {
				if (instance == null) {
					instance = new TableDAOImpl();
				}
			}
		}
		return instance;
	}

	@Override
	protected Table resultSetToObject(ResultSet resultSet) throws SQLException {
		Table table = null;
		if (resultSet.next()) {
			table = new Table();
			table.setSeats(resultSet.getInt("seats_number"));
			table.setPlace(resultSet.getString("place"));
			table.setCost(resultSet.getDouble("cost"));
		}
		return table;
	}

	@Override
	protected List<Table> resultSetToListObject(ResultSet resultSet) throws SQLException {
		List<Table> tables = new ArrayList<Table>();
		if (resultSet.next()) {
			Table table = new Table();
			table.setSeats(resultSet.getInt("seats_number"));
			table.setPlace(resultSet.getString("place"));
			table.setCost(resultSet.getDouble("cost"));
			tables.add(table);
		}
		return tables;
}

	@Override
	protected void setStatementParam(String string, PreparedStatement statement, Table table) throws SQLException {
		if(string.equals("selectById")){
			//in AbstractDAO
		}else if(string.equals("insert")){
			statement.setInt(1, table.getSeats());
			statement.setString(2, table.getPlace());
			statement.setDouble(3, table.getCost());
		}else if(string.equals("update")){
			statement.setInt(1, table.getSeats());
			statement.setString(2, table.getPlace());
			statement.setDouble(3, table.getCost());
			statement.setInt(4, table.getId());
		}
	}
	
	@Override
	protected String getSQL(String str) {
		if(str.equals("find_by_id")){
			return ResourseManager.SQL.getKey("QUERY_FIND_TABLE");
		}else if(str.equals("find_all")){
			return ResourseManager.SQL.getKey("QUERY_FIND_TABLES");
		}else if(str.equals("insert")){
			return ResourseManager.SQL.getKey("QUERY_ADD_TABLE");
		}else if(str.equals("update")){
			return ResourseManager.SQL.getKey("QUERY_UPDATE_TABLE");
		}else if(str.equals("delete")){
			return ResourseManager.SQL.getKey("QUERY_DELETE_TABLE");
		}
		
		return null;
	}
	
}

