<%-- 
    Document   : listar
    Created on : 13/11/2019, 10:07:32
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Aparelhos</title>
    </head>
   <body>
         <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="aparelho" items="${aparelhos}">
                <tr>
                    <td>${aparelho.idAparelho}</td>
                    <td>${aparelho.nomeAparelho}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarAparelho?idAparelho=${aparelho.idAparelho}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
