<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet" href="css/newThread.css">
<title>スレッド作成</title>
</head>
<body>
	<div class="wrapper">
	<header>
		<form action="BackMainMenuServlet" method="get">
			<input type="submit" value="メインメニューへ戻る" class="backbutton">
		</form>
	</header>

		<main>
			<form action="NewThreadServlet" method="post">
				<h1>スレッド作成</h1>
				<h2>-入力項目-</h2>
				<p>
					<font color="red">
						<!-- 既に登録されているユーザー名を入力でメッセージ表示 --> <c:out value="${message}" />
					</font>
				</p>
				<c:remove var="message" />
				<!-- セッションスコープからインスタンスを削除 -->
				<dl>
					<dt>作成者</dt>
					<dd>
						<input type="text" name="name" value="${name }" readonly>
					</dd>
					<dt>タイトル</dt>
					<dd>
						<input type="text" name="title" placeholder="title" maxlength="40"
							required>
					</dd>
					<dt>スレッド説明</dt>
					<dd>
						<textarea name="comment" placeholder="任意入力90文字まで" maxlength="90"></textarea>
					</dd>
					<dt>ジャンル</dt>
					<dd>
						<select name="genre">
							<option value="Java">Java</option>
							<option value="PHP">PHP</option>
							<option value="Python">Python</option>
							<option value="Ruby">Ruby</option>
							<option value="JavaScript">JavaScript</option>
							<option value="Kotolin">Kotolin</option>
							<option value="Scala">Scala</option>
							<option value="HTML">HTML</option>
							<option value="CSS">CSS</option>
						</select>
					</dd>

				</dl>
				<input class="button" type="submit" value="作成する">

			</form>
		</main>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>




</body>
</html>