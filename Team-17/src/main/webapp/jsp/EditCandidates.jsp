<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Candidates" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action='./updatecan' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${requestScope.candidates.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${requestScope.candidates.etunimi }'><br>
		Puolue:   <input type='text' name='puolue' value='${requestScope.candidates.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${requestScope.candidates.kotipaikkakunta }'><br>
		Ikä: <input type='text' name='ika' value='${requestScope.candidates.ika }'><br>
		Miksi eduskuntaan?: <input type='text' name='miksi_eduskuntaan' value='${requestScope.candidates.miksi_eduskuntaan }'><br>
		Mitä asioita haluat edistää?: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.candidates.mita_asioita_haluat_edistaa }'><br>
		Ammatti:<input type='text' name='ammatti' value='${requestScope.candidates.ammatti }'><br>
		<input type="hidden" name="id" value="${requestScope.candidates.ehdokas_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>
</body>
</html>