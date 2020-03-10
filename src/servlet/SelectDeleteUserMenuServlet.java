package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserLogic;


@WebServlet("/SelectDeleteUserMenuServlet")
public class SelectDeleteUserMenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UserLogic bo = new UserLogic();//全ユーザー取得
		List<UserBean>userList = bo.executeFindAllUser();

		HttpSession session = request.getSession();


		if(!(userList.isEmpty())) {
			request.setAttribute("allUser", userList);
			request.getRequestDispatcher("WEB-INF/jsp/userManagement.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "ユーザー一覧を取得できませんでした");
			response.sendRedirect("WEB-INF/jsp/adminMainMenu.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
