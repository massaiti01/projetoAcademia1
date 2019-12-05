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
        <h1>Academia</h1>
        <a href="${pageContext.request.contextPath}/personal/salvar.jsp">salvar personal</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarPersonal">listar personais</a>
        <br />
        <a href="${pageContext.request.contextPath}/personal/aparelho/salvar.jsp">salvar Aparelho</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarAparelho">listar Aparelho</a>
        <br />
        <a href="${pageContext.request.contextPath}/personal/grupomuscular/salvar.jsp">salvar Grupo Muscular</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarGrupoMuscular">listar Grupo Muscular</a>
        <br />
        <a href="${pageContext.request.contextPath}/personal/exercicio/salvar.jsp">salvar exercicio</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarExercicio">listar exercicio</a>
        <br />
        <a href="${pageContext.request.contextPath}/aluno/salvar.jsp">salvar aluno</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarAluno">listar alunos</a>
        <br />
        <a href="${pageContext.request.contextPath}/DadosTreino">Cadastrar Treino</a>
        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>

