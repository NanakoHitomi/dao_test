<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
<%@ page import="model.bean.PostBean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポスト更新画面</title>
</head>
<body>
 <%
 List<PostBean> postLists = (List<PostBean>) request.getAttribute("postLists");
 for (PostBean posts : postLists) {
 %>
 
 <form action="PostEditServlet" method="post">
 
 	<input type="hidden" name="postId" value="<%= posts.getPostId() %>">
 	
	<label>タイトル：</label><input type="text" name="title" value="<%=posts.getTitle() %>"><br>
	
	<label>コメント</label><input type="text" name="comment" value="<%=posts.getComment() %>"><br>
	
	<label for="posDate">投稿日</label><%=posts.getPostDate() %><br>
	
<%-- <%
 }
%> --%>
	
				
				<button type="submit">更新する</button>
</form>
<br>

	<a href="PostDetailServlet?postId=<%= posts.getPostId() %>">詳細に戻る</a>
	
	<%
 }
%>

			
</body>
</html>