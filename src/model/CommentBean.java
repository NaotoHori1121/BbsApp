package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int commentId;
	private int threadId;
	private int userId;
	private String comment;
	private Timestamp dateTime;
	private String userName;

	public CommentBean() {};

	public CommentBean(int threadId,int userId,String comment,Timestamp dateTime) {
		this.threadId = threadId;
		this.userId = userId;
		this.comment = comment;
		this.dateTime = dateTime;
	}

	//指定スレッドの全コメント取得で使う
	public CommentBean(int commentId,String userName,String comment,Timestamp dateTime) {
		this.commentId = commentId;
		this.userName = userName;
		this.comment = comment;
		this.dateTime = dateTime;
	}

	//コメント追加で使う
	public CommentBean(int threadId,int userId,String comment) {
		this.threadId = threadId;
		this.userId = userId;
		this.comment = comment;
	}

	//全コメント取得で使う
	public CommentBean(int commentId, String comment,int threadId) {
		this.commentId = commentId;
		this.comment = comment;
		this.threadId = threadId;
	}

	//getter setter
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
