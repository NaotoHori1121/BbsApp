<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/threadManagement.css">
<title>スレッド管理</title>
</head>
<body>
	<header>
	<form action="BackAdminMainMenuServlet" method="get">
			<input type="submit" value="管理者メインメニューへ戻る" class="backbutton">
		</form>
	</header>
	<p>
		<font color="red"> <!-- スレッド一覧取得失敗でメッセージ表示 --> <c:out
				value="${message}" />
		</font>
	</p>
	<c:remove var="message" />
	<!-- セッションスコープからインスタンスを削除 -->

	<main>
		<form class="deleteThread" action="DeleteThreadServlet" method="post">
			<h1>スレッドの削除</h1>
			<p>
				<font color="red"> <!-- 削除失敗でメッセージ表示 --> <c:out
						value="${deleteMessage}" />
				</font>
			</p>
			<c:remove var="deleteMessage" />
			<!-- セッションスコープからインスタンスを削除 -->
			<p>
				スレッドID:<input type="number" name="threadId" required>
			</p>

			<p>
				スレッドタイトル:<input type="text" name="title" required>
			</p>

			<p>
				<input type="submit" value="削除" class="button">
			</p>

		</form>
	</main>

	<div class="allthread">
		<!-- 全スレッド表示 -->

		<c:forEach var="threads" items="${allThread}">
			<form action="DeleteThreadServlet" method="post">
				<input type="hidden" value="${threads.getThreadId()}"
					name="threadId"> <input type="hidden"
					value="${threads.getThreadTitle()}" name="title">
				<table>
					<tr>

						<th>スレッドID: <c:out value="${threads.getThreadId()}" /></th>
						<th>スレッドタイトル: <c:out value="${threads.getThreadTitle()}" /></th>
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