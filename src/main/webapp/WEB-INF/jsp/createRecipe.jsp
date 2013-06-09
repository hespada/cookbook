<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Receita</title>
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
			<h2>Criar Receita</h2></br>
			<form method="post" action="/recipes">
				Titulo:</br>
				<input class="input-xxlarge" type="text" placeholder="Inserir titulo..." name="titulo" required autofocus/></br>
				Autor:</br>
				<input class="input-large" type="text" placeholder="Seu nome..." name="autor" required/></br>
				Problema:</br>
				<textarea rows="5" class="input-xxlarge" type="text" placeholder="Descrever problema..." name="problema" required/></textarea></br>
				Solucao:</br>
				<textarea rows="5" class="input-xxlarge" type="text" placeholder="Descrever solução..." name="solucao" required/></textarea></br>
				Etiquetas:</br>
				<input rows="5" class="input-xxlarge" type="text" placeholder="tag1, tag2, tag3..." name="tags" required/></br></br>
				<input class="btn btn-primary" type="submit" value="Criar"/></br></br>
				<a class="btn" href="/"><i class="icon-home"></i> Início</a>
			    <a class="btn" type="button" onclick="goBack()"><i class="icon-arrow-left"></i> Voltar</a>
				<a class="btn btn-small" href="/recipes">Lista de Receitas</a>
			</form>
		</div>
	</div>
</body>
</html>



