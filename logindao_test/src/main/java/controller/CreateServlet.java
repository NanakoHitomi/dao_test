package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import hashedPassword.HashPW;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CreateDAO;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/create.jsp";
		request.getRequestDispatcher(view).forward(request, response);
		
		//ここから追加
//		UserBean user = (UserBean)request.getSession().getAttribute("user");
//		
//		if (user == null) {
//			response.sendRedirect("LoginServlet");
//			return;
//		}
//		
//		response.sendRedirect("/WEB-INF/views/list.jsp");
//		
//		//ここまで
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		CreateDAO createdao = new CreateDAO();
//		
//		try {
//			int result = createdao.createDAO(username, password);
//			if(result == 1) {
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
		
		//ここから追加
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String hashedPass = null;
		try {
			hashedPass = HashPW.hashPass(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		CreateDAO cDao = new CreateDAO();
		
		try {
			int result = cDao.createDAO(username, email, hashedPass);
			if (result == 1) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
