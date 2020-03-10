package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ThreadBean;
import model.ThreadLogic;

@WebServlet("/BackMainMenuServlet")
public class BackMainMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("UTF-8");

		//スレッドを全件取得しリクエストスコープに保存
		ThreadLogic bo = new ThreadLogic();
		List<ThreadBean>threadList = bo.executeFindAllThread();
		request.setAttribute("threadList", threadList);

		request.setAttribute("genreimg", String.valueOf(0));//プログラミング言語毎の画像表示のため

		request.getRequestDispatcher("WEB-INF/jsp/userMainMenu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}