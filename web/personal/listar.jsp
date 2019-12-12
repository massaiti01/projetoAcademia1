<%-- 
    Document   : listar
    Created on : 11/11/2019, 11:32:48
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
        <title>Lista de Personais</title>
    </head>
    <body>
        <c:choose> 
        <c:when test="${pessoa.tipoPessoa eq 'ACA'}">
         <table class="table table-striped">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Tipo</th>
                    <th>LOGIN</th>
                    <th>Cref</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="personal" items="${personais}">
                <tr>
                    <td>${personal.idPessoa}</td>
                    <td>${personal.nomePessoa}</td>
                    <td>${personal.telefonePessoa}</td>
                    <td>${personal.tipoPessoa}</td>
                    <td>${personal.loginPessoa}</td>
                    <td>${personal.crefPersonal}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarPersonal?idPersonal=${personal.idPessoa}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:when>
<c:otherwise>
    <jsp:forward page="../../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
