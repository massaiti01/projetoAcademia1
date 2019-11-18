<%-- 
    Document   : listar
    Created on : 13/11/2019, 10:07:27
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
         <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>FOTO</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="exercicio" items="${exercicios}">
                <tr>
                    <td>${exercicio.idExercicio}</td>
                    <td>${exercicio.nomeExercicio}</td>
                    <td><img src="MostrarFoto?idExercicio=${exercicio.idExercicio}" style="width:100px;height:100px;" alt="${exercicio.nomeExercicio}"> </td>
                    <td><a href="${pageContext.request.contextPath}/CarregarExercicio?idExercicio=${exercicio.idExercicio}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
