package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.util.SecurityUtils;

import dao.LoginDao;
import security.SecurityUtils;

@WebServlet(
		name = "CheckServlet",
		urlPatterns = {"/check"}
		)

public class CheckServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect("loginPage.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		LoginDao dao = new LoginDao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		String salt = dao.getUserSalt(uname);
		String hashpw = dao.getUserPasswordHash(uname);
		
		dao.close();
		
		if (SecurityUtils.isPasswordOk(hashpw, password, salt)) {
			response.getWriter().println("Login success");
		} else {
			response.getWriter().println("Login failed");
		}
		
	}
}
