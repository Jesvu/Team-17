<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.Info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kysymykset</title>
<body>

	<table border=1 width=50% height=50%>
		<tr>
			<th>Id</th>
		</tr>	
		<c:forEach var="k" items="${sessionScope.allkysymykset}">
		<tr>
				<td>${k.kysymys_id}</td>
				<td>${k.kysymys}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
