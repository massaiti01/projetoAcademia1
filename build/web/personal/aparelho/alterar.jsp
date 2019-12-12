<%-- 
    Document   : listar
    Created on : 13/11/2019, 10:07:32
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
        <title>Lista de Aparelhos</title>
    </head>
   <body>
         <c:if test="${!empty mensagem}">
            <div class="alert alert-success" role="alert">
                <p>${mensagem}</p>
            </div>
        </c:if>
        <div class="col-sm-12">
            <c:choose> 
                <c:when test="${!empty pessoa}">
          <h1 class="text-center"> Alterar Aparelho</h1>
                                       
                                    
                                        <form method="POST" action="${pageContext.request.contextPath}/SalvarAparelho">
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
