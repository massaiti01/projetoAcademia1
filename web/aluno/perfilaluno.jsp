<%-- 
    Document   : perfilaluno
    Created on : 18/11/2019, 14:56:20
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">
            
            <label>Nome:</label>
            <p> ${aluno.nomePessoa}</p><br />
            
            <label>CPF:</label>
            <p> ${aluno.cpfAluno}"</p> <br />
            
            <label>Telefone:</label>
            <p> ${aluno.telefonePessoa}"</p><br />
            
            <label>Telefone Emergencia:</label>
            <p> ${aluno.telefoneEmergencia}</p><br />
            
            <label for="loginPessoa">Login:</label>
            <p> ${aluno.loginPessoa}</p><br />
            
             <td><a href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a></td>
             <td><a href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a></td>
             <td><a href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a></td>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>