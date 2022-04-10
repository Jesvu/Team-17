package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import app.Info;

@WebServlet(
		name = "RemoveCandidate",
		urlPatterns = {"/removecandidate"}
		)


public class RemoveCandidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect("jsp/AdminPage.jsp");
		Dao dao= new Dao();
		Info candidate = readCandidate(request);
		dao.RemoveCandidate(candidate.getEhdokas_id());
		dao.close();
		
		response.sendRedirect("jsp/AdminPage.jsp");

	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
			response.sendRedirect("jsp/AdminPage.jsp");
	}

	private Info readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Info candidate=new Info();
		
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidate;
	}

}