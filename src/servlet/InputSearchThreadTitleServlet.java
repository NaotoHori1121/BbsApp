package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ThreadBean;
import model.ThreadLogic;

@WebServlet("/InputSearchThreadTitleServlet")
public class InputSearchThreadTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//検索で入力されたワードが含まれるスレッドタイトルの情報をthreadListに追加
		String inputWord = request.getParameter("inputword");
		List<ThreadBean>threadList = new ArrayList<>();
		ThreadLogic bo = new ThreadLogic();
		threadList = bo.executeFindAllThreadIncludeInputWord(inputWord);

		//		System.out.println(inputWord);

		request.setAttribute("threadList", threadList);
		request.getRequestDispatcher("WEB-INF/jsp/userMainMenu.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/userMainMenu.jsp");
	}

}
