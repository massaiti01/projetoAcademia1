<%-- 
    Document   : responder
    Created on : 02/01/2020, 15:31:21
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
            <title>JSP Page</title>
        </head>
        <body>
        <c:choose> 
            <c:when test="${!empty pessoa}">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            ${ticket.titulo}
                        </div>
                        <c:forEach  var="msg" items="${mensagens}">
                            <div class="card-body">
                                <p>${msg.mensagem}</p>

                                <div class="card-footer donodamsg">
                                    <small class="text-muted ">${msg.remetente.nomePessoa} Data: ${msg.data}</small>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                        <br/>
                    <div class="card" style="${ticket.status == 'A' ? 'display:block':'display:none'}">
                        <form method="POST" action="${pageContext.request.contextPath}/Responder">

                            <input type="hidden" name="idPessoa" value="${pessoa.idPessoa}">
                            <input type="hidden" name="idTicket" value="${ticket.idTicket}">

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <textarea type="text" name="mensagem" id="mensagem" class="form-control col-md-12" value="" required>
                                    </textarea>
                                </div>
                            </div>

                            <input class="btn btn-success col-md-12" type="submit" value="Responder">
                        </form>
                            <br/>
                            <c:if test="${pessoa.tipoPessoa != 'ADM'}">
                            <a href="FinalizarTicket?idTicket=${ticket.idTicket}" class="btn btn-danger col-md-12">Finalizar Ticket</a>
                    </c:if>
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
