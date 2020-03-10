<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/adminMainMenu.css">
<title>管理者メインメニュー</title>
</head>
<body>
	<header>
		<form action="LogoutServlet" method="get">
			<input type="submit" value="ログアウト" class="backbutton">
		</form>
		こんにちは
			<c:out value="${adminname}" />
			さん


	</header>

	<main>
		<p>
			<font color="red"> <!-- ユーザー一覧取得できなければメッセージ表示 --> <c:out
					value="${message}" />
			</font>
		</p>
		<c:remove var="message" scope="session"/>
		<!-- セッションスコープからインスタンスを削除 -->
		<ul>

			<li>ユーザーの削除を行います<form action="SelectDeleteUserMenuServlet" method="get">
					<input type="submit" name="manageuser" value="ユーザー管理"
						class="button">
				</form></li>
			<li>スレッドの削除を行います<form action="SelectDeleteThreadMenuServlet" method="get">
					<input type="submit" name="managethread" value="スレッド管理"
						class="button">
				</form></li>
			<li>コメントの削除を行います<form action="SelectDeleteCommentMenuServlet" method="get">
					<input type="submit" name="managecomment" value="コメント管理"
						class="button">
				</form></li>

		</ul>
		<!--
	  <form action="" method="get">
		<input type="submit" name="changepassword" value="管理者パスワード変更">
	</form>
	-->
	</main>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>

</body>
</html>