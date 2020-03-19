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


@WebServlet("/SelectDeleteThreadMenuServlet")
public class SelectDeleteThreadMenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if(session.getAttribute("adminname")!=null) {
			ThreadLogic bo = new ThreadLogic();//全ユーザー取得
			List<ThreadBean>threadList = bo.executeFindAllThread();

			if(!(threadList.isEmpty())) {
				request.setAttribute("allThread", threadList);
				request.getRequestDispatcher("WEB-INF/jsp/threadManagement.jsp").forward(request, response);
			}else {
				session.setAttribute("message", "スレッド一覧を取得できませんでした");
				response.sendRedirect("WEB-INF/jsp/threadManagement.jsp");
			}
		}else {
			response.sendRedirect("index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}