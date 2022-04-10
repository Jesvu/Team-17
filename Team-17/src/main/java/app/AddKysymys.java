package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Kysymykset;

/**
 * Servlet implementation class AddKysymys
 */
@WebServlet("/addkysymys")
public class AddKysymys extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao=new Dao();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("/showadmin");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String kysymys_id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		int kysymysid = Integer.parseInt(kysymys_id);
		
		Kysymykset k=new Kysymykset(kysymysid, kysymys);
		
		ArrayList<Kysymykset> kys=null;
		if (dao!=null) {
			kys=dao.addKysymys(k);
		}
		
		request.setAttribute("allkysymykset", kys);
		RequestDispatcher rd=request.getRequestDispatcher("/showadmin");
		rd.forward(request, response);
	}
}