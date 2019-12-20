<%-- 
    Document   : salvar.jsp
    Created on : 14/11/2019, 10:17:42
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
            <title>JSP Page</title>
        </head>
        <body>
        <c:choose> 
            <c:when test="${!empty pessoa}">
                <div class="col-md-12">
                    <h1> Cadastrar novo Exercicio no treino</h1>
                    <form method="POST" action="${pageContext.request.contextPath}/SalvarExercicioTreino">

                        <c:if test="${!empty mensagem}">
                            <div class="alert alert-success" role="alert">
                                <p>${mensagem}</p>
                            </div>
                        </c:if>

                        <div class="row form-group ">
                            <div class="col-md-2">
                                <label for="nomeTreino">Nome Treino</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" id="nomeTreino2" value="${treino.nomeTreino}" disabled>
                                <input type="hidden" name="idAluno" value="${idAluno}">
                                <input type="hidden" name="idTreino" value="${treino.idTreino}">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">

                                <label for="descricaoExercicioTreino">Descrição do Exercicio</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="descricaoExercicioTreino" class="form-control col-md-12" id="descricaoExercicioTreino" value="" required>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label for="aparelho">Grupo Muscular</label>
                            </div>
                            <div class="col-md-10">
                                <select id="grupomuscular" name="grupomuscular"  class="form-control col-md-12" required>
                                    <c:forEach var="grupomuscular" items="${grupomusculares}">
                                        <option value="${grupomuscular.grupoMuscular.idGrupoMuscular}">${grupomuscular.grupoMuscular.nomeGrupoMuscular}</option>
                                    </c:forEach>    
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label for="aparelho">Aparelho</label>
                            </div>
                            <div class="col-md-10">
                                <select id="aparelho" name="aparelho" class="form-control col-md-12" required>
                                    <c:forEach var="aparelho" items="${aparelhos}">
                                        <option value="${aparelho.idAparelho}">${aparelho.nomeAparelho}</option>
                                    </c:forEach>    
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">

                                <label for="exercicio">Exercicio</label>
                            </div>
                            <div class="col-md-10">
                                <input list="exercicio" name="exercicio" class="form-conntrol col-md-12">
                                <datalist id="exercicio" name="exercicio"   required>
                                    <c:forEach var="exercicio" items="${exercicios}">
                                        <option value="${exercicio.nomeExercicio}"></option>
                                    </c:forEach>    
                                </datalist>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">

                                <label for="numeroDeSeries">Numero de Series</label>
                            </div>
                            <div class="col-md-10">
                                <input type="number" class="form-control col-md-12" name="numeroDeSeries" id="numeroDeSeries" value="" required>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label for="cargaTreino">cargaTreino</label>
                            </div>
                            <div class="col-md-10">
                                <input type="number" class="form-control col-md-12" name="cargaTreino" id="cargaTreino" value="" required>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label for="repeticoesTreino">RepeticoesTreino</label>
                            </div>
                            <div class="col-md-10">
                                <input type="number" class="form-control col-md-12" name="repeticoesTreino" id="repeticoesTreino" value="" required>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-success col-md-12" value="Cadastrar Exercicio no Treino">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="../../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
