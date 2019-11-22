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
         <form method="POST" action="${pageContext.request.contextPath}/SalvarTreino">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idTreino" value="${treino.idTreino}">
            <input type="text" name="idAluno" value="${idAluno}">
            <input type="text" name="idPersonal" value="${personal}">
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
    </body>
</html>
