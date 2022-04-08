package app;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
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
	    name = "add",
	    urlPatterns = {"/add"}
	)
	public class add extends HttpServlet {
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	/*
	 * If the request type is POST, the request is transferred to the method doGet
	 */
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

			/*
			 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
			 */
			RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
			rd.include(request,  response);;
			
			Info info=readInfo(request);
			Dao dao=new Dao();
			ArrayList<Info> list=dao.readAllInfo();
			printInfoList(out, list);
			dao.close();
			

			/*
			 * With a RequestDispatcher object is the htmlend.html file included to this servlet
			 */
			rd=request.getRequestDispatcher("htmlend.html");
			rd.include(request,  response);;
	  }
	  private Info readInfo(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Info info=new Info();
			info.setSukunimi(request.getParameter("sukunimi"));
			info.setEtunimi(request.getParameter("etunimi"));
			info.setPuolue(request.getParameter("puolue"));
			info.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
			info.setIka(Integer.parseInt(request.getParameter("ika")));
			info.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
			info.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
			info.setAmmatti(request.getParameter("ammatti"));
			return info;
		}
	  private void printInfoList(PrintWriter out, ArrayList<Info> list) {
			out.println("<ul>");
			for (Info g:list) {
				out.println("<li>"+g);
			}
			out.println("</ul>");
		}
	
	}


