<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:10:55
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
        <h1> Cadastro de Aparelhos</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarAparelho">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idAparelho" value="${aparelho.idAparelho}">
            
            <label for="nomeAparelho">Nome:</label>
            <input type="text" name="nomeAparelho" id="nomeAparelho" value="${aparelho.nomeAparelho}"><br />
            <input type="submit" value="Cadastrar Aparelho">
        </form>
    </body>
</html>
