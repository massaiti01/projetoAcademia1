<%-- 
    Document   : menualuno
    Created on : 27/11/2019, 15:54:09
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Perfil Aluno</title>
        </head>
        <body>

            <nav class="navbar navbar-expand-lg navbar-light bg-light col-sm-12">
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/Redirect"><img src="${pageContext.request.contextPath}/view/assets/img/LOGO_1.png" id="logotipom" alt="Logo Data projects"/><span id="logotipoletram">Data</span> <span id="logotipoletra2m">Projects</span></a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Redirect">Inicio</a>
                    </li>
                    <c:if test="${!empty pessoa}">
                        <c:choose>
                            <c:when test="${pessoa.tipoPessoa != 'ALU'}">
                                <c:if test="${pessoa.tipoPessoa eq 'ACA'}">
                                    <li class="nav-item active">
                                    <a class="nav-link active" href="${pageContext.request.contextPath}/ListarPersonal">Personal</a>
                                </li>
                                </c:if>
                                <li class="nav-item active">
                                    <a class="nav-link active" href="${pageContext.request.contextPath}/ListarAluno">Alunos</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/ListarExercicio">Exercicios</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/ListarAparelho">Aparelhos</a>
                                </li>

                                <li class="nav-item active">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/LogarPessoa?acao=sair" class="nav-link">SAIR</a>
                                </li>

                            </c:when>

                            <c:otherwise>

                                <li class="nav-item active">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/LogarPessoa?acao=sair" class="nav-link">SAIR</a>
                                </li>

                            </c:otherwise>
                        </c:choose>
                    </c:if>

                </ul>

            </div>
        </nav>
    </body>
</html>
<jsp:include page="javascripts.jsp"></jsp:include>
