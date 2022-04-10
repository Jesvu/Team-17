package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Info;
import dao.Dao;
import data.Kysymykset;
import data.test;


@WebServlet("/showadmin")
public class ShowAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;
	
	@Override
	public void init() {
		dao = new Dao();
	}
       
    public ShowAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kysymykset> kys=null;
		if (dao!=null) {
			kys=dao.readAllKysymykset();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("allkysymykset", kys);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminPage.jsp");
		rd.forward(request, response);
	}
}