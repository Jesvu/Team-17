<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.ShowKysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kysymykset</title>
<body>

		<c:forEach var="k" items="${sessionScope.allkysymykset}">
		<p><b>${k.kysymys_id}</b>
		<b>${k.kysymys}</b>
		</p>
		</c:forEach>
	

</body>
</html>
