<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Receita</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>

<body>
	<div class="container text-left">
		<div class="hero-unit">
			<h2>Alterar Receita</h2>
			<form method="post" action="/recipes/update">
				<input class="input-xxlarge" type="text" style="visibility: hidden;" readonly name="id" required autofocus value="${recipe.getExternalId()}" /><br>
				Titulo:</br>
				<input class="input-xxlarge" type="text" name="titulo" required autofocus value="${recipe.getTitulo()}" /></br>
				Autor:</br>
				<input class="input-large" type="text" name="autor" required value="${recipe.getAutor()}"/></br>
				Problema:</br>
				<textarea rows="5" class="input-xxlarge" type="text" name="problema" required"/>${recipe.getProblema()}</textarea></br>
				Solucao:</br>
				<textarea rows="5" class="input-xxlarge" type="text" name="solucao" required/>${recipe.getSolucao()}</textarea></br>
				Etiquetas:</br>
				<input rows="5" class="input-xxlarge" type="text" name="tags" required value="${recipe.getTags()}"/></br></br>
				<input class="btn btn-primary" type="submit" value="Actualizar"/>
				<a class="btn btn-small" href="/">Início</a>
				<a class="btn btn-small" href="/recipes">Lista de Receitas</a>
			</form>
		</div>
	</div>
</body>
</html>