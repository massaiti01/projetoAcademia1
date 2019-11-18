<%-- 
    Document   : index
    Created on : 11/11/2019, 10:48:33
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="view/cabecalho.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
    </body>
</html>
