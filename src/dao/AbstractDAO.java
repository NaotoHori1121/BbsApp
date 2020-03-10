package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

	private String databaseName = "bbs";
	private String user = "root";
	private String password = "password";

	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/" +
				databaseName + "?user=" + user + "&password=" + password + "&serverTimezone=UTC");
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
