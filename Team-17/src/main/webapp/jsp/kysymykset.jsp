<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css.css">
</head>
<title>Kysymykset</title>

 <body>

    <header><h1> <a href='/index.html'>Vaalikone</a></h1></header>
  <section>
  <div class="page" >
            <div class="sidebar">
          
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
		
		</tr>	
		<c:forEach var="k" items="${sessionScope.allkysymykset}">
			
		<tr>
				<td>${k.kysymys_id}</td>
				<td>${k.kysymys}</td>
			</tr>
		</c:forEach>
	</table>
		<div class="tiedot">
	  	<c:forEach var="k" items="${requestScope.allkysymykset}">
		<p><b>${k.kysymys_id}</b>
		<b>${k.kysymys}</b>
		</p>
		</c:forEach>
 
	  </div>
        </article>
      
   </div>
   </section>
 
   
   <footer>
        <h1>projekti</h1>
    </footer>

	

</body>
</html>