package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import app.Info;

@WebServlet("/addcandidate")
public class AddCandidate extends HttpServlet {
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


