package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import hashedPassword.HashPW;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.UserBean;
import model.dao.LoginDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        String view = "login.jsp";
        //ここで定義したviewをgetrequestDispatcher()に入れる
        req.getRequestDispatcher(view).forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
	     String hashedPass = null;
	     
	     try {
	    	 hashedPass = HashPW.hashPass(password);
	     } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	     
	     
	        
	        UserBean	userbean = new UserBean();
	        LoginDAO logindao = new LoginDAO();
	        
	        userbean.setEmail(email);
	        userbean.setPassword(password);
	        System.out.println("Email: " + email);
	        System.out.println("Password: " + password);
	        System.out.println("Hashed Password: " + hashedPass);

	        
	        try {
	        	//どこから情報を持ってきてるか
	        		if(logindao.validate(email, hashedPass)) {
	        			//フォワードは情報を渡す（ミスったら変える）
	        			//属性を渡すときはフォワード（リクエストスコープで渡す時）
	        			//基本フォワード使う
	        			HttpSession session = request.getSession();
	        			session.setAttribute("loginUser", logindao.getUserId(email));
	        			
	        			
//	        			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	        			response.sendRedirect("ListServlet");
	        		} else {
//	        			HttpSession session = request.getSession();
//	        			session.setAttribute("loginError", "error");
	        			//リダイレクトは情報を渡さない
	        			response.sendRedirect("login.jsp");
					}
	        	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String hashedPass = null;
//        
//        try {
//			hashedPass = HashPW.hashPass(password);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//	}
//        LoginDAO lDao = new LoginDAO();
//        
//        try {
//        	UserBean userBean =lDao.validate(email, hashedPass);
//        	int userId = lDao.getUserId(email);
//        	if((userBean != null) && (userBean.isUserStatus() == true)) {
//        		request.getSession().setAttribute("user", userBean);
//  				request.getSession().setAttribute("userId", userId);
//  				request.getSession().setAttribute("password", password);				
//  				response.sendRedirect("ListServlet");
//        	} else {
//        		response.sendRedirect("login.jsp");
//        	}
//        } catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
