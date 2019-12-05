<%-- 
    Document   : listar
    Created on : 12/11/2019, 10:41:15
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
        <title>Lista de Alunos</title>
    </head>
    <body>
        <c:choose> 
        <c:when test="${!empty pessoa}">
        <table class="table table-striped">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Telefone Emergencia</th>
                    <th>Tipo</th>
                    <th>CPF</th>
                    <th>LOGIN</th>
                    <th>Opções</th>
                </tr>
                <c:forEach var="aluno" items="${alunos}">
                <tr>
                    <td>${aluno.idAluno}</td>
                    <td>${aluno.nomePessoa}</td>
                    <td>${aluno.telefonePessoa}</td>
                    <td>${aluno.telefoneEmergencia}</td>
                    <td>${aluno.tipoPessoa}</td>
                    <td>${aluno.cpfAluno}</td>
                    <td>${aluno.loginPessoa}</td>
                    <td><a class="btn btn-warning col-sm-12  col-md-2" href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a>
                   <a class="btn btn-primary col-sm-12 col-md-2" href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a>
                    <a class="btn btn-primary col-sm-12 col-md-2" href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a>
                    <a class="btn btn-primary col-sm-12 col-md-3" href="${pageContext.request.contextPath}/DadosBioimpedancia?idAluno=${aluno.idAluno}">Bioimpedancia</a></td>
                </tr>
            </c:forEach>
               
        </table>
        <a class="btn btn-success" href="aluno/salvar.jsp">Cadastrar Novo Aluno</a>
        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
        
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
