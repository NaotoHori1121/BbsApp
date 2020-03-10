package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserLogic;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String adminName = request.getParameter("adminname");
		String adminPassword = request.getParameter("adminpassword");

		//ログイン処理
		UserBean admin = new UserBean(adminName,adminPassword);
		UserLogic bo = new UserLogic();
		boolean isAdmin = bo.executeAdminLogin(admin);
		HttpSession session = request.getSession();

		if(isAdmin) {
			//セッションスコープに保存
			session.setAttribute("adminname",adminName);
			request.getRequestDispatcher("WEB-INF/jsp/adminMainMenu.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "IDかパスワードが間違っています");//セッションスコープに保存
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("adminLogin.jsp");
	}

}
