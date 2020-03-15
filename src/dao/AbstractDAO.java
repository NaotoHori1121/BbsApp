package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

	private String databaseName = "bbs";
	private String user = "root";
	private String password = "password";

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
			con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/" +
					"heroku_a40b8b1319cf83b" + "?user=" + "bc730364f273f9" + "&password=" + "b6009e9c" + "&serverTimezone=UTC&characterEncoding=utf8");
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return con;
	}



//	public static Connection getConnection(){
//		Connection connection =null;
//		String dbUrl = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			URI dbUri = new URI(System.getenv("mysql://bc730364f273f9:b6009e9c@us-cdbr-iron-east-04.cleardb.net/heroku_a40b8b1319cf83b?reconnect=true"));
//			String username = dbUri.getUserInfo().split(":")[0];
//	        String password = dbUri.getUserInfo().split(":")[1];
//	        // JDBC用のURLを生成。
//	        dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//	        connection =  DriverManager.getConnection(dbUrl, username, password);
//
//		}catch(ClassNotFoundException|SQLException | URISyntaxException e) {
//			System.out.println("エラーだよ");
//			e.printStackTrace();
//		}
//		return connection;
//	}

}
