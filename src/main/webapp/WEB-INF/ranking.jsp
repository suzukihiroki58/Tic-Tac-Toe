<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.GameRecord" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勝率ランキング</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>ユーザー名</th>
			<th>総プレイ数</th>
			<th>勝ち</th>
			<th>負け</th>
			<th>引き分け</th>
			<th>勝率</th>
		</tr>
		<%
			List<GameRecord> ranking= (List<GameRecord>) request.getAttribute("ranking");
			for (GameRecord record : ranking) {
		%>
		<tr>
			<td><%= record.getUserName() %></td>
			<td><%= record.getTotalGames() %></td>
			<td><%= record.getWins() %></td>
			<td><%= record.getLosses() %></td>
			<td><%= record.getDraws() %></td>
			<td><%= record.getWinRate() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="MenuServlet">メニューへ戻る</a>
</body>
</html>