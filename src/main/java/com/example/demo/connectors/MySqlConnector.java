package com.example.demo.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

	private static Connection connection = null;
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MY_SQL_PREFIX = "jdbc:mysql://";
	private static final String MY_SQL_USERNAME = "evia111";
	private static final String MY_SQL_PASSWORD = "HanselGretel123";
	private static final String MY_SQL_DB_NAME = "localhost";
	private static final String MY_SQL_DB_URL = "rds-mysql-10mintutorial.cqgb5lnkoa6v.eu-central-1.rds.amazonaws.com";
	private static final int MY_SQL_DB_PORT = 3306;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (MySqlConnector.connection == null) {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
			MySqlConnector.connection = DriverManager.getConnection(MY_SQL_PREFIX + MY_SQL_DB_URL + ":" + MY_SQL_DB_PORT + "/" + MY_SQL_DB_NAME,MY_SQL_USERNAME,MY_SQL_PASSWORD);
		}
		return MySqlConnector.connection;
	}

}
