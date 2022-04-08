package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import app.Info;

@WebServlet(
		name = "AddCandidate",
		urlPatterns = {"/addcandidate"}
		)

public class AddCandidate extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/data.jsp");
		rd.include(request,  response);;
		
		Info info = readCandidate(request);
		
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.addCandidate(info);
		ArrayList<Info> list=dao.readAllCandidates();
		
		// print output and close connection
		printCandidateList(out, list);
		dao.close();

	}


	private Info readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Info candidate=new Info();
		candidate.setSukunimi(request.getParameter("sukunimi"));
		candidate.setEtunimi(request.getParameter("etunimi"));
		candidate.setPuolue(request.getParameter("puolue"));
		candidate.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		candidate.setIka(Integer.parseInt(request.getParameter("ika")));
		candidate.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		candidate.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidate.setAmmatti(request.getParameter("ammatti"));
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidate;
	}
	
	private void printCandidateList(PrintWriter out, ArrayList<Info> list) {
		out.println("<ul>");
		for (Info g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}