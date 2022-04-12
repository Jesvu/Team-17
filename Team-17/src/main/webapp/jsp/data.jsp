<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="app.Info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css.css">
<title>Ehdokkaat</title>

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
				<h2>Login</h2>
					<form action="/login" method="post">  
						Name:<input type="text" name="username"/><br/><br/>  
						Password:<input type="password" name="password"/><br/><br/>  
						<input type="submit" name='send' value="Login"/>  
					</form>  
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
			
				<div class="dropdown">
					<button onclick="myFunction()" class="dropbtn">Valitse puolue</button>
					<div id="myDropdown" class="dropdown-content">
        
        
						    <a href="/showdata?puolue=Suomen Kristillisdemokraatit (KD))">Suomen Kristillisdemokraatit (KD)</a> 
						    <a href="/showdata?puolue=Suomen_ruotsalainen_kansanpuolue">Suomen ruotsalainen kansanpuolue</a> 
							<a href="/showdata?puolue=Vasemmistoliitto">Vasemmistoliitto</a> 
							<a href="/showdata?puolue=Vihreä_liitto">Vihreä liitto</a> 
							<a href="/showdata?puolue=Suomen_Keskusta">Suomen Keskusta</a> 
							<a href="/showdata?puolue=Kansallinen_Kokoomus">Kansallinen Kokoomus</a> 
							<a href="/showdata?puolue=Suomen_Sosialidemokraattinen_Puolue">Suomen Sosialidemokraattinen Puolue</a>
							<a href="/showdata?puolue=Itsenäisyyspuolue">Itsenäisyyspuolue</a>
						    <a href="/showdata?puolue=Suomen_Kommunistinen_Puolue">Suomen Kommunistinen Puolue</a>
					</div>
				</div>

				<script>
					function myFunction() {
						document.getElementById("myDropdown").classList
								.toggle("show");
					}

					function filterFunction() {
						var input, filter, ul, li, a, i;
						input = document.getElementById("myInput");
						filter = input.value.toUpperCase();
						div = document.getElementById("myDropdown");
						a = div.getElementsByTagName("a");
						for (i = 0; i < a.length; i++) {
							txtValue = a[i].textContent || a[i].innerText;
							if (txtValue.toUpperCase().indexOf(filter) > -1) {
								a[i].style.display = "";
							} else {
								a[i].style.display = "none";
							}
						}
					}
	
				    </script>

				<p>
					<c:forEach var="info" items="${sessionScope.allinfos}">


						<div class="tiedot">
							<h2>
								<p>
									<b>${info.ehdokas_id}.</b> ${info.etunimi} ${info.sukunimi}
								</p>
							</h2>

							<b>Puolue</b>
							<p>${info.puolue}</p>

							<b>Paikkakunta</b>
							<p>${info.kotipaikkakunta}</p>

							<b>Ikä</b>
							<p>${info.ika}</p>

							<b>Miksi eduskuntaan?</b>
							<p>${info.miksi_eduskuntaan}</p>

							<b>Mitä asioita haluat edistää?</b>
							<p>${info.mita_asioita_haluat_edistaa}</p>

							<b>Ammatti</b>
							<p>${info.ammatti}</p>
						</div>
					</c:forEach>
			</article>
		</div>
	</section>
	<footer>
		<h1>Jussi Rinta-Kiikka, Jesse Vuorela, Tanika Syrjälä</h1>
	</footer>
</body>
</html>