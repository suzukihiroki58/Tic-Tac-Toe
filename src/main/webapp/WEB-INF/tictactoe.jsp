<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.TicTacToe"%>
<%
TicTacToe game = (TicTacToe) session.getAttribute("game");
char[][] board = game.getBoard();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="tictactoe.css">
<title>TicTacToe</title>
</head>
<body>
	<h2>
		ログイン中のユーザー：<%=request.getAttribute("loggedInUser")%></h2>
	<h2>TicTacToe</h2>

	<h2>
		先攻：<%=request.getAttribute("firstPlayer")%></h2>
	<h2>
		後攻：<%=request.getAttribute("secondPlayer")%></h2>

	<%
	String winner = (String) request.getAttribute("winner");
	if (winner == null) {
	%>
	<table border="1">
		<%
		for (int i = 0; i < 3; i++) {
		%>
		<tr>
			<%
			for (int j = 0; j < 3; j++) {
			%>
			<td>
				<form action="TicTacToeServlet" method="POST">
					<input type="submit" name="cell"
						value="<%=(board[i][j] == ' ' ? " " : board[i][j])%>"> <input
						type="hidden" name="row" value="<%=i%>"> <input
						type="hidden" name="col" value="<%=j%>">
				</form>
			</td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>

	<%
	} else {
	%>
	<h2>
		勝者：<%=winner%></h2>

	<table border="1">
		<%
		for (int i = 0; i < 3; i++) {
		%>
		<tr>
			<%
			for (int j = 0; j < 3; j++) {
			%>
			<td><%=(board[i][j] == ' ' ? " " : board[i][j])%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>

	<form action="TicTacToeServlet" method="POST">
		<input type="hidden" name="replay" value="true"> <input
			type="submit" value="再プレイ">
	</form>
	<a href="MenuServlet">メニューへ戻る</a>
	<%
	}
	%>


</body>
</html>