package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddUserDao;
import servlet.security.SecurityUtils;

@WebServlet(
		name = "AddUser",
		urlPatterns = {"/adding"}
		)
public class AddUser extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("jsp/AdminPage.jsp");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		AddUserDao dao = new AddUserDao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Create salt and hashed PW
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(password, salt);
		
		dao.adding(uname, hashpw, salt);
		
		dao.close();
		response.sendRedirect("jsp/AdminPage.jsp");
	}

}
