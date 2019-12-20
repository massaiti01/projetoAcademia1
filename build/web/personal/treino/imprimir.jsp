<%-- 
    Document   : Imprimir
    Created on : 17/12/2019, 13:44:30
    Author     : Eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <script>
            function imprimir() {
                var printContents = document.getElementById('imprimir').innerHTML;
                var originalContents = document.body.innerHTML;

                document.body.innerHTML = printContents;

                window.print();

                document.body.innerHTML = originalContents;
            }
        </script>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Imprimir Treino</title>
        </head>
        <body>
            <div class="col-sm-12">
                <div id="imprimir">
                    <h1 class="text-center">Treinos</h1>
                <c:forEach var="treino" items="${treinos}">
                    <div class="col-md-12">
                        <h2 class="text-center">${treino.nomeTreino}</h2>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th style="width:85%"> Descrição </th>
                                    <th style="width:5%"> Series </th>
                                    <th style="width:5%"> Repeticoes </th>
                                    <th style="width:5%"> Carga </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="etreino" items="${exerciciotreinos}">
                                    <c:if test="${etreino.treino.idTreino == treino.idTreino}">
                                        <tr>
                                            <td>${etreino.descricaoExercicioTreino}</td>
                                            <td>${etreino.seriesTreino}</td>
                                            <td>${etreino.repeticoesTreino}</td>
                                            <td>${etreino.cargaTreino}KG</td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:forEach>
            </div>

            <input class="btn btn-success col-md-12" type="button" value="IMPRIMIR TREINO" onClick="imprimir()"/>

        </div>

    </body>
</html>
<jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>
