<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhe da Receita</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
<script>
function goBack()
{
	window.history.back()
}
</script>
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
			</br>
			<blockquote>
  			<p>Outros Detalhes da Receita:</p>
  			<small>Etiquetas: ${recipe.getTags()}</small>
 			<small>Autor: ${recipe.getAutor()}</small>
 			<small>Criado em: ${recipe.getData()}</small>
 			<small>Id: ${recipe.getExternalId()}</small>
			</br>
			<a class="btn btn-danger btn-mini" href="/recipes/${recipe.externalId}/delete">Apagar</a>
			</br></br>
			</blockquote>
			<a class="btn" href="/"><i class="icon-home"></i> Início</a>
			<a class="btn" type="button" onclick="goBack()"><i class="icon-arrow-left"></i> Voltar</a></br>
			<a class="btn btn-small" href="/recipes">Lista de Receitas</a>
			<a class="btn btn-small" href="/recipes/create">Criar nova Receita</a>
		</div>
		<p class="text-right">Higino Espada</br>Teresa Gonçalves</br>${currentTime}</p>
	</div>
</body>
</html>