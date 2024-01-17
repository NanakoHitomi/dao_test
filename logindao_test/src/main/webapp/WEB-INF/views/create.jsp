<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>アカウント新規登録</title>
</head>
<body>
    <h1>Create</h1>
    <form method="POST" action="create">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="username">Email:</label>
        <input type="text" id="email" name="email"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        
        
        <input type="submit" value="Create">
    </form>
</body>
</html>
