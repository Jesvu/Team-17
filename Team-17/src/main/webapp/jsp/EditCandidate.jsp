<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="app.Info" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<style>
body{
background-color: #34c3eb;
align-items: center;
}
form{
font-size: x-large;
text-align: center;
}
h1{
text-align: center;
}
</style>

<h1>Edit The Candidate</h1>
<body>
	<form action='./editcandidate' method='post'>
		Sukunimi: <input type='text' name='SUKUNIMI' value='${sessionScope.info.sukunimi }'><br>
		Etunimi: <input type='text' name='ETUNIMI' value='${sessionScope.info.etunimi }'><br>
		Puolue:   <input type='text' name='PUOLUE' value='${sessionScope.info.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='KOTIPAIKKAKUNTA' value='${sessionScope.info.kotipaikkakunta }'><br>
		Ikä: <input type='number' name='IKA' value='${sessionScope.info.ika }'><br>
		Miksi eduskuntaan?: <input type='text' name='MIKSI_EDUSKUNTAAN' value='${sessionScope.info.miksi_eduskuntaan }'><br>
		Mitä asioita haluat edistaa?: <input type='text' name='MITA_ASIOITA_HALUAT_EDISTAA' value='${sessionScope.info.mita_asioita_haluat_edistaa }'><br>
		Ammatti:<input type='text' name='AMMATTI' value='${sessionScope.info.ammatti }'><br>
		<input type="hidden" name="EHDOKAS_ID" value="${sessionScope.info.ehdokas_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>
</body>
</html>