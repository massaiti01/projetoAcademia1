<%-- 
    Document   : Imprimir
    Created on : 17/12/2019, 13:44:30
    Author     : Eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Imprimir Treino</title>
        </head>
        <body>
            <div id="imprimir" class="col-md-12">
                <h1 class="text-center">Treinos</h1>
            <c:forEach var="treino" items="${treinos}">
                <div class="col-md-12">
                    <h2 class="text-center">${treino.nomeTreino}</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th> Descrição </th>
                                <th> Repeticoes </th>
                                <th> Series </th>
                                <th> Carga </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="etreino" items="${exerciciotreinos}">
                                <c:if test="${etreino.treino.idTreino == treino.idTreino}">
                                    <tr>
                                        <td>${etreino.descricaoExercicioTreino}</td>
                                        <td>${etreino.repeticoesTreino}</td>
                                        <td>${etreino.seriesTreino}</td>
                                        <td>${etreino.cargaTreino}KG</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:forEach>

        </div>

    </body>
</html>
<jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>
