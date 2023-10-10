<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF8");
String strMessage = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="tictactoe.css">
<title>TicTacToe</title>
</head>
<body>
	<h2>TicTacToe</h2>
	
	<!--　ランダムで先攻後攻が決定し、ゲーム開始-->

	<!--　もしゲームが終了していなければ、どこにSymbolを置くか選ぶ-->

	<form action="TicTacToeServlet" method="POST">
		<label for="number">1〜9の好きな場所を入力してください</label> <input id="number"
			name="number" type="number " min="1" max="9" /> <input type="submit"
			value="Submit">
			
		<table border="1">
		<tr>
			<td><button type="submit" name="action" value="1">1</button></td>
			<td><button type="submit" name="action" value="2">2</button></td>
			<td><button type="submit" name="action" value="3">3</button></td>
		</tr>
		<tr>
			<td><button type="submit" name="action" value="4">4</button></td>
			<td><button type="submit" name="action" value="5">5</button></td>
			<td><button type="submit" name="action" value="6">6</button></td>
		</tr>
		<tr>
			<td><button type="submit" name="action" value="7">7</button></td>
			<td><button type="submit" name="action" value="8">8</button></td>
			<td><button type="submit" name="action" value="9">9</button></td>
		</tr>
	</table>
	</form>
	<p>
		submitした値：<%=strMessage%>
	</p>
	
	<!--　もしゲームが終了していれば、勝敗結果と再プレイボタンを表示する-->
</body>
</html>