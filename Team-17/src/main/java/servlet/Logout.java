package servlet;

import java.io.IOException; 
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

@WebServlet(
		name = "logout",
		urlPatterns = {"/logout"}
)

public class Logout extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                throws ServletException, IOException {  
        response.setContentType("text/html");
        request.getRequestDispatcher("/showadmin").include(request, response);
        
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                throws IOException {
              
        HttpSession session=request.getSession();  
        session.invalidate();  

        response.sendRedirect("index.html"); 
    }  
}  