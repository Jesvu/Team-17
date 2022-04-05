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

@WebServlet(
    name = "DeleteKysymykset",
    urlPatterns = {"/delete"}
)
public class DeleteKysymykset extends HttpServlet {
	
	private Dao dao;
	
	public void init() {
		dao=new Dao();
	}
		
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String kysymys_id=request.getParameter("id");
		ArrayList<Kysymykset> kys=null;
		if (dao!=null) {
			kys=dao.deleteKysymykset(kysymys_id);
		}
		request.setAttribute("allkysymykset", kys);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/kysymykset.jsp");
		rd.forward(request, response);
	}
}
