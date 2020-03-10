package model;

import java.util.List;

import dao.CommentDAO;

public class CommentLogic {
	CommentDAO dao = new CommentDAO();

	//コメント全件取得
	public List<CommentBean>executeFindAllComment(){
		return dao.findAllComment();
	}

	//新規コメント追加
	public boolean executeAddComment(CommentBean comment) {
		comment = dao.addNewComment(comment);
		return comment != null;
	}

	//指定スレッドのコメント全件取得
	public List<CommentBean>executeFindAllComment(int threadId){
		return dao.findAllCommentOfSelectThread(threadId);
	}

	//指定スレッドのコメント削除
	public void executeDeleteCommentOfSelectThread(int threadId) {
		dao.deleteCommentOfSelectThread(threadId);
	}

	//指定ワードのコメント削除
	public int executeDeleteCommentIncludeNGWord(String word) {
		return dao.deleteCommentIncludeNGWord(word);
	}

	//指定ユーザーのコメント削除
	public void executeDeleteCommentOfSelectUser(int userId) {
		dao.deleteCommentOfSelectUser(userId);
	}

	//指定コメントIDのコメント削除
	public int executeDeleteCommentDesignationCommentId(int commentId) {
		return dao.deleteCommentDesignationCommentId(commentId);
	}


}
