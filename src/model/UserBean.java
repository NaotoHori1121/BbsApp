package model;

import java.io.Serializable;

public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private String administrator;


	public UserBean() {};
	public UserBean(int id,String name,String password,String administrator) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.administrator = administrator;
	}
	public UserBean(String name) {//新規登録で使う
		this.name = name;
	}
	public UserBean(String name,String password) {//ログインで使う
		this.name = name;
		this.password = password;
	}
	public UserBean(int id,String name,String password) {//管理者画面ユーザー一覧取得で使う
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public UserBean(int id,String name) {//削除で使う
		this.id = id;
		this.name = name;
	}


	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}


}
