<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet" href="css/userManagement.css">
<title>ユーザー管理</title>
</head>
<body>
	<header>
	<form action="BackAdminMainMenuServlet" method="get">
			<input type="submit" value="管理者メインメニューへ戻る" class="backbutton">
		</form>
	</header>
	<p>
		<font color="red"> <!-- ユーザー一覧取得失敗でメッセージ表示 --> <c:out
				value="${message}" />
		</font>
	</p>
	<!-- セッションスコープからインスタンスを削除 -->
	<c:remove var="message" />
	<main>
		<form class="deleteUser" action="DeleteUserServlet" method="post">
			<h1>ユーザーの削除</h1>
			<p>
				<font color="red"> <!-- 削除失敗でメッセージ表示 --> <c:out
						value="${deleteMessage}" />
				</font>
			</p>
			<c:remove var="deleteMessage" />
			<!-- セッションスコープからインスタンスを削除 -->
			<p>
				ユーザーID:<input type="number" name="userId" required>
			</p>

			<p>
				ユーザー名:<input type="text" name="name" required>
			</p>

			<p>
				<input type="submit" value="削除" class="button">
			</p>

		</form>
	</main>


	<div class="alluser">
		<!-- 全ユーザー表示 -->


		<c:forEach var="users" items="${allUser}">
			<form action="DeleteUserServlet" method="post">
				<input type="hidden" value="${users.getId()}" name="userId">
				<input type="hidden" value="${users.getName()}" name="name">
				<table>
					<tr>
						<th>ユーザーID: <c:out value="${users.getId()}" /></th>
						<th>ユーザー名: <c:out value="${users.getName()}" /></th>
						<th>パスワード: <c:out value="${users.getPassword()}" /></th>

						<th><input type="submit" value="削除" class="button"></th>
					</tr>
				</table>

			</form>
		</c:forEach>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>

</body>
</html>