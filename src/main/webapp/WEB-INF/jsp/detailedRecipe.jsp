<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhe da Receita</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
	<div class="container text-left">
		<div class="hero-unit">
			<h2>Detalhe da Receita</h2></br>
			<dl class="dl-horizontal">
				<dt>Título:</dt>
 				<dd>${recipe.getTitulo()}</dd>
 				<dt>Problema:</dt>
 				<dd>${recipe.getProblema()}</dd>
 				<dt>Solucao:</dt>
 				<dd>${recipe.getSolucao()}</dd>				
			</dl>
			</br></br>
			<blockquote>
  			<p>Outros Detalhes da Receita:</p>
 			<small>Id: ${recipe.getId()}</small>
 			<small>Autor: ${recipe.getAutor()}</small>
 			<small>Data: ${recipe.getData()}</small>
			</blockquote>
			</br></br>
			<a class="btn btn-primary btn-small" href="/recipes">Voltar</a>
			<a class="btn btn-primary" href="/">Início</a>
		</div>
	</div>
</body>
</html>