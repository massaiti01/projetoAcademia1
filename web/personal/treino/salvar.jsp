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
        
         function MostrarDiv(nt,it) {
        document.getElementById('divCadastrarTreino').style.display = 'none';
        document.getElementById('divNovoTreino').style.display = 'block';
        document.getElementById("nomeTreino2").value = nt ;
        document.getElementById("idTreino2").value = it ;
         }
        </script>
    <body>
        <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome Treino</th>
                    <th>Data Treino</th>
                    <th>Personal</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="treino" items="${treinos}">
                <tr>
                    <td>${treino.idTreino}</td>
                    <td>${treino.nomeTreino}</td>
                    <td>${treino.dataTreino}</td>
                    <td>${treino.personal.nomePessoa}</td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirTreino?idTreino=${treino.idTreino}">Apagar Treino</a></td>
                    <td><button class="btn" onclick="MostrarDiv('${treino.nomeTreino}','${treino.idTreino}')">Adicionar Exercicio ao Treino</button></td>
                </tr>
            </c:forEach>
        </table>
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
            <input type="submit" value="Cadastrar Aparelho">
        </form>
        </div>
            
            
            <!-- DIV INVISIVEL QUE VAI CADASTRAR OS EXERCICIOS NO TREINO ESCOLHIDO -->
        <div id="divNovoTreino">
        <h1> Cadastrar novo Exercicio no treino</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicioTreino">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idTreino2" value="">
            <br/>
            <br/>
            <label for="nomeTreino">Nome Treino</label>
            <input type="text" id="nomeTreino2" readonly="true">
            <br />
            <label for="descricaoExercicioTreino">Descrição do Exercicio</label>
            <input type="text" name="descricaoExercicioTreino" id="descricaoExercicioTreino" value=""><br />
            <br />
            <label for="aparelho">Grupo Muscular</label>
            <br />
            <select id="grupomuscular" name="grupomuscular">
            <c:forEach var="grupomuscular" items="${grupomusculares}">
                <option value="${grupomuscular.idGrupoMuscular}">${grupomuscular.nomeGrupoMuscular}</option>
            </c:forEach>    
            </select>
            <br />
            <label for="aparelho">Aparelho</label>
            <br />
            <select id="aparelho" name="aparelho">
            <c:forEach var="aparelho" items="${aparelhos}">
                <option value="${aparelho.idAparelho}">${aparelho.nomeAparelho}</option>
            </c:forEach>    
            </select>
             <br />
            <label for="exercicio">Exercicio</label>
            <br />
            <select id="exercicio" name="exercicio">
            <c:forEach var="exercicio" items="${exercicios}">
                <option value="${exercicio.idExercicio}">${exercicio.nomeExercicio}</option>
            </c:forEach>    
            </select>
            <br />
            <label for="numeroDeSeries">Numero de Series</label>
            <input type="number" name="numeroDeSeries" id="numeroDeSeries" value=""><br />
            <br />
            <label for="numeroDeSeries">cargaTreino</label>
            <input type="number" name="numeroDeSeries" id="numeroDeSeries" value=""><br />
            <br />
            <label for="repeticoesTreino">RepeticoesTreino</label>
            <input type="number" name="repeticoesTreino" id="repeticoesTreino" value=""><br />
            <br />
            
                <input type="submit" value="Cadastrar Aparelho">
        </form>
        </div>
    </body>
    <jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>
</html>
