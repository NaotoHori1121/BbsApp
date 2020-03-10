package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ThreadBean;
import model.ThreadLogic;

@WebServlet("/NewThreadServlet")
public class NewThreadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String threadTitle = request.getParameter("title");
		String threadComment = request.getParameter("comment");
		String genreName = request.getParameter("genre");
		String userName = request.getParameter("name");

		//新規スレッド作成
		ThreadBean thread = new ThreadBean(threadTitle,threadComment);
		ThreadLogic bo = new ThreadLogic();
		boolean canAddThread = bo.executeAddNewThread(thread, userName,genreName);

		HttpSession session = request.getSession();

		if(canAddThread) {
			//スレッド全件をリクエストスコープに保存
			ThreadLogic tl = new ThreadLogic();
			List<ThreadBean>threadList = tl.executeFindAllThread();
			request.setAttribute("threadList", threadList);

			request.getRequestDispatcher("WEB-INF/jsp/userMainMenu.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "スレッドの作成ができませんでした");
			response.sendRedirect("WEB-INF/jsp/newThread.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
