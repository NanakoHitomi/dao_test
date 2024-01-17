<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポスト新規投稿</title>
</head>
<body>
	 <h1>ポストを作成</h1>
<%-- 	<input type="hidden" name="userId" value="<%= posts.getPostId() %>"> --%>
    <form method="POST" action="newpost">
        <label for="title">タイトル:</label>
        <input type="text" id="title" name="title"><br>
        
        <label for="comment">コメント:</label><br>
        <textarea name="comment" id="" cols="30" rows="10"></textarea>        
        
        <input type="submit" value="保存">
</body>
</html>