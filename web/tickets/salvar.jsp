<%-- 
    Document   : salvar
    Created on : 27/12/2019, 11:10:32
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
        <title>Abrir um Ticket</title>
    </head>
    <body>
         <div class="col-md-12">
             <c:choose> 
                <c:when test="${!empty pessoa.tipoPessoa}">
                    <c:if test="${!empty mensagem}">
                        <div class="alert alert-success" role="alert">
                            <p>${mensagem}</p>
                        </div>
                    </c:if>
                    <div class="col-md-12">
                        <h1 class="text-center">Abrir Ticket</h1>
                        <form method="POST" action="${pageContext.request.contextPath}/SalvarTicket">

                            <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}">

                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="titulo">Titulo</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="text" name="titulo" id="titulo" class="form-control col-md-12" value="" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="mensagem">Mensagem</label>
                                </div>
                                <div class="col-md-10">
                                    <textarea type="text" name="mensagem" id="mensagem" class="form-control col-md-12" value="" required>
                                    </textarea>
                                </div>
                            </div>

                            <input class="btn btn-success col-md-12" type="submit" value="Salvar">
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    <jsp:forward page="../login/login.jsp"></jsp:forward>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
