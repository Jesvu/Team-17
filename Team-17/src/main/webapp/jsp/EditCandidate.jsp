<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.Info" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<style>
body{
background-color: #166a8b;
align-items: center;
}
form{
font-size: x-large;
text-align: center;
}
</style>
<body>

	<form action='./editcandidate' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.info.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.info.etunimi }'><br>
		Puolue:   <input type='text' name='puolue' value='${sessionScope.info.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${sessionScope.info.kotipaikkakunta }'><br>
		Ikä: <input type='number' name='ika' value='${sessionScope.info.ika }'><br>
		Miksi eduskuntaan?: <input type='text' name='miksi_eduskuntaan' value='${sessionScope.info.miksi_eduskuntaan }'><br>
		Mitä asioita haluat edistaa?: <input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.info.mita_asioita_haluat_edistaa }'><br>
		Ammatti:<input type='text' name='ammatti' value='${sessionScope.info.ammatti }'><br>
		<input type="hidden" name="ehdokas_id" value="${sessionScope.info.ehdokas_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>