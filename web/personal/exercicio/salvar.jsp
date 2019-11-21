<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:26:08
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
        <h1> Cadastro de Exercicico</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicio" id="salvarexercicio" enctype="multipart/form-data">
            
            <p>${mensagem}</p>
            
            <input type="hidden" name="idExercicio" value="${exercicio.idExercicio}">
            <input type="hidden" name="idAcademia" value="${academia}">
            <label for="nomeExercicio">Nome Exercicio:</label>
            <input type="text" name="nomeExercicio" id="nomeExercicio" value="${exercicio.nomeExercicio}"><br /><br />
            <input type="file" id="fotoExercicio" name="fotoExercicio"><br /><br />
            <input type="submit" value="Cadastrar Exercicio">
        </form>
    </body>
</html>
