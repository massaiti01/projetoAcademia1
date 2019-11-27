<%-- 
    Document   : perfilaluno
    Created on : 18/11/2019, 14:56:20
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">
            
            <label for="nomePessoa">Nome:</label>
            <input type="text" name="nomePessoa" id="nomePessoa" value="${aluno.nomePessoa}" readonly="true"><br />
            
            <label for="cpfPessoa">CPF:</label>
            <input type="text" name="cpfPessoa" id="cpfPessoa" value="${aluno.cpfAluno}" readonly="true"><br />
            
            <label for="telefonePessoa">Telefone:</label>
            <input type="text" name="telefonePessoa" id="telefonePessoa" value="${aluno.telefonePessoa}" readonly="true"><br />
            
            <label for="telefoneEmergencia">Telefone Emergencia:</label>
            <input type="text" name="telefoneEmergencia" id="telefoneEmergencia" value="${aluno.telefoneEmergencia}" readonly="true"><br />
            
            <label for="loginPessoa">Login:</label>
            <input type="text" name="loginPessoa" id="loginPessoa" value="${aluno.loginPessoa}" readonly="true"><br />
            
            <label for="senhaPessoa">Senha</label>
            <input type="password" name="senhaPessoa" id="senhaPessoa" value="${aluno.senhaPessoa}" readonly="true"><br />
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>