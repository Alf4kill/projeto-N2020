<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>

<head>

    <title>Bots - Editar</title>
    
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

        <!-- Call to Action Well -->
        <div class="row">
            <div class="col-lg-12">
                <div class="well">
					
					<h2>Bot</h2>
					
					<form:form modelAttribute="botModel" action="${contextPath}/bot" method="put">
					
						<spring:hasBindErrors name="botModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>
					
						<div class="form-group">
							<label class="control-label" for="nomeBot">Nome:</label>
							<form:input type="text" path="nomeBot" id="nomeBot" class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="nomeBot"/></font><br/>
                        </div>
						<div class="form-group">
							<label class="control-label" for="msgInicial">Mensagem inicial do bot</label>
							<form:textarea type="text" path="msgInicial" class="form-control" rows="4" cols="100" />
							<font color="red"><form:errors path="msgInicial"/></font><br/>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="msgFinal">Mensagem Final:</label>
							<form:textarea class="form-control" path="msgFinal" rows="4" cols="100" />
							<font color="red"><form:errors path="msgFinal"/></font><br/>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="inativo">Tempo de Inatividade:</label>
							<form:input type="number" step="0.01" id="inativo" path="inativo" class="form-control" />
							<font color="red"><form:errors path="inativo"/></font><br/>
						</div>
						
						<div class="form-group">
							<label class="control-label" for="msgPadrao">Mensagem padrão para fluxos não encontrados:</label>
							<form:textarea id="caracteristica" class="form-control" path="msgPadrao" rows="4" cols="100" />
							<font color="red"><form:errors path="msgPadrao"/></font><br/>
						</div>
						<hr>
						
						<a class="btn btn-default btn-lg" href="${contextPath}/bot">Cancelar</a>
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