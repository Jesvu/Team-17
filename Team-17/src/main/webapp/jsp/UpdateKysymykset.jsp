<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa</title>
</head>
<body>


<h2>Muokkaa kysymystä</h2>
<form action='./update' method='post'>
	Kysymys id: <input type='text' name='kysymys_id' value='${requestScope.k.kysymys_id}' readonly><br> 
	Kysymys: <input type='text' name='k.kysymys' value='${requestScope.k.kysymys}'><br>
	<input type="hidden" name="id" value="${requestScope.k.kysymys_id }">
	<input type='submit' name='ok' value='Muokkaa'> 
</form>
<a href='/showkysymykset'>Takaisin hallintasivulle</a>


</body>
</html>