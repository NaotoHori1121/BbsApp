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
import model.UserLogic;

@WebServlet("/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UserLogic bo1 = new UserLogic();
		String userName = request.getParameter("name");
		int threadId = Integer.parseInt(request.getParameter("threadId"));
		int userId = bo1.executeGetUserId(userName);		//userNameを引数にUserLogic内でuserIdを取り出す
		String comment = request.getParameter("comment");
		System.out.println(userName + threadId + comment);
		CommentBean commentBean = new CommentBean(threadId,userId,comment);
		CommentLogic bo2 = new CommentLogic();

		//コメント追加
		boolean canAddComment = bo2.executeAddComment(commentBean);
		HttpSession session = request.getSession();

		//コメント全件取得
		List<CommentBean>commentList = bo2.executeFindAllComment(threadId);
		request.setAttribute("allComments", commentList);
		request.setAttribute("threadId",threadId);

		if(canAddComment) {
			request.getRequestDispatcher("WEB-INF/jsp/selectThread.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "コメントの追加ができませんでした");
			response.sendRedirect("WEB-INF/jsp/selectThread.jsp");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/selectThread.jsp");
	}

}
