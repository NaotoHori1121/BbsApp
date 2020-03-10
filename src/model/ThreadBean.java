package model;

import java.io.Serializable;

public class ThreadBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private int threadId;
	private int userId;
	private String threadTitle;
	private String threadComment;
	private int threadGenreId;
	private String userName;//スレッド一覧取得、スレッドタイトル・作成者取得で使う

	public ThreadBean() {};

	public ThreadBean(int threadId,int userId,String threadTitle,String threadComment,int threadGenreId) {
		this.threadId = threadId;
		this.userId = userId;
		this.threadTitle = threadTitle;
		this.threadComment = threadComment;
		this.threadGenreId = threadGenreId;
	}

	//スレッド新規追加で使う
	public ThreadBean(int userId,String threadTitle,String threadComment,int threadGenreId) {
		this.userId = userId;
		this.threadTitle = threadTitle;
		this.threadComment = threadComment;
		this.threadGenreId = threadGenreId;
	}
	public ThreadBean(String threadTitle, String threadComment) {
		this.threadTitle = threadTitle;
		this.threadComment = threadComment;
	}
	public ThreadBean(String threadTitle, String threadComment,String userName) {
		this.threadTitle = threadTitle;
		this.threadComment = threadComment;
		this.userName = userName;
	}

	//スレッド一覧で使う
	public ThreadBean(int threadId,String threadTitle,String threadComment,String userName) {
		this.threadId = threadId;
		this.threadTitle = threadTitle;
		this.threadComment = threadComment;
		this.userName = userName;
	}

	//スレッドタイトル・作成者取得で使う
	public ThreadBean(int threadId,String threadTitle,String userName) {
		this.threadId = threadId;
		this.threadTitle = threadTitle;
		this.userName = userName;
	}

	//スレッド削除で使う
	public ThreadBean(int threadId,String threadTitle) {
		this.threadId = threadId;
		this.threadTitle = threadTitle;
	}

	//getter setter
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getThreadTitle() {
		return threadTitle;
	}
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	public String getThreadComment() {
		return threadComment;
	}
	public void setThreadComment(String threadComment) {
		this.threadComment = threadComment;
	}
	public int getThreadGenreId() {
		return threadGenreId;
	}
	public void setThreadGenreId(int threadGenreId) {
		this.threadGenreId = threadGenreId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}
