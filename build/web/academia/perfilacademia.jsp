<%-- 
    Document   : perfilacademia
    Created on : 14/11/2019, 15:58:02
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
            <title>JSP Page</title>
        </head>
        <body>
        <c:choose> 
            <c:when test="${pessoa.tipoPessoa eq 'ACA'}">
                <div class="alert alert-success" role="alert">
                    Bem Vindo ${pessoa.nomePessoa}
                </div>
                <div class="col-md-12">
                    <h1 class="text-center">Academia</h1>

                    <div class="form-group">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12  py-3" href="${pageContext.request.contextPath}/ListarPersonal">Personais</a>
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12 py-3" href="${pageContext.request.contextPath}/ListarAparelho">Aparelhos</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12 py-3" href="${pageContext.request.contextPath}/ListarGrupoMuscular">Grupo Musculares</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12 py-3" href="${pageContext.request.contextPath}/ListarExercicio">Exercício</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12 py-3" href="${pageContext.request.contextPath}/ListarAluno">Alunos</a>
                        </div>
                    </div>

                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>

