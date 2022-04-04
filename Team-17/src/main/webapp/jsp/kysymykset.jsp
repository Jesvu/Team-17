<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.Info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css.css">
</head>
<title>Kysymykset</title>
 <body>
    <header><h1> <a href='/index.html'>Vaalikone</a></h1></header>
  <section>
  <div class="page" >
            <div class="sidebar">
              <div>
             <a href='/hello'>The servlet</a>
              </div>
              &nbsp;
              <div>
                 <a href='/ehdokkaat'>Ehdokkaat</a>
              </div> 
              &nbsp;
              <div>
               <a href='/showkysymykset'>Kysymykset</a>
            </div>
            </div>
            </div>
            
             <div class="article">
        <div>

          <article>
          <p>

	<table>
		<tr>
			<th>Id</th>
		</tr>	
		<c:forEach var="k" items="${sessionScope.allkysymykset}">
		<tr>
				<td>${k.kysymys_id}</td>
				<td>${k.kysymys}</td>
			</tr>
		</c:forEach>
	</table>
	  
        </article>
      
   </div>
   </section>
   
   <footer>
        <h1>projekti</h1>
    </footer>
  </body>
	

</body>
</html>
	

</body>
</html>
