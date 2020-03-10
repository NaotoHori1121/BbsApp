package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserBean;

public class UsersInfoDAO extends AbstractDAO{

	//ログインチェックsql文
	//ユーザー用
	private final String SEARCH_USER = "SELECT *  FROM users_info where user_name = ? "
			+ "AND user_password = ? AND isAdministrator IS NULL;";
	//管理者用
	private final String SEARCH_ADMIN = "SELECT *  FROM users_info where user_name = ? "
			+ "AND user_password = ? AND isAdministrator = 'true';";

	//新規登録できるかのチェックsql文(ユーザー名のみの被りNG) とコメント追加時のユーザーID取得sql
	private final String SEARCH_USER_NAME = "SELECT * FROM users_info where user_name = ?;";

	//新規登録sql文
	private final String ADD_NEW_USER = "INSERT INTO users_info(user_name,user_password) VALUES(?,?);";

	//ユーザー一覧（管理者以外）
	private final String ALL_USER = "SELECT * FROM users_info WHERE isAdministrator IS NULL";

	//ユーザー削除
	private final String DELETE_USER = "DELETE FROM users_info WHERE user_id = ? AND user_name = ?";


	//全ユーザー取得
	public List<UserBean>findAllUser(){
		List<UserBean>userList = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_USER);){

			//SELECT文を実行
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userList.add(new UserBean(rs.getInt("user_id"),rs.getString("user_name"),
						rs.getString("user_password")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;

	}


	//新規登録用
	public UserBean findNameAndNewRegister(UserBean user) {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(SEARCH_USER_NAME);){
			System.out.println(user.getName());
			ps.setString(1, user.getName());

			//SELECT文を実行する
			ResultSet rs = ps.executeQuery();

			//user_nameがDBになければaddNewUserSqlを実行し、userをreturn あればnullをreturn
			if(!rs.next()) {
				PreparedStatement ps2 = con.prepareStatement(ADD_NEW_USER);
				ps2.setString(1, user.getName());
				ps2.setString(2, user.getPassword());
				//INSERTを実行
				ps2.executeUpdate();

				return new UserBean(user.getName(),user.getPassword());
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	//ユーザーログイン時検索
	public UserBean searchUser(UserBean user) {
		return searchUser(user,SEARCH_USER);
	}
	//管理者ログイン時検索
	public UserBean searchAdmin(UserBean user) {
		return searchUser(user,SEARCH_ADMIN);
	}

	//ログイン用メソッド(上記２つのメソッドで使用するもの)
	private UserBean searchUser(UserBean user,String sql) {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){

			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());

			//SELECT文を実行する
			ResultSet rs = ps.executeQuery();

			//user_name,user_passwordがDBにあるものと一致すればusersをreturn しなければnullをreturn
			if(rs.next()) {

				return user = new UserBean(rs.getString("user_name"),rs.getString("user_password"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	//ユーザーID取得
	public int searchId(String userName) {
		ResultSet rs =null;
		int id = -1;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(SEARCH_USER_NAME);){

			ps.setString(1, userName);

			//SELECT文を実行する
			rs = ps.executeQuery();

			while(rs.next()) {
				id = rs.getInt("user_id");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return id;

	}


	//ユーザー削除
	public boolean deleteUser(UserBean user) {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_USER);){

			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());

			//DELETE文を実行する
			return ps.executeUpdate() > 0;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
