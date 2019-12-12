<%-- 
    Document   : salvar
    Created on : 14/11/2019, 10:20:21
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
            <title>Grupo Muscular</title>
        </head>
        <body>
        <c:choose> 
            <c:when test="${!empty pessoa}">
                     <c:if test="${!empty mensagem}">
            <div class="alert alert-success" role="alert">
                <p>${mensagem}</p>
            </div>
        </c:if>
                <div class="col-md-12">
                    <table class="table table-striped">
                        <tr class="thead-dark">
                            <th>Nome</th>
                            <th class="text-center">Opções</th>
                        </tr>


                        <c:forEach var="grupomuscular" items="${grupomusculares}">
                            <tr>
                                <td>${grupomuscular.nomeGrupoMuscular}</td>
                                  <td>  <a class="btn btn-danger col-md-12" href="${pageContext.request.contextPath}/ExcluirGrupoMuscular?idGrupoMuscular=${grupomuscular.idGrupoMuscular}">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalExemplo">
                        Novo Grupo Muscular
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
                                            <h1 class="text-center"> Grupo Muscular</h1>
                                        </div>
                                    </div>
                                    <div class="modal-body">
                                        <form method="POST" action="${pageContext.request.contextPath}/SalvarGrupoMuscular">
                                            <input type="hidden" name="idGrupoMuscular" value="${grupomuscular.idGrupoMuscular}">
                                            <input type="hidden" name="idAcademia" value="${academia}">
                                             <div class="form-group row">
                                                <div class="col-md-2">
                                            <label for="nomeGrupoMuscular">Nome:</label>
                                            </div>
                                                <div class="col-md-10">
                                            <input type="text" name="nomeGrupoMuscular" id="nomeGrupoMuscular" class="form-control col-md-12" value="${grupomuscular.nomeGrupoMuscular}">
                                             </div>
                                            </div>
                                           <div class="form-group">
                                                <input class="btn btn-success col-md-12 py-3" type="submit" value="Salvar Grupo  Muscular">
                                            </div>
                                        </form>
                                    </div>
                                    </form>
                                </div></div>
                        </div>
                    </div>
                </div>
        </c:when>
        <c:otherwise>
            <jsp:forward page="../../login/login.jsp"></jsp:forward>
        </c:otherwise>
    </c:choose>
</body>
</html>
