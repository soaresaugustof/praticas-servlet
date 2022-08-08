<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ page import="java.util.List, br.com.gerenciador.vo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas</title>
</head>
<body>	

	Usuario logado: ${usuarioLogado.login} <br/>

	<c:if test="${not empty empresa}">
		Empresa cadastrada com sucesso!
	</c:if>
	
	Lista de Empresas: <br/>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador-curso-alura/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador-curso-alura/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>