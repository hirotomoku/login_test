<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UnmatchPath</title>
<%String mail = (String)session.getAttribute("mailaddress");
String sei = (String)session.getAttribute("sei");
String mei = (String)session.getAttribute("mei");
%>
</head>
<body>
	<p><font color = RED>パスワードが一致しませんでした</font></p>
	<form action="Registerservlet" method="post">
	<table>
		<tr>
			<td>メンバー登録画面</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
		</tr>
		<tr>
			<td><input type="text" name="mailaddress" value ="<%=mail%>"required></td>
		</tr>
		<tr>
			<td>パスワード</td>
		</tr>
		<tr>
			<td><input type="password" name="password1" required></td>
		</tr>
		<tr>
			<td>パスワード(再入力)</td>
		</tr>
		<tr>
			<td><input type="password" name="password2" required></td>
		</tr>
		<tr>
			<td>姓</td>
		</tr>
		<tr>
			<td><input type="text" name="sei" value ="<%=sei%>" required></td>
		</tr>
		<tr>
			<td>名</td>
		</tr>
		<tr>
			<td><input type="text" name="mei" value ="<%=mei%>" required></td>
		</tr>
		<tr>
			<td><input type="hidden" name="page_num" value="0">
			<input type="submit" value="送信" name="button">
			<input type="reset" value="リセット" name="button2">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>