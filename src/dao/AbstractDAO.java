package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

//	private String databaseName = "bbs";
//	private String user = "root";
//	private String password = "password";
//
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


	public static Connection getConnection() throws URISyntaxException,SQLException{
		Connection connection =null;
		String dbUrl = System.getenv("mysql2://ba25a6997934f2:c2d54b6f@us-cdbr-iron-east-04.cleardb.net/heroku_bcbf6e365878e54");
		return DriverManager.getConnection(dbUrl);
	}

}
