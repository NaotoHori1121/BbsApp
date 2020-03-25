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
<link rel="stylesheet" href="css/userMainMenu.css">
<title>ユーザーメインメニュー</title>
<!-- jQuery -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	//page topボタン

	$(function() {
		var topBtn = $('#pageTop');
		topBtn.hide();

		// ボタンをクリックしたら、スクロールして上に戻る
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
    <input type="checkbox" class="luxbar-checkbox" id="luxbar-checkbox"/>
    <div class="luxbar-menu luxbar-menu-right luxbar-menu-light">
        <ul class="luxbar-navigation">
            <li class="luxbar-header">
                <a href="WebContent/userMainMenu.jsp" class="luxbar-brand"><img class="solve"
						src="./image/logologologo.png"></a><span class="username">ようこそ<c:out value="${name}" />さん</span>
                <label class="luxbar-hamburger luxbar-hamburger-doublespin"
                id="luxbar-hamburger" for="luxbar-checkbox"> <span></span> </label>
            </li>
            <li class="luxbar-item"><a href="SelectNewThreadServlet">新しい掲示板の作成</a></li>
            <li class="luxbar-item"><a href="LogoutServlet">ログアウト</a></li>
        </ul>
    </div>
</header>
		<div class="container">
			<div class="languagelist">
				<ul>
					<li><a href="SelectGenreServlet?genreId=0" class="all">全て</a></li>
					<li><a href="SelectGenreServlet?genreId=1" class="java">Java</a></li>
					<li><a href="SelectGenreServlet?genreId=2" class="php">PHP</a></li>
					<li><a href="SelectGenreServlet?genreId=3" class="python">Python</a></li>
					<li><a href="SelectGenreServlet?genreId=4" class="ruby">Ruby</a></li>
					<li><a href="SelectGenreServlet?genreId=5" class="javascript">JavaScript</a></li>
					<li><a href="SelectGenreServlet?genreId=6" class="kotolin">Kotolin</a></li>
					<li><a href="SelectGenreServlet?genreId=7" class="scala">Scala</a></li>
					<li><a href="SelectGenreServlet?genreId=8" class="html">HTML</a></li>
					<li><a href="SelectGenreServlet?genreId=9" class="css">CSS</a></li>
				</ul>
			</div>
			<div class="main">
				<div class="threads">

					<c:forEach var="thread" items="${threadList}">
						<input type="hidden" name="threadId"
							value="${thread.getThreadId()}">
						<!-- hiddenでthreadIdを送る -->
						<ul>
							<li class="first"> ${thread.getThreadTitle()}</li>
							<li class="second">${thread.getThreadComment()}</li>
							<li class="third">スレッド設置者:${thread.getUserName()} <a
								href="SelectThreadServlet?threadId=${ thread.getThreadId() }"></a></li>

						</ul>
					</c:forEach>
				</div>
				<div class="side">

					<c:if test="${genreimg == \"0\"}">
						<img src="image/all.png" class="img">
					</c:if>
					<c:if test="${genreimg == \"1\"}">
						<img src="image/java2.jpg" class="img">
					</c:if>
					<c:if test="${genreimg == \"2\"}">
						<img src="image/php2.png" class="img">
					</c:if>
					<c:if test="${genreimg == \"3\"}">
						<img src="image/python.jpg" class="img">
					</c:if>
					<c:if test="${genreimg == \"4\"}">
						<img src="image/ruby2.png" class="img">
					</c:if>
					<c:if test="${genreimg == \"5\"}">
						<img src="image/javascript2.jpg" class="img">
					</c:if>
					<c:if test="${genreimg == \"6\"}">
						<img src="image/kotolin.jpg" class="img">
					</c:if>
					<c:if test="${genreimg == \"7\"}">
						<img src="image/scala.png" class="img">
					</c:if>
					<c:if test="${genreimg == \"8\"}">
						<img src="image/html2.png" class="img">
					</c:if>
					<c:if test="${genreimg == \"9\"}">
						<img src="image/css2.png" class="img">
					</c:if>

					<form action="InputSearchThreadTitleServlet" method="post">
					<div class="search">
					<p>
						<input type="search" placeholder="スレッドタイトルの検索" name="inputword">
					</p>
					<p><input type="submit" value="検索する"></p>
					</div>
					</form>
					<p>
						<a href="SelectNewThreadServlet">新しい掲示板の作成</a>
					</p>
				</div>
			</div>

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