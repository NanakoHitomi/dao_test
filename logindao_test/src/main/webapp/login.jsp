<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.bean.*" %>

<%-- <% UserBean loginUser = (loginUser)request.getSession().getAttribute("user"); %> --%>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<!-- リクエストスコープからエラーメッセージを受け取る -->
<%-- <%String failureMessage = (String)request.getAttribute("loginFailure); %> --%>

<!-- エラーメッセージが存在する時だけ表示 -->
<%-- <% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %> --%>


    <h1>Login</h1>
    
<!-- ログインフォームここから。ユーザーネームとパスワードの入力 -->
<!-- action="login"で＠Webservlet("/login")へ -->
    <form method="POST" action="login">
    
    <!-- formを使って、ユーザーネームをusername、パスワードをpasswordという名前でサーブレットに送っている -->
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        
      <!--   submitのログインボタン -->
        <input type="submit" value="Login">
    </form>

	<!-- ここで@Webservlet("/createacount")へ遷移 -->
    <p>or <a href="create">Create User</a></p>
</body>
</html>