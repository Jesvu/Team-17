<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@ page import="data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa</title>
</head>
<body>


<h2>Muokkaa kysymystä</h2>
<form action='./update' method='post'>
	Kysymys: <input type='text' name='kysymys' value='${requestScope.allkysymykset.kysymys}'><br>
	<input type="hidden" name="kysymys_id" value="${requestScope.allkysymykset.kysymys_id }">
	<input type='submit' name='ok' value='Edit'> 
</form>
<a href='/showkysymykset'>Takaisin hallintasivulle</a>


</body>
</html>