<%-- 
    Document   : listar
    Created on : 12/11/2019, 10:41:15
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alunos</title>
    </head>
    <body>
        <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Telefone Emergencia</th>
                    <th>Tipo</th>
                    <th>CPF</th>
                    <th>LOGIN</th>
                    <th row="2">Opções</th>
                </tr>

           
                <c:forEach var="aluno" items="${alunos}">
                <tr>
                    <td>${aluno.idPessoa}</td>
                    <td>${aluno.nomePessoa}</td>
                    <td>${aluno.telefonePessoa}</td>
                    <td>${aluno.telefoneEmergencia}</td>
                    <td>${aluno.tipoPessoa}</td>
                    <td>${aluno.cpfAluno}</td>
                    <td>${aluno.loginPessoa}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idPessoa}">Treinos</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
