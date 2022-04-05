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

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/showupdate")
public class ShowUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
	
	public void init() {
		dao = new Dao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kysymys_id=request.getParameter("kysymys_id");
		Kysymykset k=null;
		if (dao!=null) {
			k=dao.readKysymykset(kysymys_id);
		}
		request.setAttribute("allkysymykset", k);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/UpdateKysymykset.jsp");
		rd.forward(request, response);
	}
}