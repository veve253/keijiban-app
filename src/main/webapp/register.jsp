<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>ユーザー登録</title>
</head>
<body>
    <h1>新規ユーザー登録</h1>

    <form action="/keijiban-app/user/register" method="post">
        <label for="username">ユーザー名：</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">パスワード：</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">登録</button>
    </form>

    <p>すでにアカウントをお持ちの方は <a href="login.jsp">ログイン</a></p>
</body>
</html>
