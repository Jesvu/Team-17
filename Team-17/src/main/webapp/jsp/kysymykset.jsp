<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css.css">
</head>
<title>Kysymykset</title>
 <body>


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
   

</body>
	
</html>