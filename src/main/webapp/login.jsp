<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
</head>
<body>
    <h2>ログイン</h2>

    <form action="/keijiban-app/user/login" method="post">
        <label for="username">ユーザー名：</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">パスワード：</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="ログイン">
    </form>

    <p><a href="register.jsp">新規登録はこちら</a></p>

    <%-- エラーメッセージの表示（ログイン失敗時） --%>
    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
        <p style="color:red;">ログインに失敗しました。ユーザー名またはパスワードが正しくありません。</p>
    <%
        }
    %>
</body>
</html>
