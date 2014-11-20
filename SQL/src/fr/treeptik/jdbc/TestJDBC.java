package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/employee_manager";
			Connection connection = DriverManager.getConnection(url,"root","root");
					
			String nameEmployee="Rob";
			String sql = "SELECT * FROM employee e where e.name = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nameEmployee);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()){
				System.out.println(resultSet.getString("id"));
			}
			resultSet.close();
			connection.close();

	}

}
