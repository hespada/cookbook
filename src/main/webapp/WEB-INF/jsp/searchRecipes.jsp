<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function goBack()
  {
  window.history.back()
  }
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado da Pesquisa</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>

<body>
	<div class="container text-left">
		<div class="hero-unit">
			<h2>Resultado da Pesquisa</h2>	
			<form class="form-search text-right" method="post" action="/search">
			<div class="input-append">
  			<input type="text" class="input-medium search-query" placeholder="Pesquisar Receita..." name="pesquisa" autofocus>
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
		<c:forEach var="recipe" items='${recipes}'> 
          <tr>  
            <td><li><a href="/recipes/${recipe.getExternalId()}">${recipe.titulo}</a></td>  
            <td class="span3">
            <a class="btn btn-danger btn-small" href="/recipes/${recipe.externalId}/delete"><i class="icon-trash"></i> Apagar</a>
            <a class="btn btn-danger btn-small" href="/recipes/${recipe.externalId}/update"><i class="icon-pencil"></i> Editar</a></li>
            </td>  
          </tr>  
          </c:forEach>
		  </ul>
        </tbody> 
      </table>  
      <em>${message}</em>
			</br></br>
			<a class="btn" type="button" onclick="goBack()"><i class="icon-arrow-left"></i> Voltar</a></br>
			<a class="btn btn-small" href="/recipes/create">Criar nova Receita</a>
			<a class="btn btn-small" href="/recipes">Lista de Receitas</a>
		</div>
		<p class="text-right">Higino Espada</br>Teresa Gonçalves</br>${currentTime}</p>
	</div>
</body>
</html>