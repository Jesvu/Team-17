package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

@WebServlet(
    name = "Login",
    urlPatterns = {"/login"}
)

public class Login extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("loginPage.html");
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginDao LoginDao = new LoginDao();
		
		if(LoginDao.check(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("Welcome.html");
		}
		else {
			response.sendRedirect("LoginPage.html");
		}
		
	}	
}
