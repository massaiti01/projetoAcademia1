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
    <body>
        <h1> Cadastro de Treino</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarAparelho">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idTreino" value="${treino.idTreino}">
            <input type="hidden" name="idAluno" value="${aluno.idPessoa}">
            <input type="hidden" name="idPersonal" value="${personal.idPessoa}">
            
            <label for="nomeTreino">Nome:</label>
            <input type="text" name="nomeTreino" id="nomeTreino" value="${treino.nomeTreino}"><br />
            <label for="diaTreino">Dia da Semana</label>
            <select name="diaTreino" id="diaTreino">
                <option value="seg">SEGUNDA-FEIRA</option>
                <option value="ter">TERÇA-FEIRA</option>
                <option value="qua">QUARTA-FEIRA</option>
                <option value="qui">QUINTA-FEIRA</option>
                <option value="sex">SEXTA-FEIRA</option>
                <option value="sab">SABADO</option>
            </select>
            <br />
            <label for="grupoMuscular">Grupo Muscular</label>
            <br />
            <c:forEach var="grupomuscular" items="${grupomusculares}">
                <input type="checkbox" name="grupomuscular" id="${grupomuscular.nomeGrupoMuscular}" value="${grupomuscular.idGrupoMuscular}">
                <label for="${grupomuscular.nomeGrupoMuscular}">${grupomuscular.nomeGrupoMuscular}</label><br/>
            </c:forEach>
            <input type="submit" value="Cadastrar Aparelho">
        </form>
    </body>
</html>
