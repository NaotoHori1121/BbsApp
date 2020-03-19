<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet" href="css/newRegister.css">
<title>新規登録</title>
</head>
<body>
	<div class="wrapper">
		<header>
			<form action="LogoutServlet" method="get">
				<input type="submit" value="トップページへ戻る" class="backbutton">
			</form>
		</header>
		<header> </header>
		<main>


			<form action="NewRegisterServlet" method="post">
				<h1>
					<img class="solve" src="image/logoonly.png">会員登録
				</h1>
				<h2>
					<span class="inputitem">入力項目</span>
				</h2>

				<p>
					<font color="red"> <!-- 既に登録されているユーザー名を入力でメッセージ表示 --> <c:out
							value="${errormessage}" />
					</font>
				</p>
				<c:remove var="errormessage" />
				<!-- セッションスコープからインスタンスを削除 -->

				<dl>
					<dt>ユーザー名</dt>
					<dd>
						<input type="text" name="name" placeholder="username" required
							class="input">
					</dd>
					<dt>パスワード</dt>
					<dd>
						<input type="password" name="password"
							placeholder="４桁～８桁のpassword" minlength="4" maxlength="8" required
							class="input">
					</dd>

				</dl>

				<input type="submit" value="登録する" class="button">

			</form>
		</main>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>

</body>
</html>