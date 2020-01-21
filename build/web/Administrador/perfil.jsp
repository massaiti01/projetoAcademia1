<%-- 
    Document   : perfil
    Created on : 07/01/2020, 16:20:06
    Author     : Eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Perfil Administrador</title>
        </head>
        <body>
        <c:choose> 
            <c:when test="${pessoa.tipoPessoa eq 'ADM'}">
                <div class="alert alert-success" role="alert">
                    Bem Vindo ${pessoa.nomePessoa}
                </div>
                <div class="col-md-12">
                    <h1 class="text-center">ADMIN</h1>

                    <div class="form-group">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12  py-3" href="${pageContext.request.contextPath}/ListarAcademias">Academias</a>
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="col-md-12">
                            <a class="btn btn-dark col-md-12 py-3" href="${pageContext.request.contextPath}/ListarTickets">Tickets</a>
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

