<%-- 
    Document   : listar
    Created on : 14/11/2019, 10:20:29
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo Musculares</title>
    </head>
  <body>
         <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="grupomuscular" items="${grupomusculares}">
                <tr>
                    <td>${grupomuscular.idGrupoMuscular}</td>
                    <td>${grupomuscular.nomeGrupoMuscular}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarGrupoMuscular?idGrupoMuscular=${grupomuscular.idGrupoMuscular}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
