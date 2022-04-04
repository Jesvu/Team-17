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
import data.Kysymykset;


@WebServlet(	
		name = "Deleteysymykset",
		urlPatterns = {"/delete"}
		)
public class DeleteKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	/*
	@Override
	public void init() {
		dao=new Dao();
	}
       */
   

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Dao dao=new Dao();
		ArrayList<Kysymykset> kys = dao.readAllKysymykset();
		

		session.setAttribute("allkysymykset", kys);
	    
	    RequestDispatcher rd=request.getRequestDispatcher("/jsp/kysymykset.jsp");
		rd.forward(request, response);
	}
		
	 @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		  doGet(request, response);
	 }
}