package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

	private String databaseName = "bbs";
	private String user = "root";
	private String password = "password";
	private String username = System.getenv("CLEAR_DB_USERNAME");
	private String pass = System.getenv("CLEAR_DB_PASSWORD");

	//ローカルでの動作確認
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

//	protected Connection getConnection() {
//		System.out.println(username + pass);
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/" +
//					"heroku_a40b8b1319cf83b" + "?user=" + username + "&password=" + pass + "&serverTimezone=UTC&characterEncoding=utf8");
//		}catch(ClassNotFoundException|SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}


}