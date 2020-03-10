package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentBean;
import model.CommentLogic;


@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int commentId = Integer.parseInt(request.getParameter("commentId"));

		//コメント削除
		CommentLogic bo1 = new CommentLogic();
		int deleteCount = bo1.executeDeleteCommentDesignationCommentId(commentId);

		if(deleteCount != 0) {//削除成功
			request.setAttribute("deleteMessage", deleteCount + "件のコメントを削除しました");
		}else {
			request.setAttribute("deleteMessage", "コメント削除に失敗しました");
		}


		CommentLogic bo2 = new CommentLogic();//全コメント取得
		List<CommentBean>allCommentList = bo2.executeFindAllComment();

		if(!(allCommentList.isEmpty())) {
			request.setAttribute("allComment", allCommentList);
			request.getRequestDispatcher("WEB-INF/jsp/commentManagement.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "コメント一覧を取得できませんでした");
			request.getRequestDispatcher("WEB-INF/jsp/commentManagement.jsp").forward(request, response);
		}



	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/commentManagement.jsp");
	}
}
