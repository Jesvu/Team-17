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

public class AddCandidate {

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
			response.sendRedirect("/jsp/data.jsp");
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			int id =Integer.parseInt(request.getParameter("ehdokas_id"));
			String sukunimi =request.getParameter("sukunimi");
			String etunimi =request.getParameter("etunimi");
			String puolue =request.getParameter("puolue");
			String kotipaikkakunta =request.getParameter("kotipaikkakunta");
			int ika = Integer.parseInt(request.getParameter("ika"));
			String miksi_eduskuntaan =request.getParameter("miksi_eduskuntaan");
			String mita_asioita_haluat_edistaa =request.getParameter("mita_asioita_haluat_edistaa");
			String ammatti =request.getParameter("ammatti");
			
			Info i =new Info(id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
			
			ArrayList<Info> can=null;
			if (dao!=null) {
				can=dao.addCandidate(i);
			}
			
			request.setAttribute("allcandidates", can);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/AddCandidate.jsp");
			rd.forward(request, response);
		}
	}
}