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
import model.ThreadBean;
import model.ThreadLogic;

@WebServlet("/SelectThreadServlet")//スレッドを選択時のサーブレット
public class SelectThreadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if(session.getAttribute("name")!=null) {
			//threadIdを使ってスレッドタイトルと説明文と作成者を取得する
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			ThreadLogic bo1 = new ThreadLogic();
			ThreadBean threadTitleCommentUserName = bo1.executeFindTitleAndThreadCommentAndUserName(threadId);

			//全コメントを取得しパラメータに保存
			CommentLogic bo2 = new CommentLogic();
			List<CommentBean>commentList = bo2.executeFindAllComment(threadId);

			session.setAttribute("allComments", commentList);
			session.setAttribute("title", threadTitleCommentUserName.getThreadTitle());
			session.setAttribute("threadComment", threadTitleCommentUserName.getThreadComment());
			session.setAttribute("createThreadUserName", threadTitleCommentUserName.getUserName());
			session.setAttribute("threadId",threadId);

			request.getRequestDispatcher("WEB-INF/jsp/selectThread.jsp").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
