<%--この部分はコメントです。
これがJSPのサンプルです。JSPは、サーブレットを拡張し、「HTML」の中にJava言語を記述できるようにした形式で、拡張子は
「.jsp」になります。Eclipseでは、ファイル→新規→web→JSPで作成できます。
　このJSPでは、スクリプトレットという「<%」で始まるタグを使い、その中にJava言語でtable作成の処理を記述しています。
スクリプトレットは下記３種類があります。
　<%!  %>  変数、メソッドの提示をする時つかいます。この宣言はstaticにしたのと同様になります。
  <%   %>　Java言語で処理を記述するときに使います。
  <%=  %>　Javaでの記述の値（変数の値や式の返答値）をHTMLとして表示したいとき使います。
J
JSPの中でJavaを記述する方法として、JSTL、アクションタグ、EL式ながありますが、タグ形式な文体になっているので、別途
学習が必要です。
 --%>

<%-- <%@始まるJSPの動作に関する設定文をディレクティブと言います。下記の２文は、Pageディレクティブと言います。 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%--別のところになる、クラスをimportしています。 --%>
<%@ page import="common.CommonInfo"%>

<!DOCTYPE html>
<!-- ここから下は、HTML形式です。　コメントの記号も変わります。 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comfirm</title>
<link rel="stylesheet" href="Table.css">
</head>
<body>
	<form action="Registerservlet" method="post">
	<table>
		<tr>
			<td>この内容で登録します。</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
		</tr>
		<tr>
			<td><input type="text" name="mailaddress" required></td>
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
			<td><input type="text" name="sei" required></td>
		</tr>
		<tr>
			<td>名</td>
		</tr>
		<tr>
			<td><input type="text" name="mei" required></td>
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
