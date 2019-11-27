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
function MostrareEsconder(nome) {
     var x = document.getElementById(nome);
  if (x.style.display === "none") {
        x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
        </script>
        <body>
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome Treino</th>
                    <th>Data Treino</th>
                    <th>Personal</th>
                <c:if test="${pessoa.tipoPessoa  eq 'PER'}"> <th row="3">Opções</th> </c:if>
                </tr>
            </table>
            <c:forEach var="treino" items="${treinos}">
                <table class="table">
                <tr>
                    <td>${treino.idTreino}</td>
                    <td>${treino.nomeTreino}</td>
                    <td>${treino.dataTreino}</td>
                    <td>${treino.personal.nomePessoa}</td>
                   <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
                    <td><a href="${pageContext.request.contextPath}/ExcluirTreino?idTreino=${treino.idTreino}&&idAluno=${idAluno}">Apagar Treino</a></td>
                    <td><a href="${pageContext.request.contextPath}/DadosExercicioTreino?idTreino=${treino.idTreino}&&idAluno=${idAluno}">Adicionar Exercicio</a></td>
                   </c:if>
                    <td><button class="btn" onclick="MostrareEsconder('divsumir${treino.idTreino}')">Ver Exercicios Do treino</button>
                </tr>
                </table>
                    <div id="divsumir${treino.idTreino}" style="display:none;">
               <div class="col-md-12" >
                <table class="table ">
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
                                <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
                                <td><a href="${pageContext.request.contextPath}/ExcluirExercicioTreino?idAluno=${idAluno}&&idExercicioTreino=${exerciciot.idExercicioTreino}">Excluir Exercicio Treino </a></td>
                                </c:if>
                                </tr>
                        </c:if>
                    </c:forEach>
                </table>
               </div>
               </div>
            </c:forEach>
             <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
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
             </c:if>
    </body>
    <jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>
</html>
