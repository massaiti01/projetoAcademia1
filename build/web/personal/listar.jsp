<%-- 
    Document   : listar
    Created on : 11/11/2019, 11:32:48
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../admin/cabecalho.jsp"></jsp:include>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Personais</title>
    </head>
    <body>
         <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Tipo</th>
                    <th>CPF</th>
                    <th>LOGIN</th>
                    <th>Cref Personal</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="personal" items="${personais}">
                <tr>
                    <td>${personal.idPessoa}</td>
                    <td>${personal.nomePessoa}</td>
                    <td>${personal.telefonePessoa}</td>
                    <td>${personal.tipoPessoa}</td>
                    <td>${personal.cpfPessoa}</td>
                    <td>${personal.loginPessoa}</td>
                    <td>${personal.crefPersonal}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarPersonal?idPersonal=${personal.idPessoa}">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
