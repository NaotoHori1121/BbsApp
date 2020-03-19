<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/balzss/luxbar/ae5835e2/build/luxbar.min.css">
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
		<header id="luxbar" class="luxbar-fixed">
			<input type="checkbox" class="luxbar-checkbox" id="luxbar-checkbox" />
			<div class="luxbar-menu luxbar-menu-right luxbar-menu-light">
				<ul class="luxbar-navigation">
					<li class="luxbar-header"><a href="LogoutServlet" class="luxbar-brand"><img
							class="solve" src="./image/logologologo.png"></a> <span>ユーザー名:<c:out value="${name}" /></span>
							<label
						class="luxbar-hamburger luxbar-hamburger-doublespin"
						id="luxbar-hamburger" for="luxbar-checkbox"> <span></span>
					</label></li>
					<li class="luxbar-item"><a href="BackMainMenuServlet">メニュー画面へ</a></li>
					<li class="luxbar-item"><a href="LogoutServlet">ログアウト</a></li>
				</ul>
			</div>
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
						<dt><span style="font-size:12px;">タイトル:</span>${title}</dt>
						<dd class="explain"><span style="font-size:10px;">スレッド説明....</span>${threadComment}</dd>
						<dd class="threadcreateuser">作成者:${createThreadUserName}</dd>
					</dl>
				</div>

				<div class="allcomment">

					<c:forEach var="comment" items="${allComments}">
						<ul>
							<li class="userandtime">ユーザー名:${comment.getUserName()}
								投稿時間:${comment.getDateTime()}</li>
							<li class="comment">${comment.getUserName()}<br>「${comment.getComment()}」</li>
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
						<dt class="postuser">投稿者</dt>
						<dd class="postuser">
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
			<a href="#"><i class="fa fa-chevron-up"></i>UP</a>
		</p>
		<footer>
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
</body>
</html>