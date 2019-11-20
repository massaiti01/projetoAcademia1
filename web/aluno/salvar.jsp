<%-- 
    Document   : salvar.jsp
    Created on : 12/11/2019, 10:41:07
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aluno</title>
    </head>
    <body>
        <div class="col-md-6">
       <h1>Cadastrar Aluno</h1>
        <form method="POST" action="${pageContext.request.contextPath}/SalvarAluno">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">
            <input type="hidden" name="idAcademia" value="${pessoa.idPessoa}">
            
            <label for="nomePessoa">Nome:</label>
            <input type="text" name="nomePessoa" id="nomePessoa" value="${aluno.nomePessoa}"><br />
            
            <label for="cpfAluno">CPF:</label>
            <input type="text" name="cpfAluno" id="cpfAluno" value="${aluno.cpfAluno}"><br />
            
            <label for="telefonePessoa">Telefone:</label>
            <input type="text" name="telefonePessoa" id="telefonePessoa" value="${aluno.telefonePessoa}"><br />
            
            <label for="telefoneEmergencia">Telefone Emergencia:</label>
            <input type="text" name="telefoneEmergencia" id="telefoneEmergencia" value="${aluno.telefoneEmergencia}"><br />
            
            <label for="loginPessoa">Login:</label>
            <input type="text" name="loginPessoa" id="loginPessoa" value="${aluno.loginPessoa}"><br />
            
            <label for="senhaPessoa">Senha</label>
            <input type="password" name="senhaPessoa" id="senhaPessoa" value="${aluno.senhaPessoa}"><br />
            
            <input type="submit" value="enviar">
        </form>
        </div>
    </body>
</html>
