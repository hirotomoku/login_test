<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインエラー</title>
<% String str = (String)session.getAttribute("mailaddress"); %>
</head>
<body>
	<form action="Loginservlet" method="post">
	<table>
		<tr>
			<td><font color = RED>メールアドレスかパスワードが間違っています。</font></td>
		</tr>
		<tr>
			<td>メールアドレス</td>
		</tr>
		<tr>
			<td><input type="text" value=""placeholder="<%=str %>" name="mailaddress" required></td>
		</tr>
		<tr>
			<td>パスワード</td>
		</tr>
		<tr>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td><input type="hidden" name="page_num" value="0">
			<input type="submit" value="送信" name="button">
			<input type="reset" value="リセット" name="button2">
			</td>
		</tr>
		<tr>
			<td><br></td>
		</tr>
		<tr>
			<td><a href = "Register.jsp">新規会員登録</td>
		</tr>
	</table>
	</form>

</body>
</html>