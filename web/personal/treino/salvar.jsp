<%-- 
    Document   : salvar
    Created on : 12/11/2019, 13:59:36
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Treino</title>
    </head>
    <jsp:include page="../../dashboard/csss.jsp"></jsp:include>
        <script>

            function MostrarDiv(nt, it) {
                document.getElementById('divCadastrarTreino').style.display = 'none';
                document.getElementById('divNovoTreino').style.display = 'block';
                document.getElementById("nomeTreino2").value = nt;
                document.getElementById("idTreino2").value = it;

            }
        </script>
        <body>
            <c:forEach var="treino" items="${treinos}">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome Treino</th>
                    <th>Data Treino</th>
                    <th>Personal</th>
                    <th row="2">Opções</th>
                </tr>
                <tr>
                    <td>${treino.idTreino}</td>
                    <td>${treino.nomeTreino}</td>
                    <td>${treino.dataTreino}</td>
                    <td>${treino.personal.nomePessoa}</td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirTreino?idTreino=${treino.idTreino}&&idAluno=${idAluno}">Apagar Treino</a></td>
                    <td><a href="${pageContext.request.contextPath}/DadosExercicioTreino?idTreino=${treino.idTreino}&&idAluno=${idAluno}">Adicionar Exercicio</a></td>
                                               </table>
               <div class="col-md-12">
                <table class="table divsumir">
                    <tr>
                        <th>ID</th>
                        <th>Nome Treino</th>
                        <th>Descricao</th>
                        <th>Grupo Muscular</th>
                        <th>Exercicio</th>
                        <th>Aparelho</th>
                        <th row="3">series,carga,repeticoes</th>
                    </tr>
                    <c:forEach var="exerciciot" items="${exerciciotreinos}">
                        <c:if test="${exerciciot.treino.idTreino == treino.idTreino}">
                            <tr>
                                <td>${exerciciot.idExercicioTreino}</td>
                                <td>${exerciciot.treino.nomeTreino}</td>
                                <td>${exerciciot.descricaoExercicioTreino}</td>
                                <td>${exerciciot.grupoMuscular.nomeGrupoMuscular}</td>
                                <td>${exerciciot.exercicio.nomeExercicio}</td>
                                <td>${exerciciot.aparelho.nomeAparelho}</td>
                                <td>${exerciciot.seriesTreino},
                                    ${exerciciot.cargaTreino},
                                    ${exerciciot.repeticoesTreino}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
               </div>
               

            </c:forEach>

        <div id="divCadastrarTreino">
            <h1> Cadastrar novo Treino</h1>
            <form method="POST" action="${pageContext.request.contextPath}/SalvarTreino">

                <p>${mensagem}</p>

                <input type="hidden" name="idTreino" value="${treino.idTreino}">
                <input type="hidden" name="idAluno" value="${idAluno}">
                <input type="hidden" name="idPersonal" value="${personal}">
                <br/>
                <br/>
                <label for="nomeTreino">Nome:</label>
                <input type="text" name="nomeTreino" id="nomeTreino" value="${treino.nomeTreino}"><br />
                <br />
                <label for="dataTreino">Data Treino </label>
                <input type="date" name="dataTreino" id="dataTreino" value="${treino.dataTreino}">
                <br />
                <label for="grupoMuscular">Grupo Muscular</label>
                <br />
                <c:forEach var="grupomuscular" items="${grupomusculares}">
                    <input type="checkbox" name="grupomuscular" id="${grupomuscular.nomeGrupoMuscular}" value="${grupomuscular.idGrupoMuscular}">
                    <label for="${grupomuscular.nomeGrupoMuscular}">${grupomuscular.nomeGrupoMuscular}</label><br/>
                </c:forEach>
                <input type="submit" value="Cadastrar Novo Treino">
            </form>
        </div>

    </body>
    <jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>
</html>
