<%-- 
    Document   : salvar
    Created on : 14/11/2019, 10:20:21
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo Muscular</title>
    </head>
    <body>
    <c:choose> 
        <c:when test="${!empty pessoa}">
         <h1> Grupo Muscular</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarGrupoMuscular">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idGrupoMuscular" value="${grupomuscular.idGrupoMuscular}">
            <input type="hidden" name="idAcademia" value="${academia}">
            <label for="nomeGrupoMuscular">Nome:</label>
            <input type="text" name="nomeGrupoMuscular" id="nomeGrupoMuscular" value="${grupomuscular.nomeGrupoMuscular}"><br />
            <input type="submit" value="Salvar Grupo Muscular">
        </form>
            </c:when>
<c:otherwise>
    <jsp:forward page="../../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
