package model;

import java.net.URISyntaxException;
import java.util.List;

import dao.UsersInfoDAO;

public class UserLogic {//ログイン、新規登録処理を行う

	UsersInfoDAO dao = new UsersInfoDAO();

	public boolean executeUserLogin(UserBean user) throws URISyntaxException {//ユーザーログイン
		user = dao.searchUser(user);
		return user != null;
	}

	public boolean executeAdminLogin(UserBean user) throws URISyntaxException {//管理者ログイン
		user = dao.searchAdmin(user);
		return user != null;
	}

	public boolean executeNewRegister(UserBean user) {//新規登録
		user = dao.findNameAndNewRegister(user);
		return user != null;
	}

	public int executeGetUserId(String userName) {//user_id取得
		return dao.searchId(userName);
	}

	public List<UserBean>executeFindAllUser(){//ユーザー一覧取得
		return dao.findAllUser();
	}

	public boolean executeDeleteUser(UserBean user) {//ユーザー削除
		return dao.deleteUser(user);
	}
}
