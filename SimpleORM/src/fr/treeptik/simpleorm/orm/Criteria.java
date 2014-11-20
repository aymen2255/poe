package fr.treeptik.simpleorm.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.treeptik.utils.ConnectionUtils;

public class Criteria<T> {
	public List<T> list(String table) throws ClassNotFoundException, SQLException {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("Select * From ").append(table);
		
		String sql = queryBuilder.toString();
		System.out.println(sql);
		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet res = statement.executeQuery();
		
		return getListEntite(res);
	}
	
	private List<T> getListEntite(ResultSet resultSet) {
		List<T> result = new ArrayList<T>();
		int i = 0;
		try {
		while (resultSet.next()) {
			i++;
			result.add((T) resultSet.getString(i));
		//result.add(getEntite(resultSet));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return result;
		}
}
