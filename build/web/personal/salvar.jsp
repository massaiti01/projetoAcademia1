<%-- 
    Document   : salvar
    Created on : 11/11/2019, 10:03:02
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal</title>
    </head>
    <body>
        
    <c:choose> 
        <c:when test="${pessoa.tipoPessoa eq 'ACA'}">
        <h1>Cadastrar Personal</h1>
        <form method="POST" action="${pageContext.request.contextPath}/SalvarPersonal">
            
              <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                    </c:if>
            
            <input type="hidden" name="idPessoa" value="${personal.idPessoa}">
            <input type="hidden" name="idAcademia" value="${academia}">
            
            <label for="nomePessoa">Nome:</label>
            <input type="text" name="nomePessoa" id="nomePessoa" value="${personal.nomePessoa}"><br />
            
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
               </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
