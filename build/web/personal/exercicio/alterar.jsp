<%-- 
    Document   : listar
    Created on : 13/11/2019, 10:07:27
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <div class="col-md-12">
            <h1 class="text-center"> Alterar Exercicico</h1>
        
        <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicio" id="salvarexercicio" enctype="multipart/form-data">

        <c:if test="${!empty mensagem}">
            <div class="alert alert-success" role="alert">
                <p>${mensagem}</p>
            </div>
        </c:if>

        <input type="hidden" name="idExercicio" value="${exercicio.idExercicio == null ? 0 : exercicio.idExercicio}">
        <input type="hidden" name="idAcademia" value="${academia}">

        <div class="row form-group ">
            <div class="col-md-2">
                <label for="nomeExercicio">Nome Exercicio:</label>
            </div>
            <div class="col-md-10">
                <input type="text" name="nomeExercicio" class="col-md-12 form-control" id="nomeExercicio" value="${exercicio.nomeExercicio}">
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-12">
                <input type="file" id="fotoExercicio" name="fotoExercicio">
            </div>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-success col-md-12 py-3" value="Alterar Exercicio">
        </div>
    </form>
        </div>

</body>
</html>
