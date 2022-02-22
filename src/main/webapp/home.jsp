<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/application.js"></script>
<title>Onlinestore</title>
</head>
<body>

	<h1>Onlinestore, votre boutique mulltimédia en ligne</h1>

	<c:if test="${not empty pseudo }">

		<p>
			Bonjour ${pseudo}<a href="logout"> (Déconnexion)</a>
		</p>
	</c:if>

	<a href="catalogue">Afficher le catalogue</a>
	<br />

	<a href="add-work-form2.html">Ajouter une oeuvre au catalogue</a>
	<br />


</body>
</html>