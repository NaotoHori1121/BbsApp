<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet" href="css/userLogin.css">
<title>ユーザーログイン</title>

</head>
<body>
	<div class="wrapper">
		<form action="LogoutServlet" method="get">
			<input type="submit" value="トップページへ戻る" class="backbutton">
		</form>
		<div class="main">
			<img class="solve" src="image/logologologologo.png">
			<p>
				<c:set var="errormessage" value="${message}" />
				<font color="red"> <!-- 既に登録されているユーザー名を入力でメッセージ表示 --> <c:out
						value="${errormessage}" />
				</font>
			</p>
			<c:remove var="errormessage" />
			<!-- セッションスコープからインスタンスを削除 -->
			<form class="form" action="UserLoginServlet" method="post">
				<div class="input">

					<p>
						<img src="image/k0898_6.png" class="image"> <input
							class="userinfo" type="text" name="name" placeholder=" username"
							required>
					</p>
					<p>
						<img src="image/password.png" class="image"> <input
							class="userinfo" type="password" name="password"
							placeholder=" password" maxlength="8" required>
					</p>
					<p>
						<input class="button" type="submit" value="ユーザーログイン">
					</p>
				</div>
			</form>
		</div>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>

</body>
</html>