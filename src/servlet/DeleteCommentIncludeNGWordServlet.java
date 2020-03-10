package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentBean;
import model.CommentLogic;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/DeleteCommentIncludeNGWordServlet")
public class DeleteCommentIncludeNGWordServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		String ngWord = request.getParameter("word");
		HttpSession session = request.getSession();



		//NGワードを含むコメントの削除
		CommentLogic bo1 = new CommentLogic();
		int deleteCount = bo1.executeDeleteCommentIncludeNGWord(ngWord);

		if(deleteCount != 0) {//削除成功
			session.setAttribute("deleteMessage", deleteCount + "件のコメントを削除しました");
		}else {
			session.setAttribute("deleteMessage", "入力されたワードを含むコメントは存在しません");
		}



		CommentLogic bo2 = new CommentLogic();//全コメント取得
		List<CommentBean>allCommentList = bo2.executeFindAllComment();

		if(!(allCommentList.isEmpty())) {
			request.setAttribute("allComment", allCommentList);
			request.getRequestDispatcher("WEB-INF/jsp/commentManagement.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "コメント一覧を取得できませんでした");
			request.getRequestDispatcher("WEB-INF/jsp/commentManagement.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/threadManagement.jsp");
	}

}
