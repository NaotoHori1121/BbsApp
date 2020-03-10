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

@WebServlet("/NewRegisterServlet")
public class NewRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String registerName = request.getParameter("name");
		String registerPassword = request.getParameter("password");

		//新規登録処理を行う
		UserBean newUser = new UserBean(registerName,registerPassword);
		UserLogic bo = new UserLogic();
		boolean canNewRegister = bo.executeNewRegister(newUser);
		HttpSession session = request.getSession();

		if(canNewRegister) {//新規登録成功でユーザーログイン画面へ
			session.setAttribute("name", registerName);
			request.setAttribute("successmessage", "新規登録が完了しました");

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {//新規登録失敗で再度新規登録画面へ
			request.setAttribute("errormessage", "既に登録されているユーザー名です");
			request.getRequestDispatcher("newRegister.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("newRegister.jsp");
	}

}
