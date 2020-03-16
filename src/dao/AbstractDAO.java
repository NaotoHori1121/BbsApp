package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

	private String user = System.getenv("DB_USERNAME");
	private String password = System.getenv("DB_PASSWORD");
	private String host = System.getenv("DB_HOST");
	private String databasename = System.getenv("DB_DATABASE");
//ローカル
//	protected Connection getConnection() {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost/" +
//				databaseName + "?user=" + user + "&password=" + password + "&serverTimezone=UTC");
//		}catch(ClassNotFoundException|SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/" +
					databasename + "?user=" + user + "&password=" + password + "&serverTimezone=UTC&characterEncoding=utf8");
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


}