package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import app.Info;

@WebServlet(
		name = "EditCandidate",
		urlPatterns = {"/editcandidate"}
		)

public class EditCandidate extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("ehdokas_id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Info info = dao.getCandidateInfo(id);
				
				session.setAttribute("info", info);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/EditCandidate.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/ehdokkaat");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
	
		
		
		Dao dao=new Dao();
		Info candidate = readCandidate(request);
		
		dao.updateCandidate(candidate);
		
		dao.close();
		
		
		response.sendRedirect("/ehdokkaat");
	}
	
	private Info readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Info candidate=new Info();
		candidate.setSukunimi(request.getParameter("SUKUNIMI"));
		candidate.setEtunimi(request.getParameter("ETUNIMI"));
		candidate.setPuolue(request.getParameter("PUOLUE"));
		candidate.setKotipaikkakunta(request.getParameter("KOTIPAIKKAKUNTA"));
		candidate.setIka(Integer.parseInt(request.getParameter("IKA")));
		candidate.setMiksi_eduskuntaan(request.getParameter("MIKSI_EDUSKUNTAAN"));
		candidate.setMita_asioita_haluat_edistaa(request.getParameter("MITA_ASIOITA_HALUAT_EDISTAA"));
		candidate.setAmmatti(request.getParameter("ammatti"));
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("EHDOKAS_ID")));
		return candidate;
	}
}
