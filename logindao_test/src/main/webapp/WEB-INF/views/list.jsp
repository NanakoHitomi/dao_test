<%@page import="model.bean.PostBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ポスト一覧</title>
</head>
<body>
<h1>ポスト一覧</h1>
<span><strong>ID</strong></span>
	<span><strong>タイトル</strong></span></br>
	
<%
	List<PostBean> list = (List<PostBean>)request.getAttribute("postList");
	for (PostBean post : list) {
	%>
	<span><%= post.getPostId() %></span>
	<span><a href='PostDetailServlet?postId=<%= post.getPostId() %>'><%= post.getTitle() %></a></span><br>
	
	
	<% } %>
	
	
	<p><a href="newpost">新規作成</a></p>
	<p><a href="logout">ログアウト</a></p>

</body>
</html>