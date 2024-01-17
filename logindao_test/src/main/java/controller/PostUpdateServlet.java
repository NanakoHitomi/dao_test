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

@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int postId = Integer.parseInt(request.getParameter("postId"));
			
			PostDAO pDao = new PostDAO();
			
			List<PostBean> postLists = pDao.getPostDetail(postId);
			
			request.setAttribute("postLists", postLists);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String view = "/WEB-INF/views/post-edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	



}
