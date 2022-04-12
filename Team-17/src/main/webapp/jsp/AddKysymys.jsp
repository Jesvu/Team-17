<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>       
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="app.AddKysymys"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css.css">
<title>Vaalikone</title>

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
<h2>Lisää Kysymys</h2>

<form action='/addkysymys' method='post'>
Kysymys id: <input type='text' name='kysymys_id' value=""placeholder="Lisää id"><br> 
Kysymys<br>
<textarea name="kysymys" rows="5" cols="80">Kirjoita tähän</textarea>
<br><br>
<input class='input-paivita' type='submit' name='ok' value='add'> 
</form>
<br>
<br>

<a href='/showkysymykset'>Takaisin hallintasivulle</a>
</div></article>

		</div>
	</section>

	<footer>
		<h1>Jussi Rinta-Kiikka, Jesse Vuorela, Tanika Syrjälä</h1>
	</footer>
</body>

<br><br>
</body>
</html>