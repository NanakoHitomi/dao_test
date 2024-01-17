<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@page import="model.bean.PostBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ポスト詳細</title>
</head>
<body>
 <%
 List<PostBean> postList = (List<PostBean>)request.getAttribute("postList"); 
 for (PostBean post : postList) {
 %>
 
 <table>
	    <tr>
	        <td><label for="title">タイトル</label></td>
	      <td><%=post.getTitle() %></td> 
	    </tr>
	    <tr>
	        <td><label for="comment">コメント</label></td>
	        <td><%=post.getComment() %></td>
	    </tr>
	    <tr>
	        <td><label for="posDate">投稿日</label></td>
	        <td><%=post.getPostDate() %></td>
	    </tr>
	</table>
	
	
	<p><a href="ListServlet">戻る</a></p>
	  <button class="btn"><a href="PostUpdateServlet?postId=<%= post.getPostId() %>">更新</a></button>
	  <button class="btn"><a href="PostDeleteServlet?postId=<%= post.getPostId() %>">削除</a></button>
	 <%--   <button class="btn"><a href="PostRestorationServlet?postId=<%= post.getPostId() %>">復活</button></a> --%>
  
 <% 
 	}
 %>  
 
 
</body>
</html>