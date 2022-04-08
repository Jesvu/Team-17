package app;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Kysymykset;

@WebServlet(
    name = "Update",
    urlPatterns = {"/update"}
)
public class Update extends HttpServlet {
	
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		//String kysymys_id=request.getParameter("id");
		//System.out.println("doget " + kysymys_id);
		RequestDispatcher rd=request.getRequestDispatcher("/showupdate");
		rd.forward(request, response);
		//response.sendRedirect("/showupdate");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String kysymys_id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		int kysymysid = Integer.parseInt(kysymys_id);
		
		Kysymykset k=new Kysymykset(kysymysid, kysymys);
		
		Kysymykset kys=null;
		Dao dao = new Dao();
		if (dao!=null) {
			kys=dao.updateKysymys(k);
		}
		
		request.setAttribute("allkysymykset", kys);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/UpdateKysymykset.jsp");
		rd.forward(request, response);
	}
}