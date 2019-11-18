<%-- 
    Document   : salvar
    Created on : 11/11/2019, 10:03:02
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><jsp:include page="../admin/cabecalho.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal</title>
    </head>
    <body>
        <h1>Cadastrar Personal</h1>
        <form method="POST" action="${pageContext.request.contextPath}/SalvarPersonal">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idPessoa" value="${personal.idPessoa}">
            
            <label for="nomePessoa">Nome:</label>
            <input type="text" name="nomePessoa" id="nomePessoa" value="${personal.nomePessoa}"><br />
            
            <label for="cpfPessoa">CPF:</label>
            <input type="text" name="cpfPessoa" id="cpfPessoa" value="${personal.cpfPessoa}"><br />
            
            <label for="telefonePessoa">Telefone:</label>
            <input type="text" name="telefonePessoa" id="telefonePessoa" value="${personal.telefonePessoa}"><br />
            
            <label for="crefPersonal">Cref Personal:</label>
            <input type="text" name="crefPersonal" id="crefPersonal" value="${personal.crefPersonal}"><br />
            
            <label for="loginPessoa">Login:</label>
            <input type="text" name="loginPessoa" id="loginPessoa" value="${personal.loginPessoa}"><br />
            
            <label for="senhaPessoa">Senha</label>
            <input type="password" name="senhaPessoa" id="senhaPessoa" value="${personal.senhaPessoa}"><br />
            
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
