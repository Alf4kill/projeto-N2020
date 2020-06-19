<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

    <title>Segmento - Cadastro</title>
    
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
            <div class="col-lg-12">
                <div class="well">
					
					<h2>Segmento</h2>
					
					<form:form modelAttribute="segmentoModel" action="${contextPath}/segmento" method="post">
					
						<spring:hasBindErrors name="segmentoModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>
					
						<div class="form-group">
							<label class="control-label" for="nomeSegmento">Nome:</label>
							<form:input type="text" path="nomeSegmento" id="nomeSegmento" class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="nomeSegmento"/></font><br/>
                        </div>
                        
                        <div class="form-group">
                        	<label class="control-label" for="bot">Bot:</label>
                        
	                        <form:select path="bot.idBot">
	                        	<form:options items="${bots}" itemValue="idBot" itemLabel="nomeBot" />
	                        </form:select>
						</div>
						<hr>
						
						<a class="btn btn-default btn-lg" href="${contextPath}/segmento">Cancelar</a>
						<button type="submit" class="btn btn-primary btn-lg">Gravar</button>
                            
                        <br>
                        <br>
					</form:form>
					
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/js/bootstrap.min.js"></script>

</body>
</html>