<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<form action="UserRegister" method="post">
		<label>ユーザー名</label>
		<input type="text" name="username" placeholder="30文字以内" required>
		<br>
		<label>パスワード</label>
		<input type="password" name="password" placeholder="30文字以内" required>
		<br>
		<input type="submit" value="新規ユーザー登録" class="button">
	</form>
</body>
</html>