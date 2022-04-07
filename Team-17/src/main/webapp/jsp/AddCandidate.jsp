<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>       
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>

</head>
<body>
<h1>Add a Candidate</h1>

<form action='/addcandidate' method='post'>
Candidate id: <input type='text' name='id' value=""placeholder="Lisää id"><br> 
Candidate<br>
<textarea name="Candidate" rows="5" cols="80">Kirjoita tähän</textarea>
<br><br>
<input class='input-paivita' type='submit' name='ok' value='add'> 
</form>
<br>
<br>

<a href='/ehdokkaat'>Takaisin hallintasivulle</a>
<br><br>
</body>
</html>