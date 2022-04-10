<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.Info"%>
<%@ page import="data.Kysymykset"%>
<%@ page import="data.test" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css.css">
<title>Admin Page</title>
</head>
<body>
<header>
	<h1>
		<a href='/index.html'>Vaalikone</a>
	</h1>
</header>	

<section>
	<article>
		<div class="tiedot">			
			<c:forEach var="info" items="${sessionScope.allinfos }">
				<tr>
					<td>${info.ehdokas_id }</td>
					<td>${info.sukunimi }</td>
					<td>${info.etunimi }</td>
					<td>${info.puolue }</td>
				 <td>
	 				<a href="/editcandidate?ehdokas_id=${info.ehdokas_id }"> Muokkaa</a> <br>
				 </td>
				 <td>
	 				<a href="/removecandidate?ehdokas_id=${info.ehdokas_id }">Poista</a>
				</tr>
			</c:forEach>
				<br>
					<a href="/jsp/addcandidate.jsp">Add a candidate</a>
				<br>
        </div>
	</article>

	<div>
	<article>
		<div class="article">	
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
			<br>
				<a href='/delete?id=${k.kysymys_id}'>Poista</a> <a href='/update?id=${k.kysymys_id}'>Muokkaa</a> 
			<br>
			</c:forEach>
			<br>
				<a href="/jsp/addkysymys.jsp">Lisää kysymys</a>
			<br>
 		</div>
	  </div>
	</article>    
</div>

	<article>
		<h2>Add user</h2>
		<form action="/adding" method= "post">
			<input type="text" name="username" value="">
			<input type="password" name= "password" value="">
			<input type="submit" name="send" value= "Add">
		</form>

		<h1>Logout</h1>
		<form action="/logout" method="post">
			<input type="submit" name="send" value="Logout"/>
		</form>
	</article>
</section>

	<footer>
		<h1>projekti</h1>
	</footer>
</body>
</html>