<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:10:55
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>JSP Page</title>
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
                    <table class="table table-striped">
                        <tr class="thead-dark">
                            <th>Nome</th>
                            <th class="text-center">Opções</th>
                        </tr>


                        <c:forEach var="aparelho" items="${aparelhos}">
                            <tr>
                                <td>${aparelho.nomeAparelho}</td>
                                <td><a class="btn btn-primary col-md-5" href="${pageContext.request.contextPath}/CarregarAparelho?idAparelho=${aparelho.idAparelho}">Alterar</a>
                                <a class="btn btn-danger col-md-5" href="#" onclick="excluir('${pageContext.request.contextPath}/ExcluirAparelho?idAparelho=${aparelho.idAparelho}')">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>

                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalExemplo">
                        Novo Aparelho
                    </button>
                    <div class="col-md-12" >
                        <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <div id="divCadastrarTreino" class="col-md-12">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            <h1 class="text-center"> Salvar Aparelhos</h1>
                                        </div>
                                    </div>
                                    <div class="modal-body">
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
                                </div>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <jsp:forward page="../../login/login.jsp"></jsp:forward>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
