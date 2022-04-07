package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.Info;
import dao.Dao;

@WebServlet(
		name = "UpdateCandidate",
		urlPatterns = "/updatecan"
)

public class UpdateCandidate extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("ehdokas_id");
		
		if ( idValue != null ) {
			try {
				int ehdokas_id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Info candidate = dao.getCandidateInfo(ehdokas_id);
				
				session.setAttribute("candidate", candidate);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/EditCandidates.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showdata");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
	
		
		// Create connection
		Dao dao=new Dao();
		Info candidate = readCandidate(request);
		
		dao.updateCandidate(candidate);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
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
		candidate.setAmmatti(request.getParameter("AMMATTI"));
		candidate.setId(Integer.parseInt(request.getParameter("EHDOKAS_ID")));
		return candidate;
	}
}
