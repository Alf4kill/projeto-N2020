<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

    <title>Produtos - Listagem</title>
    
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
    
    <link href="${contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/css/small-business.css" rel="stylesheet">

</head>

<body>
    
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                   <li>
                        <a href="${contextPath}/bot">Bots</a>
                    </li>
                    <li>
                    	<a href="${contextPath}/segmento">Segmentos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
				
				<h1>Segmento</h1>
				
				<p class="toolbar">
				
					<a class="create btn btn-default" href="${contextPath}/produto/form?page=segmento-novo">Novo Segmento</a>
	
					<span class="alert"></span>
				</p>
				
				<c:if test="${not empty messages}">
					<h3 class="alert alert-warning">${messages}</h3>
				</c:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th data-field="nome">Nome Segmento</th>
							<th data-field="nomeBot">Bot</th>
							<th class="actions" width="220">Ações</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${segmentos}" var="segmento">
						<tr>
							<td>${segmento.nomeSegmento}</td>
							<td>${segmento.bot.nomeBot}</td>
							<td class="actions">
							
								<form:form action="${contextPath}/segmento/${segmento.idSegmento}" method="delete">
								
									<a class="btn btn-success btn-xs" href="${contextPath}/produto/${segmento.idSegmento}">Detalhes</a>
									<a class="btn btn-warning btn-xs" href="${contextPath}/produto/form?page=segmento-editar&id=${segmento.idSegmento}">Editar</a>
									<input type="submit" value="Excluir" class="btn btn-danger btn-xs">
								</form:form>
								
							</td>
						</tr>
					</c:forEach>
                    </tbody>
				</table>
            </div>
        </div>
		<hr>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/js/bootstrap.min.js"></script>

</body>
</html>