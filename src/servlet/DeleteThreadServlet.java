package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentLogic;
import model.ThreadBean;
import model.ThreadLogic;

@WebServlet("/DeleteThreadServlet")
public class DeleteThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int threadId = Integer.parseInt(request.getParameter("threadId"));
		String title = request.getParameter("title");
		HttpSession session = request.getSession();


		//threadIdがcommentsのフォーリンキーのため先に指定スレッドのコメントを削除する
		CommentLogic bo = new CommentLogic();
		bo.executeDeleteCommentOfSelectThread(threadId);


		//スレッド削除
		ThreadBean thread = new ThreadBean(threadId,title);
		ThreadLogic bo1 = new ThreadLogic();
		boolean canDeleteThread = bo1.executeDeleteThread(thread);

		if(canDeleteThread) {//削除成功
			session.setAttribute("deleteMessage", "ID:" + threadId +" タイトル" +  title + "を削除しました");

		}else {
			session.setAttribute("deleteMessage", "削除に失敗しました");

		}


		//全スレッド取得
		ThreadLogic bo2 = new ThreadLogic();
		List<ThreadBean>threadList = bo2.executeFindAllThread();

		if(!(threadList.isEmpty())) {
			session.setAttribute("allThread", threadList);
			request.getRequestDispatcher("WEB-INF/jsp/threadManagement.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "スレッド一覧を取得できませんでした");
			request.getRequestDispatcher("WEB-INF/jsp/threadManagement.jsp").forward(request, response);
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/threadManagement.jsp");
	}

}
