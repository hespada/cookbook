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
			<h2>Lista de Receitas</h2>	
			<form class="form-search text-right">
			<div class="input-append">
  			<input type="text" class="input-medium search-query" placeholder="Pesquisar Receita..."  name="pesquisa" autofocus>
 			<button type="submit" class="btn btn-info"><i class="icon-search"></i> Procurar</button>
			</form>				
			</div>		
			<table class="table">  
        <thead>  
          <tr>  
            <th>Receitas</th>  
            <th>Acções</th>  
          </tr>  
        </thead>  
        <tbody>  
        <ul> 
		<c:forEach var="recipe" items='${sortRecipes}'> 
          <tr>  
            <td><li><a href="/recipes/${recipe.getExternalId()}">${recipe.titulo}</a></td>  
            <td class="span3">
            <a class="btn btn-danger btn-small" href="/recipes/${recipe.externalId}/delete"><i class="icon-trash"></i> Apagar</a></li>
            </td>  
          </tr>  
          </c:forEach>
		  </ul>
        </tbody> 
      </table>  
			</br></br>
			<a class="btn" href="/"><i class="icon-home"></i> Início</a>
			<a class="btn btn-small" href="/recipes/create">Criar nova Receita</a>
		</div>
		<p class="text-right">Higino Espada</br>Teresa Gonçalves</br>${currentTime}</p>
	</div>
</body>
</html>