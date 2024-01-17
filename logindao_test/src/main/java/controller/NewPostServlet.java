package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PostDAO;

@WebServlet("/newpost")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/new-post.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		
		PostDAO pDao = new PostDAO();
		
		try {
			int result = pDao.newPost(title, comment);
			if(result == 1) {
//				request.getRequestDispatcher("/WEB-INF/views/list.jsp");
				response.sendRedirect("ListServlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
