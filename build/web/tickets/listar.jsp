<%-- 
    Document   : listar
    Created on : 31/12/2019, 11:41:35
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
            <title>Tickets</title>
        </head>
        <body>
               <c:choose> 
            <c:when test="${!empty pessoa}">
                <div class="alert alert-success" role="alert">
                    Bem Vindo ${pessoa.nomePessoa}
                </div>

                <nav class="navbar navbar-light bg-light col-md-12">
                    <div class="form-group row">
                        <a class="navbar-brand col-md-12">Tickets</a>
                        <div class="col-md-8">
                            <input class="form-control mr-sm-2 col-md-12" id="filtro-nome" placeholder="Pesquisar" aria-label="Search">
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="tickets/salvar.jsp">Abrir Ticket</a>
                        </div>
                    </div>
                </nav>

                <div class="col-sm-12 table-responsive">
                    <table class="table table-striped" id="lista">
                        <thead >    
                            <tr class="thead-dark">
                                <th scope="col">Titulo</th>
                                <th scope="col">Status</th>
                                <th scope="col">Data</th>
                                <th scope="col">Opções</th>
                                </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ticket" items="${tickets}">
                            <tr>
                    <td>${ticket.titulo}</td>
                    <td>${ticket.status}</td>
                    <td>${ticket.data}</td>
                    <td><a class="btn btn-primary" href="CarregarTicket?idTicket=${ticket.idTicket}" >Ver Ticket</a></td>
                    <c:forEach  var="msg" items="${mensagens}">
                        <c:if test="${ticket.idTicket == msg.ticket.idTicket}"> 
                            <div id="${msg.ticket.idTicket}" style="display:none;">
                        <p>${msg.mensagem}</p>
                        <p>${msg.remetente.nomePessoa} ${msg.data}</p>
                            </div>
                        </c:if>
                    </c:forEach>
                    </tr>
                </c:forEach>
                        </tbody>
                    </table>


                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
