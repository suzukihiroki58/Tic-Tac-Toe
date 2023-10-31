<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User loginUser = (User) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
<%=loginUser.getUserName()%>さんがログインしました
<p><a href="TicTacToeServlet"><button type="button">ゲームを始める</button></a></p>
<p><a href="LoginUserRecordServlet"><button type="button">個人戦績を見る</button></button></a></p>
<p><a href="RankingServlet"><button type="button">勝率ランキングを見る</button></button></a></p>
<p><a href="LogoutServlet"><button type="button">ログアウト</button></a></p>
</body>
</html>