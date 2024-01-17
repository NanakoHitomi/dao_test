package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PostDAO;

@WebServlet("/PostEditServlet")
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//パラメータ取得
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		 int postId = Integer.parseInt(request.getParameter("postId"));
		 
		 //データベース更新
		 try {
			 PostDAO pDao = new PostDAO();
			 int postUpdated = pDao.postUpdate(title, comment, postId);
			 
			 request.getSession().setAttribute("post", postUpdated);
			 
			 if (postUpdated > 0) {
				 
				 String forward = "/PostDetailServlet?postId=" + postId;
		
	             RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
	             dispatcher.forward(request, response);
	             
	             System.out.println("成功"); 
			 } else {
	        	 System.out.println("失敗");
			 }
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
