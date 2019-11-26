<%-- 
    Document   : salvar.jsp
    Created on : 14/11/2019, 10:17:42
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
        <h1> Cadastrar novo Exercicio no treino</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicioTreino">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idTreino2" value="">
            <br/>
            <br/>
            <label for="nomeTreino">Nome Treino</label>
            <input type="text" id="nomeTreino2" value="${treino.nomeTreino}" readonly="true">
            <input type="hidden" name="idAluno" value="${idAluno}">
            <input type="hidden" name="idTreino" value="${treino.idTreino}">
            <br />
            <label for="descricaoExercicioTreino">Descrição do Exercicio</label>
            <input type="text" name="descricaoExercicioTreino" id="descricaoExercicioTreino" value=""><br />
            <br />
            <label for="aparelho">Grupo Muscular</label>
            <br />
            <select id="grupomuscular" name="grupomuscular">
            <c:forEach var="grupomuscular" items="${grupotmusculares}">
                <option value="${grupomuscular.grupoMuscular.idGrupoMuscular}">${grupomuscular.grupoMuscular.nomeGrupoMuscular}</option>
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
            <label for="cargaTreino">cargaTreino</label>
            <input type="number" name="cargaTreino" id="cargaTreino" value=""><br />
            <br />
            <label for="repeticoesTreino">RepeticoesTreino</label>
            <input type="number" name="repeticoesTreino" id="repeticoesTreino" value=""><br />
            <br />
            
                <input type="submit" value="Cadastrar Exercicio no Treino">
        </form>
    </body>
</html>
