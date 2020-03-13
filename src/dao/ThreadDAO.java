package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThreadBean;

public class ThreadDAO extends AbstractDAO{

	//ジャンルIDの取得sql
	private final String SEARCH_GENRE_ID = "SELECT thread_genre_id FROM thread_genres where genre_name = ?;";
	//userIDの取得sql

	private final String SEARCH_USER_ID = "SELECT user_id FROM users_info where user_name = ?;";

	//新規スレッドの追加sql
	private final String ADD_NEW_THREAD = "INSERT INTO threads(user_id,thread_title,thread_comment,thread_genre_id)"
			+ " VALUES(?,?,?,?);";

	//スレッド一覧表示sql インナージョイン
	private final String ALL_THREAD = "SELECT thread_id,thread_title,thread_comment,user_name,thread_genre_id FROM threads INNER JOIN "
			+ "users_info ON threads.user_id = users_info.user_id ORDER BY thread_id DESC;";

	//スレッドタイトルと作成者取得
	private final String SERACH_TITLE_AND_THREAD_COMMENT_AND_USER_NAME = "SELECT thread_title,thread_comment,user_name FROM threads INNER JOIN "
			+ "users_info ON threads.user_id = users_info.user_id where threads.thread_id = ?;";

	//スレッド削除
	private final String DELETE_THREAD = "DELETE FROM threads WHERE thread_id = ? AND thread_title = ?";

	//指定ユーザーに関するスレッド削除
	private final String DELETE_THREAD_OF_SELECT_USER = "DELETE FROM threads WHERE user_id = ?;";

	//指定スレッドジャンルのスレッド全件取得 ユーザー名取得のためｲﾝﾅｰｼﾞｮｲﾝも
	private final String ALL_THREAD_OF_SELECT_GENRE = "SELECT thread_id,thread_title,thread_comment,user_name FROM threads INNER JOIN "
			+ "users_info ON threads.user_id = users_info.user_id where thread_genre_id = ? order BY thread_id DESC;";

	//入力されたワードを含むスレッドの全件取得
	private final String ALL_THREAD_INCLUDE_INPUT_WORD = "SELECT thread_id,thread_title,thread_comment,user_name FROM threads INNER JOIN "
			+ "users_info ON threads.user_id = users_info.user_id where thread_title LIKE ? order BY thread_id DESC;";



	//新規スレッド追加
	public ThreadBean addNewThread(ThreadBean thread,String userName,String genreName) {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ADD_NEW_THREAD);){
			ps.setInt(1, searchUserId(userName));
			ps.setString(2, thread.getThreadTitle());
			ps.setString(3, thread.getThreadComment());
			ps.setInt(4, searchGenreId(genreName));

			//INSERT文を実行する
			ps.executeUpdate();

			return new ThreadBean(searchUserId(userName),thread.getThreadTitle(),
					thread.getThreadComment(),searchGenreId(genreName));

		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}


	//全スレッド取得
	public List<ThreadBean>findAllThreads(){
		List<ThreadBean>threadList = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_THREAD);){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				threadList.add(new ThreadBean(rs.getInt("thread_id"),rs.getString("thread_title"),
						rs.getString("thread_comment"),rs.getString("user_name")));
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return threadList;
	}



	//タイトルとスレッドコメントと作成者を取得
	public ThreadBean searchTitleAndThreadCommentAndUserName(int threadId) {
		ThreadBean threadTitleAndThreadCommentAndUseName = null;
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(SERACH_TITLE_AND_THREAD_COMMENT_AND_USER_NAME);){
			ps.setInt(1, threadId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				threadTitleAndThreadCommentAndUseName = new ThreadBean(threadId,rs.getString("thread_title"),
						rs.getString("thread_comment"),rs.getString("user_name"));
			}

		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return threadTitleAndThreadCommentAndUseName;
	}



	//スレッド削除
	public boolean deleteThread(ThreadBean thread) {
		int deleteCount = 0;
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_THREAD);){

			ps.setInt(1, thread.getThreadId());
			ps.setString(2, thread.getThreadTitle());

			//DELETE文を実行する
			deleteCount = ps.executeUpdate();

		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return deleteCount != 0;

	}


	//指定ユーザーのスレッド削除
	public void deleteThreadOfSelectUser(int userId) {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(DELETE_THREAD_OF_SELECT_USER);){

			ps.setInt(1, userId);

			//DELETE文を実行する
			ps.executeUpdate();

		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}


	//指定ジャンルのスレッド全件取得
	public List<ThreadBean> allThreadsOfSelectGenre(int genreId) {
		List<ThreadBean>threads = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_THREAD_OF_SELECT_GENRE);){
			ps.setInt(1, genreId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				threads.add(new ThreadBean(rs.getInt("thread_id"),rs.getString("thread_title"),
						rs.getString("thread_comment"),rs.getString("user_name")));
			}
		}catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return threads;
	}


	//スレッドタイトルに入力ワードを含むスレッド全件取得
	public List<ThreadBean> allThreadsIncludeInputWord(String inputWord) {
		List<ThreadBean>threads = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_THREAD_INCLUDE_INPUT_WORD);){
			ps.setString(1, "%" + inputWord + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				threads.add(new ThreadBean(rs.getInt("thread_id"),rs.getString("thread_title"),
						rs.getString("thread_comment"),rs.getString("user_name")));
			}

		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return threads;
	}


	//ジャンルIDを取得するメソッド
	private int searchGenreId(String genreName) throws SQLException {
		try(Connection con = getConnection();//closeしなくてよい
				PreparedStatement ps = con.prepareStatement(SEARCH_GENRE_ID);){

			ps.setString(1, genreName);

			//SELECT文を実行する
			ResultSet rs = ps.executeQuery();

			int id = -1;
			while(rs.next()) {
				id = rs.getInt("thread_genre_id");
			}
			System.out.println(id);
			return id;

		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return 0;
	}
	//ユーザーIDを取得するメソッド
	private int searchUserId(String userName) throws SQLException {
		try(Connection con = getConnection();){//closeしなくてよい
			PreparedStatement ps = con.prepareStatement(SEARCH_USER_ID);
			ps.setString(1, userName);
			//SELECT文を実行する
			ResultSet rs = ps.executeQuery();
			System.out.println(userName);
			int id = -1;
			while(rs.next()) {
				id = rs.getInt("user_id");
			}
			ps.close();
			rs.close();
			System.out.println(id);
			return id;
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return 0;
	}

}
