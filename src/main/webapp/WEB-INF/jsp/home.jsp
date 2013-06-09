<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookbook</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
	<div class="container text-center">
		<div class="hero-unit">
			<img src="/resources/cookbook.png" height="80" width="80" class="img-rounded"/>
			<h1>Cookbook</h1></br>
			<p>
			<a class="btn btn-primary btn-large" href="/recipes">Listar Receita</a>
			<a class="btn btn-primary btn-large" href="/recipes/create">Criar Receita</a>
			</p>
		</div>
		<p class="text-right">Higino Espada</br>Teresa Gonçalves</br>${currentTime}</p>
	</div>
	<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</html>