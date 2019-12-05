<%-- 
    Document   : perfilpersonal
    Created on : 18/11/2019, 15:43:13
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
           <c:when test="${pessoa.tipoPessoa eq 'PER'}">
                <div class="alert alert-success" role="alert">
  Bem Vindo ${pessoa.nomePessoa}
</div>
        <h1>Personal</h1>
        
        <br />
        <a href="${pageContext.request.contextPath}/ListarAparelho">Salvar/Listar Aparelho</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarGrupoMuscular">Salvar/Listar Grupo Muscular</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarExercicio">Salvar/Listar exercicio</a>
        <br />
        <a href="${pageContext.request.contextPath}/aluno/salvar.jsp">salvar aluno</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarAluno">listar alunos</a>
        <br />
        <a href="${pageContext.request.contextPath}/DadosTreino">Cadastrar Treino</a>
        <br/>
        <a href="${pageContext.request.contextPath}/personal/salvar.jsp">salvar personal</a>
        <br />
        <a href="${pageContext.request.contextPath}/ListarPersonal">listar personais</a>
        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
