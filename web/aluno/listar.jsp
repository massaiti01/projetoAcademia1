<%-- 
    Document   : listar
    Created on : 12/11/2019, 10:41:15
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Lista de Alunos</title>
        </head>
        <body>
            <c:choose> 
                <c:when test="${!empty pessoa}">
        <jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
            <div class="col-sm-12 table-responsive">
                    <table class="table table-striped">
                        <thead >    
                            <tr class="thead-dark">
                                <th scope="col">ID</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Telefone</th>
                                <th scope="col">Telefone Emergencia</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">CPF</th>
                                <th scope="col">LOGIN</th>
                                <th scope="col">Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="aluno" items="${alunos}">
                                <tr>
                                    <td scope="row">${aluno.idAluno}</td>
                                    <td>${aluno.nomePessoa}</td>
                                    <td>${aluno.telefonePessoa}</td>
                                    <td>${aluno.telefoneEmergencia}</td>
                                    <td>${aluno.tipoPessoa}</td>
                                    <td>${aluno.cpfAluno}</td>
                                    <td>${aluno.loginPessoa}</td>
                                    <td><a class="btn btn-warning col-sm-12  col-lg-2" href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-2" href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-2" href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-3" href="${pageContext.request.contextPath}/DadosBioimpedancia?idAluno=${aluno.idAluno}">Bioimpedancia</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                    <a class="btn btn-success" href="aluno/salvar.jsp">Cadastrar Novo Aluno</a>
        </div>
                </c:when>
                <c:otherwise>
                    <jsp:forward page="../login/login.jsp"></jsp:forward>
                </c:otherwise>
            </c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
