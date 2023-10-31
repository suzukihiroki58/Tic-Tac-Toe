<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.GameRecord"%>
<%
GameRecord record = (GameRecord) request.getAttribute("gameRecord");
%>
<%@ page import="model.User"%>
<%
User loginUser = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人戦績</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th><%=request.getAttribute("loggedInUser")%>さんの戦績</th>
			</tr>
			<tr>
				<th>総プレイ数</th>
				<th>勝ち数</th>
				<th>負け数</th>
				<th>引き分け数</th>
				<th>勝率</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=record.getTotalGames()%></td>
				<td><%=record.getWins()%></td>
				<td><%=record.getLosses()%></td>
				<td><%=record.getDraws()%></td>
				<td><%=record.getWinRate()%></td>
			</tr>
		</tbody>
	</table>
	<a href="MenuServlet">メニューへ戻る</a>
</body>
</html>