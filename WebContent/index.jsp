<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet" href="css/index.css">
<title>solveトップ</title>

</head>
<body>
	<div class="wrapper">

		<header>
			<img class="solve" src="image/logologo.png">
		</header>


		<div class="main">

			<p class="successmessage">
				<c:out value="${successmessage}" />
				<!-- 新規登録成功 -->
			</p>
			<c:remove var="successmessage" />
			<!-- セッションスコープからインスタンスを削除 -->


			<h2>--プログラミングの分からないを解決しよう--</h2>

			<div class="explain">
				<p>プログラミングは常にトライ＆エラーとの闘いです。</p>
				<p>一人で悩む時間も重要なことですが、</p>
				<p>必要以上に時間をかけるのは効率が良くありません</p>
				<p>
					このサイトでは<span class="explainmessage">"Solve＝解決する"</span>を目的とし、
				</p>
				<p>プログラミングについて自由に話し合いができる場となっています</p>
				<p>経験者はもちろんのこと初学者の方でも是非ご自由に参加してください</p>
			</div>
			<div class="login_button">
				<a href="userLogin.jsp" class="button1">ユーザーログイン</a> <a
					href="adminLogin.jsp" class="button2">管理者ログイン</a>
			</div>

			<p class="newregister">
				アカウントをお持ちでない場合はこちら<a href="newRegister.jsp"><span
					class="newregisterlink">新規登録</span></a>
			</p>

		</div>

		<footer>
			<jsp:include page="footer.jsp" />
		</footer>

	</div>
</body>

</html>