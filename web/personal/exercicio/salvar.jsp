<%-- 
    Document   : salvar
    Created on : 13/11/2019, 09:26:08
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
        <jsp:include page="../../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Exercicio</title>
        </head>
        <body>
            <div class="col-md-12">
        <c:if test="${!empty mensagem}">
            <div class="alert alert-success" role="alert">
                <p>${mensagem}</p>
            </div>
        </c:if>
        <c:choose> 
            <c:when test="${!empty pessoa}">
                <table class="table table-striped">
                    <tr class="thead-dark">
                        <th>Nome</th>
                        <th>FOTO</th>
                        <th row="2">Opções</th>
                    </tr>
                    <c:forEach var="exercicio" items="${exercicios}">
                        <tr>
                            <td>${exercicio.nomeExercicio}</td>
                            <td><img src="MostrarFoto?idExercicio=${exercicio.idExercicio}" style="width:100px;height:100px;" alt="${exercicio.nomeExercicio}"> </td>
                            <td><a class="btn btn-primary col-md-5"  href="${pageContext.request.contextPath}/CarregarExercicio?idExercicio=${exercicio.idExercicio}">Alterar</a>
                           <a class="btn btn-danger col-md-5"  href="${pageContext.request.contextPath}/ExcluirExercicio?idExercicio=${exercicio.idExercicio}">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </table>

                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalExemplo">
                    Novo Exercicio
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
                                        <h1 class="text-center"> Salvar Exercicico</h1>
                                    </div>
                                </div>
                                <div class="modal-body">
                                    <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicio" id="salvarexercicio" enctype="multipart/form-data">

                                        <c:if test="${!empty mensagem}">
                                            <div class="alert alert-success" role="alert">
                                                <p>${mensagem}</p>
                                            </div>
                                        </c:if>

                                        <input type="hidden" name="idExercicio" value="0">
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
