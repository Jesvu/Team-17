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

@WebServlet("/addcandidate")
public class AddCandidate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao = new Dao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/jsp/data.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ehdokas_id = Integer.parseInt(request.getParameter("ehdokas_id"));
		String sukunimi = request.getParameter("sukunimi");
		String etunimi = request.getParameter("etunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		int ika = Integer.parseInt(request.getParameter("ika"));
		String miksi = request.getParameter("miksi_eduskuntaan");
		String mita = request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti = request.getParameter("ammatti");


			Info i = new Info(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta,
					ika, miksi, mita, ammatti);
			
			ArrayList<Info> info=null;
			if (dao!=null) {
				info = dao.addCandidate(i);
			}
			
			request.setAttribute("allcandidates", info);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/data.jsp");
			rd.forward(request, response);
		
	}
	
}

