package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.PostBean;
import model.dao.PostDAO;

@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try {
			int postId = Integer.parseInt(request.getParameter("postId"));
			
			PostDAO pDao = new PostDAO();
			
			List<PostBean> postList = pDao.getPostDetail(postId);
			
			request.setAttribute("postList", postList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/post-detail.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int postId = Integer.parseInt(request.getParameter("postId"));
			
			PostDAO pDao = new PostDAO();
			
			List<PostBean> postList = pDao.getPostDetail(postId);
			
			request.setAttribute("postList", postList);
 			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/post-detail.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
