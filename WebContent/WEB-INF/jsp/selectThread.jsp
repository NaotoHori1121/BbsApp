<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/selectThread.css">
<title><c:out value="${title}"></c:out></title>
<!-- jQuery -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	//■page topボタン

	$(function() {
		var topBtn = $('#pageTop');
		topBtn.hide();

		// ◇ボタンをクリックしたら、スクロールして上に戻る
		topBtn.click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
			return false;

		});

	});
</script>
</head>
<body>
	<div class="wrapper">
		<header>
			<ul>
				<li><a href="index.jsp"><img class="solve"
						src="./image/logologo.png"></a></li>
				<li>ユーザー名:<c:out value="${name}" /></li>
				<li><a href="BackMainMenuServlet">メニュー画面へ</a></li>
				<li><a href="LogoutServlet">ログアウト</a></li>
			</ul>
		</header>
		<div class="container">
			<main>
				<p>
					<font color="red"> <!--コメントが追加できなければ表示 --> <c:out
							value="${message}" />
					</font>
				</p>
				<c:remove var="message" />
				<!-- セッションスコープからインスタンスを削除 -->

				<div class="threadinfo">
					<dl>
						<dt>${title}</dt>
						<dd class="explain">スレッド説明....${threadComment}</dd>
						<dd class="threadcreateuser">作成者:${createThreadUserName}</dd>
					</dl>
				</div>


				<div class="allcomment">

					<c:forEach var="comment" items="${allComments}">
						<ul>
							<li class="userandtime">ユーザー名:${comment.getUserName()}
								投稿時間:${comment.getDateTime()}</li>
							<li class="comment">${comment.getUserName()}「${comment.getComment()}」</li>
						</ul>
					</c:forEach>
					<c:remove var="comment" />
				</div>
			</main>
			<form action="NewCommentServlet" method="post">
				<input type="hidden" name="threadId" value="${threadId}">
				<!-- コメント追加で使うため -->

				<div class="commentform">
					<dl>
						<dt class="formtitle">コメント投稿</dt>
						<dt>投稿者</dt>
						<dd>
							<input type="text" name="name" value="${name }" readonly>
						</dd>
						<dt>投稿内容</dt>
						<dd>
							<textarea name="comment" placeholder="投稿内容を入力してください" required></textarea>
						</dd>
					</dl>
					<input type="submit" value="投稿する" class="button">
				</div>
			</form>

		</div>
		<p id="pageTop">
			<a href="#"><i class="fa fa-chevron-up"></i>(↑)</a>
		</p>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
</body>
</html>