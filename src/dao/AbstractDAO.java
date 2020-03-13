package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class AbstractDAO {

	//heroku利用前にローカル環境で使っていた
//	private String databaseName = "bbs";
//	private String user = "root";
//	private String password = "password";

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


	protected static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

        // heroku configに設定されている値を取得。
    URI dbUri = new URI(System.getenv("mysql://ba25a6997934f2:c2d54b6f@us-cdbr-iron-east-04.cleardb.net/heroku_bcbf6e365878e54"));
    // :をデリミタとして必要な情報を抜き取る。
    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    // JDBC用のURLを生成。
    String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
    con = DriverManager.getConnection(dbUrl, username, password);
		}catch (URISyntaxException |ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
    return con;
}
}
