<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Receitas</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
	<div class="container text-left">
		<div class="hero-unit">
			<h2>Lista de Receitas</h2></br>
			<ul>
				<c:forEach var="recipe" items='${recipes}'>
				<li><a href="/recipes/${recipe.getId()}">${recipe.titulo}</a></li>
				</c:forEach>
			</ul>
			</br></br>
			<a class="btn btn-primary btn-small" href="/">Início</a>
		</div>
	</div>
</body>
</html>