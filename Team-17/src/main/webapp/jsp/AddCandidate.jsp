<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Candidate</title>

</head>
<body>
<h1>Add a Candidate</h1>

<form action='/addcandidate' method='post'>
Id: <input type='text' name='id' value=""placeholder="Add the id"><br> 
Surname: <input type='text' name='sukunimi' value=""placeholder="Add the surname"><br> 
Firstname: <input type='text' name='etunimi' value=""placeholder="Add the firstname"><br> 
Party: <input type='text' name='puolue' value=""placeholder="Add the party"><br> 
Domicile: <input type='text' name='kotipaikkakunta' value=""placeholder="Add the domicile"><br> 
Age: <input type='number' name='ika' value=""placeholder="Add the age"><br> 
Why to Parliament?: <input type='text' name='miksi' value="Add the reason"placeholder=""><br> 
Progression interests: <input type='text' name='edistaa' value=""placeholder="Add the response"><br> 
Occupation: <input type='text' name='ammatti' value=""placeholder="Add the occupation"><br> 
<br>
<input class='input-update' type='submit' name='ok' value='Submit'> 
</form>
<br>
<br>

<a href='/ehdokkaat'>Takaisin hallintasivulle</a>
<br><br>
</body>
</html>