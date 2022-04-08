package servlet;

import java.io.IOException;


import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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


	
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao = new Dao();

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


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/jsp/data.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
	//	int id = Integer.parseInt(request.getParameter("id"));
		String sukunimi = request.getParameter("sukunimi");
		String etunimi = request.getParameter("etunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		int ika = Integer.parseInt(request.getParameter("ika"));
		String miksi = request.getParameter("miksieduskuntaan");
		String mita = request.getParameter("mitahaluat");
		String ammatti = request.getParameter("ammatti");

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("vaalikones");
			em = emf.createEntityManager();
			em.getTransaction().begin();

			Info eh = new Info();
			eh.setSukunimi(sukunimi);
			eh.setEtunimi(etunimi);
			eh.setPuolue(puolue);
			eh.setKotipaikkakunta(kotipaikkakunta);
			eh.setIka(ika);
			eh.setMiksi_eduskuntaan(miksi);
			eh.setMita_asioita_haluat_edistaa(mita);
			eh.setAmmatti(ammatti);
			em.persist(eh);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			response.getWriter().println("Error!");
		}

		response.sendRedirect("jsp/AddCandidate.jsp");
	doGet(request, response);
	}

	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	


}

@WebServlet(
	    name = "AddCandidate",
	    urlPatterns = {"/addC"}
	)
public class AddCandidate extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect("adminPage.html");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		
	}

	


}



	private void printCandidateList(PrintWriter out, ArrayList<Info> list) {
		out.println("<ul>");
		for (Info g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}

