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

@WebServlet("/SelectDeleteCommentMenuServlet")
public class SelectDeleteCommentMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CommentLogic bo = new CommentLogic();//全コメント取得
		List<CommentBean>allCommentList = bo.executeFindAllComment();

		HttpSession session = request.getSession();


		if(!(allCommentList.isEmpty())) {
			request.setAttribute("allComment", allCommentList);
		request.getRequestDispatcher("WEB-INF/jsp/commentManagement.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "コメント一覧を取得できませんでした");
			response.sendRedirect("WEB-INF/jsp/adminMainMenu.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
