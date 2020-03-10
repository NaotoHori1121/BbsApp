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
import model.ThreadLogic;
import model.UserBean;
import model.UserLogic;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		///////ユーザー削除 フォーリンキーの関係上削除ユーザーのコメント・スレッドも消す
		int id = Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("name");

		//指定ユーザーのコメント削除
		CommentLogic bo2 = new CommentLogic();
		bo2.executeDeleteCommentOfSelectUser(id);

		//指定ユーザーのスレッド削除
		ThreadLogic bo3 = new ThreadLogic();
		bo3.executeDeleteThreadOfSelectUser(id);

		//指定ユーザーの削除
		UserBean user = new UserBean(id,name);
		UserLogic bo4 = new UserLogic();
		boolean canDeleteUser = bo4.executeDeleteUser(user);

		//全ユーザー取得
		UserLogic bo1 = new UserLogic();
		List<UserBean>userList = bo1.executeFindAllUser();

		if(!(userList.isEmpty())) {
			request.setAttribute("allUser", userList);
		}else {
			session.setAttribute("message", "ユーザー一覧を取得できませんでした");
		}


		if(canDeleteUser) {//削除成功
			session.setAttribute("deleteMessage", "ID:" + id +" ユーザー名" +  name + "を削除しました");
			request.getRequestDispatcher("WEB-INF/jsp/userManagement.jsp").forward(request, response);
		}else {
			session.setAttribute("deleteMessage", "削除に失敗しました");
			request.getRequestDispatcher("WEB-INF/jsp/userManagement.jsp").forward(request, response);
		}


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("WEB-INF/jsp/userManagement.jsp");
	}

}
