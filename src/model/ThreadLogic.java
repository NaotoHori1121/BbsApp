package model;

import java.util.List;

import dao.ThreadDAO;

public class ThreadLogic {

	ThreadDAO dao = new ThreadDAO();

	//スレッド新規作成
	public boolean executeAddNewThread(ThreadBean thread,String userName,String genreName) {
		thread = dao.addNewThread(thread, userName, genreName);
		return thread != null;
	}

	//スレッド全件取得
	public List<ThreadBean> executeFindAllThread(){
		return dao.findAllThreads();
	}

	//スレッドタイトルと説明文と作成者取得
	public ThreadBean executeFindTitleAndThreadCommentAndUserName(int threadId) {
		return dao.searchTitleAndThreadCommentAndUserName(threadId);
	}

	//スレッド削除
	public boolean executeDeleteThread(ThreadBean thread) {
		return dao.deleteThread(thread);
	}

	//指定ユーザーのスレッド削除
	public void executeDeleteThreadOfSelectUser(int userId) {
		dao.deleteThreadOfSelectUser(userId);
	}

	//指定ジャンルのスレッド全件取得
	public List<ThreadBean>executeFindAllThreadOfSelectGenre(int genreId){
		return dao.allThreadsOfSelectGenre(genreId);
	}

	//入力ワードが含まれるスレッドタイトルのスレッド全件取得
	public List<ThreadBean> executeFindAllThreadIncludeInputWord(String inputWord){
		return dao.allThreadsIncludeInputWord(inputWord);
	}
}
