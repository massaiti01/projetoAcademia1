<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:26:08
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
          <c:choose> 
        <c:when test="${!empty pessoa}">
           <table class="table table-striped">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Nome</th>
                    <th>FOTO</th>
                    <th></th>
                    <th row="2">Opções</th>
                </tr>
                <c:forEach var="exercicio" items="${exercicios}">
                <tr>
                    <td>${exercicio.idExercicio}</td>
                    <td>${exercicio.nomeExercicio}</td>
                    <td><img src="MostrarFoto?idExercicio=${exercicio.idExercicio}" style="width:100px;height:100px;" alt="${exercicio.nomeExercicio}"> </td>
                    <td><a href="${pageContext.request.contextPath}/CarregarExercicio?idExercicio=${exercicio.idExercicio}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirExercicio?idExercicio=${exercicio.idExercicio}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
                <a class="btn btn-success py-3" href="teste">NOVO EXERCICIO</a>
          <div class="col-md-12" id="CadastrarNovo" style="display:none;">
        <h1 class="text-center"> Salvar Exercicico</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicio" id="salvarexercicio" enctype="multipart/form-data">
            
              <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                    </c:if>
            
            <input type="hidden" name="idExercicio" value="${exercicio.idExercicio}">
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
            <input type="submit" class="btn btn-success col-md-12 py-3" value="Salvar Exercicio">
                </div>
        </form>
      </div>
                </c:when>
<c:otherwise>
    <jsp:forward page="../../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
