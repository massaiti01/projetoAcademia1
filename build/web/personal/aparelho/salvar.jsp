<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:10:55
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose> 
        <c:when test="${!empty pessoa}">
         <table class="table">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Opções</th>
                    <th></th>
                </tr>

           
                <c:forEach var="aparelho" items="${aparelhos}">
                <tr>
                    <td>${aparelho.idAparelho}</td>
                    <td>${aparelho.nomeAparelho}</td>
                    <td><a href="${pageContext.request.contextPath}/CarregarAparelho?idAparelho=${aparelho.idAparelho}">Alterar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirAparelho?idAparelho=${aparelho.idAparelho}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
          <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                    </c:if>
        <div class="col-md-12">
        <h1 class="text-center"> Salvar Aparelhos</h1>
         <form method="POST" action="${pageContext.request.contextPath}/SalvarAparelho">
            
            <p>${mensagem}</p>
           
            <input type="hidden" name="idAparelho" value="${aparelho.idAparelho}">
            <input type="hidden" name="idAcademia" value="${academia}">
             <div class="form-group row">
                <div class="col-md-2">
            <label for="nomeAparelho">Nome:</label>
                </div>
                 <div class="col-md-10">
                     <input type="text" name="nomeAparelho" class="form-control col-md-12" id="nomeAparelho" value="${aparelho.nomeAparelho}">
                 </div>
             </div>
                 <div class="form-group">
            <input class="btn btn-success col-md-12 py-3" type="submit" value="Salvar Aparelho">
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
