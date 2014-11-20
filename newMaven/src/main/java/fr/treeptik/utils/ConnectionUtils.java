package fr.treeptik.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fr.treeptik.exception.DAOException;

public class ConnectionUtils {

	private static Connection connection;

	static File fileProperties = new File(
			"src/main/resources/database.properties");

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		if (connection == null || connection.isClosed()) {
			Properties properties = new Properties();
			FileReader fileReader;
			try {
				fileReader = new FileReader(fileProperties);
				properties.load(fileReader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Class.forName(properties.getProperty("jdbc_driver"));
			String url = properties.getProperty("jdbc.url");
			String user = properties.getProperty("jdbc.user");
			String password = properties.getProperty("jdbc.password");
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
		}
		return connection;
	}

	public static void commitTX() throws DAOException {
		try {
			getConnection().commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DAOException(e, "erreur commit TX");
		}
	}
}
