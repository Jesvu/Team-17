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
		name = "ShowKysymykset",
		urlPatterns = {"/showkysymykset"}
		)
public class ShowKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao();
	}
       
   
    public ShowKysymykset() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kysymykset> list=null;
		dao=new Dao();
		list=dao.readAllKysymykset();
		request.setAttribute("kysymyksetlist", list);
		
		if (list != null && list.size() > 0) {
			
		} else {
			System.out.print("lista tyhjä");
		}
	}
	
}