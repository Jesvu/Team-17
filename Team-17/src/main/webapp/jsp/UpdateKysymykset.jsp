<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@ page import="data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css">
<title>Muokkaa</title>
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
					<a href='/ehdokkaat'>Ehdokkaat</a>
				</div>
				&nbsp;
				<div>
					<a href='/showkysymykset'>Kysymykset</a>
				</div>
			</div>
		</div>
<div>

			<article>
	<div class="tiedot">

<h2>Muokkaa kysymystš</h2>
<form action='./update' method='post'>
	Kysymys: <input type='text' name='kysymys' value='${requestScope.allkysymykset.kysymys}'><br>
	<input type="hidden" name="kysymys_id" value="${requestScope.allkysymykset.kysymys_id }"> <br>
	<input type='submit' name='ok' value='Edit'> 
</form>
<br><br>
<a href='/showadmin'>Takaisin hallintasivulle</a>
</div></article>

		</div>
	</section>

	<footer>
		<h1>projekti</h1>
	</footer>
</body>



</body>
</html>