package app;

	import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

	@WebServlet(
	    name = "ShowData",
	    urlPatterns = {"/ehdokkaat"}
	)
	public class ShowData extends HttpServlet {

	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		System.out.println("doget");
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Info> infos = dao.readAllInfo();
		
		System.out.println("infos " + infos.size());
		
		session.setAttribute("allinfos", infos);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/data.jsp");
		rd.forward(request,  response);
	}
			
	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		  doGet(request, response);
		
	}}