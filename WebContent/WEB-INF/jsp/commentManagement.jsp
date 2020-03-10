<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/commentManagement.css">
<title>コメント管理</title>
</head>
<body>
	<header>
		<form action="BackAdminMainMenuServlet" method="get">
			<input type="submit" value="管理者メインメニューへ戻る" class="backbutton">
		</form>
	</header>

	<main>
		<form class="deleteComment" action="DeleteCommentIncludeNGWordServlet"
			method="post">
			<h1>コメントの削除</h1>
			<p>
				<font color="red"> <!-- 削除失敗でメッセージ表示 --> <c:out
						value="${deleteMessage}" />
				</font>
			</p>
			<c:remove var="deleteMessage" />
			<!-- セッションスコープからインスタンスを削除 -->
			<p>
				削除するワード:<input type="text" name="word" required>
			</p>

			<p>
				<input type="submit" value="削除" class="button">
			</p>

		</form>
	</main>

	<div class="allcomment">
		<!-- 全スレッド表示 -->
		<p>
			<font color="red"> <!-- スレッド一覧取得失敗でメッセージ表示 --> <c:out
					value="${message}" />
			</font>
		</p>
		<c:remove var="message" />
		<!-- セッションスコープからインスタンスを削除 -->

		<c:forEach var="comments" items="${allComment}">
			<form action="DeleteCommentServlet" method="post">
				<input type="hidden" value="${comments.getCommentId()}"
					name="commentId">
				<table>
					<tr>
						<th>スレッドID: <c:out value="${comments.getThreadId()}" /></th>
						<th>コメントID: <c:out value="${comments.getCommentId()}" /></th>
						<th>投稿内容: <c:out value="${comments.getComment()}" /></th>
						<th><input type="submit" value="1件削除" class="button"></th>
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