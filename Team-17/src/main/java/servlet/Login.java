package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddUserDao;
import servlet.security.SecurityUtils;

@WebServlet(
    name = "Login",
    urlPatterns = {"/login"}
)

public class Login extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("loginPage.html");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		AddUserDao dao = new AddUserDao();
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		String salt = dao.getUserSalt(uname);
		String hashpw = dao.getUserPasswordHash(uname);
		
		dao.close();
		
		if (SecurityUtils.isPasswordOk(hashpw, pass, salt)) {
			response.sendRedirect("jsp/adminPage.jsp");
		} else {
			response.getWriter().println("Login failed");
		}
		
	}	
}
