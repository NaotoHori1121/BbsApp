package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CommentBean;

public class CommentDAO extends AbstractDAO{


	//選択されたthreadsテーブルとcommentsテーブルとuser_infoをインナージョイン
	private final String ALL_COMMENTS_OF_SELECT_THREAD = "select comment_id,user_name,comment,comment_time from threads"
			+ " inner join comments on threads.thread_id = comments.thread_id " +
			"inner join users_info on comments.user_id = users_info.user_id where threads.thread_id = ? ORDER BY comment_id DESC;";

	//入力されたコメントをDBに追加
	private final String ADD_NEW_COMMENT = "INSERT INTO comments(thread_id,user_id,comment,comment_time)"
			+ " values(?,?,?,now());";

	//指定スレッドのコメントを削除
	private final String DELETE_COMMENT_OF_SELECT_THREAD = "DELETE FROM comments WHERE thread_id = ?;";

	//全コメント一覧
	private final String ALL_COMMENT = "SELECT * FROM comments;";

	//指定されたワードを含むコメント削除
	private final String DELETE_COMMENT_INCLUDE_NG_WORD = "DELETE FROM comments WHERE comment LIKE ?;";

	//指定されたユーザーのコメントを削除
	private final String DELETE_COMMENT_SELECT_USER = "DELETE FROM comments WHERE user_id = ?;";

	//指定コメントIDのコメントを削除
	private final String DELETE_COMMENT_DESIGNATION_COMMENT_ID = "DELETE FROM comments WHERE comment_id = ?;";


	//全コメント取得
	public List<CommentBean>findAllComment(){
		List<CommentBean>commentList = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_COMMENT);){

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				commentList.add(new CommentBean(rs.getInt("comment_id"),rs.getString("comment"),rs.getInt("thread_id")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}


	//指定スレッドの全コメント取得
	public List<CommentBean>findAllCommentOfSelectThread(int threadId){
		List<CommentBean>commentList = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_COMMENTS_OF_SELECT_THREAD);){
			ps.setInt(1, threadId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				commentList.add(new CommentBean(rs.getInt("comment_id"),rs.getString("user_name"),
						rs.getString("comment"),rs.getTimestamp("comment_time")));	//javax.sql.Timestamp  time=re.getTimestamp("カラム名"orカラム番号);で取り出す
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}


	//コメント追加
	public CommentBean addNewComment(CommentBean comment) {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ADD_NEW_COMMENT);){
			ps.setInt(1, comment.getThreadId());
			ps.setInt(2, comment.getUserId());
			ps.setString(3, comment.getComment());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new CommentBean(comment.getThreadId(),comment.getUserId(),comment.getComment());
	}


	//指定スレッドのコメント削除
	public void deleteCommentOfSelectThread(int threadId) {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_COMMENT_OF_SELECT_THREAD);){

			ps.setInt(1, threadId);

			//DELETE文を実行する
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}

	}


	//指定ワードのコメント削除
	public int deleteCommentIncludeNGWord(String word) {
		int deleteCount = 0;
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_COMMENT_INCLUDE_NG_WORD);){

			ps.setString(1, "%" + word + "%");

			//DELETE文を実行する
			deleteCount = ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
	}

	//指定ユーザーのコメント削除
	public void deleteCommentOfSelectUser(int userId) {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_COMMENT_SELECT_USER);){

			ps.setInt(1, userId);

			//DELETE文を実行する
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	//指定コメントIDのコメント削除
	public int deleteCommentDesignationCommentId(int commentId) {
		int deleteCount = 0;
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_COMMENT_DESIGNATION_COMMENT_ID);){

			ps.setInt(1, commentId);

			//DELETE文を実行する
			deleteCount = ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
	}


}
