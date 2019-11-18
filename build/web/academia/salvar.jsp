<%-- 
    Document   : salvar
    Created on : 14/11/2019, 15:57:51
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-6">
       <h1>Cadastrar Academia</h1>
        <form method="POST" action="${pageContext.request.contextPath}/SalvarAcademia">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idPessoa" value="${academia.idPessoa}">
            <input type="hidden" name="idAcademia" value="${academia.idAcademia}">
            
            <label for="nomePessoa">Nome:</label>
            <input type="text" name="nomePessoa" id="nomePessoa" value="${academia.nomePessoa}"><br />
            
             <label for="cnpjAcademia">CNPJ</label>
            <input type="text" name="cnpjAcademia" id="cnpjAcademia" value="${academia.cnpjAcademia}"><br />
            
            <label for="telefonePessoa">Telefone:</label>
            <input type="text" name="telefonePessoa" id="telefonePessoa" value="${academia.telefonePessoa}"><br />
            
            <label for="loginPessoa">Login:</label>
            <input type="text" name="loginPessoa" id="loginPessoa" value="${academia.loginPessoa}"><br />
            
            <label for="senhaPessoa">Senha</label>
            <input type="password" name="senhaPessoa" id="senhaPessoa" value="${academia.senhaPessoa}"><br />
            
            <input type="submit" value="enviar">
        </form>
        </div>
    </body>
</html>
