<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.Info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css">
<title>Hello App Engine</title>

</head>

<body>
	<header>
		<h1>
			<a href='/index.html'>Vaalikone</a>
		</h1>
	</header>
	<section>
		<div class="page">
			<div class="sidebar">
				<div>
					<a href='/hello'>The servlet</a>
				</div>
				&nbsp;
				<div>
					<a href='/ehdokkaat'>Ehdokkaat</a>
				</div>
				&nbsp;
				<div>
					<a href='/showkysymykset'>Kysymykset</a>
				</div>
			</div>
		</div>


		<div class="article">
			<div>

				<article>
					<p>
					<table border=1>
						<tr>
							<th>Id</th>
							<th>Sukunimi</th>
							<th>Etunimi</th>
							<th>Puolue</th>
							<th>Kotipaikkakunta</th>
							<th>Ikä</th>
							<th>Miksi eduskuntaan</th>
							<th>Mitä asioita haluat edistää</th>
							<th>Ammatti</th>
						</tr>
						<c:forEach var="info" items="${sessionScope.allinfos}">
							<tr>
								<td>${info.id}</td>
								<td>${info.sukunimi}</td>
								<td>${info.etunimi}</td>
								<td>${info.puolue}</td>
								<td>${info.kotipaikkakunta}</td>
								<td>${info.ika}</td>
								<td>${info.miksi_eduskuntaan}</td>
								<td>${info.mita_asioita_haluat_edistaa}</td>
								<td>${info.ammatti}</td>
							</tr>
						</c:forEach>
					</table>
				</article>

			</div>
	</section>

	<footer>
		<h1>projekti</h1>
	</footer>
</body>


</body>
</html>
