<%-- 
    Document   : salvar
    Created on : 12/11/2019, 14:05:09
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
            <title>Cadastrar Medidas</title>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        </head>
        <body>
               <c:choose> 
        <c:when test="${!empty pessoa}">
            <div id="chart">
            </div>
            <table class="table table-striped">
                <tr class="thead-dark">
                    <th>Medida Ombro</th>
                    <th>Medida Peitoral</th>
                    <th>Medida Braco D</th>
                    <th>Medida Braco E</th>
                    <th>Medida antebraco D</th>
                    <th>Medida antebraco E</th>
                    <th>Medida Cintura</th>
                    <th>Medida Gluteo</th>
                    <th>Medida Quadril</th>
                    <th>Medida Perna D</th>
                    <th>Medida Perna E</th>
                    <th>Medida Panturrilha D</th>
                    <th>Medida Panturrilha E</th>
                    <th>Data da Medição</th>
                    <th>Nome Personal</th>
                </tr>

            <c:forEach var="medida" items="${medidas}">
                <tr>
                    <td>${medida.ombro}</td>
                    <td>${medida.peitoral}</td>
                    <td>${medida.bracoD}</td>
                    <td>${medida.bracoE}</td>
                    <td>${medida.anteBracoD}</td>
                    <td>${medida.anteBracoE}</td>
                    <td>${medida.cintura}</td>
                    <td>${medida.gluteo}</td>
                    <td>${medida.quadril}</td>
                    <td>${medida.pernaD}</td>
                    <td>${medida.pernaE}</td>
                    <td>${medida.panturrilhaD}</td>
                    <td>${medida.panturrilhaE}</td>
                    <td>${medida.data}</td>
                    <td>${medida.personal.nomePessoa}</td>
                </tr>
            </c:forEach>
        </table>
              <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                    </c:if>
        <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
            <div class="col-md-12">
                <h1 class="col-md-12 text-center">Salvar Medidas</h1>
                <form method="POST" action="${pageContext.request.contextPath}/SalvarMedidas">
                    <!-- <input type="hidden" name="idAluno" value="${aluno.idPessoa}"> -->
                    <input type="hidden" name="idAluno" value="${idAluno}">
                    <input type="hidden" name="idPersonal" value="${personal}">
                    <input type="hidden" name="idAcademia" value="${academia}">

                    <div class="col-md-12">
                        <h2 class="col-md-12">Musculos Superiores</h2>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="ombroAluno">Ombro</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="ombroAluno" class="form-control col-md-12" id="ombroAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="peitoralAluno">Peitoral</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="peitoralAluno" class="form-control col-md-12" id="peitoralAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="bracoDAluno">Braço Direito</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="bracoDAluno" class="form-control col-md-12" id="bracoDAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="bracoEAluno">Braço Esquerdo</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="bracoEAluno" class="form-control col-md-12" id="bracoEAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="anteBracoDAluno">Antebraço Direito</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="anteBracoDAluno" class="form-control col-md-12" id="anteBracoDAluno"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div  class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="anteBracoEAluno">Antebraço Esquerdo</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="anteBracoEAluno" class="form-control col-md-12" id="anteBracoEAluno"/>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <h2 class="col-md-12">Musculos Medianos</h2>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label for="cinturaAluno">Cintura</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="cinturaAluno" class="form-control col-md-12" id="cinturaAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label for="gluteoAluno">Gluteos</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="gluteoAluno" class="form-control col-md-12" id="gluteoAluno"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label for="quadrilAluno">Quadril</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="quadrilAluno" class="form-control col-md-12" id="quadrilAluno"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <h2 class="col-md-12">Musculos Inferiores</h2>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="pernaDAluno">Perna Direita</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="pernaDAluno" class="form-control col-md-12" id="pernaDAluno"/>
                         </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="pernaEAluno">Perna Esquerda</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="pernaEAluno" class="form-control col-md-12" id="pernaEAluno"/>
                        </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="panturrilhaDAluno">Panturrilha Direita</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="panturrilhaDAluno" class="form-control col-md-12" id="panturrilhaDAluno"/>
                        </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="panturrilhaEAluno">Panturrilha Esquerda</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="panturrilhaEAluno" class="form-control col-md-12" id="panturrilhaEAluno"/>
                    </div>
                    </div>
                    </div>
                    <div>
                        <input type="submit" class="btn btn-success py-3 col-md-12" value="Enviar">
                    </div>
                </form>
            </div>
        </c:if>
             </c:when>
<c:otherwise>
    <jsp:forward page="../../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
