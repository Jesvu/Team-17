<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="data.Candidates" %>
<!DOCTYPE html>
<html>
<head>
<title>Candidates</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
</tr>
<c:forEach var="candidates" items="${requestScope.allcandidates }">
	<tr>
		<td>${candidates.ehdokas_id }</td>
		<td>${candidates.sukunimi }</td>
		<td>${candidates.etunimi }</td>
		<td>${candidates.puolue }</td>
	 <td>
	 <a href="/updatecan?ehdokas_id=${candidates.ehdokas_id }"> Muokkaa</a>
	 </td>
</c:forEach>

</table>

</body>
</html>