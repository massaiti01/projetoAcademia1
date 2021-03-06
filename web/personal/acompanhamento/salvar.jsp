<%-- 
    Document   : salvar
    Created on : 12/11/2019, 14:05:09
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
            <title>Cadastrar Medidas</title>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   
        </head>
        <body>
            <div class="col-md-12">
               <c:choose> 
        <c:when test="${!empty pessoa}">
            <h1 class="text-center">Medidas</h1>
            <table class="table table-striped">
                <tr class="thead-dark">
                    <th>Ombro</th>
                    <th>Peitoral</th>
                    <th>Braco D</th>
                    <th>Braco E</th>
                    <th>Antebraco D</th>
                    <th>Antebraco E</th>
                    <th>Cintura</th>
                    <th>Gluteo</th>
                    <th>Quadril</th>
                    <th>Perna D</th>
                    <th>Perna E</th>
                    <th>Panturrilha D</th>
                    <th>Panturrilha E</th>
                    <th>Data da Medi��o</th>
                    <th>Nome Personal</th>
                    <th>OP��O</th>
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
                     <td><a class="btn btn-danger" href="#" onclick="excluir('${pageContext.request.contextPath}/ExcluirMedida?idAcompanhamento=${medida.idAcompanhamento}&&idAluno=${medida.aluno.idAluno}')">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
              <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                    </c:if>
        <c:if test="${pessoa.tipoPessoa eq 'PER'}">
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
                                <input type="number" name="ombroAluno" class="form-control col-md-12" id="ombroAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="peitoralAluno">Peitoral</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="peitoralAluno" class="form-control col-md-12" id="peitoralAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="bracoDAluno">Bra�o Direito</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="bracoDAluno" class="form-control col-md-12" id="bracoDAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="bracoEAluno">Bra�o Esquerdo</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="bracoEAluno" class="form-control col-md-12" id="bracoEAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="anteBracoDAluno">Antebra�o Direito</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="anteBracoDAluno" class="form-control col-md-12" id="anteBracoDAluno" required/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div  class="col-md-4">
                                <label class="col-sm-12 col-form-label" for="anteBracoEAluno">Antebra�o Esquerdo</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="anteBracoEAluno" class="form-control col-md-12" id="anteBracoEAluno" required/>
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
                                <input type="number" name="cinturaAluno" class="form-control col-md-12" id="cinturaAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label for="gluteoAluno">Gluteos</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="gluteoAluno" class="form-control col-md-12" id="gluteoAluno" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                                <label for="quadrilAluno">Quadril</label>
                            </div>
                            <div class="col-md-8">
                                <input type="number" name="quadrilAluno" class="form-control col-md-12" id="quadrilAluno" required/>
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
                        <input type="number" name="pernaDAluno" class="form-control col-md-12" id="pernaDAluno" required/>
                         </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="pernaEAluno">Perna Esquerda</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="pernaEAluno" class="form-control col-md-12" id="pernaEAluno" required/>
                        </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="panturrilhaDAluno">Panturrilha Direita</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="panturrilhaDAluno" class="form-control col-md-12" id="panturrilhaDAluno" required/>
                        </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-4">
                        <label for="panturrilhaEAluno">Panturrilha Esquerda</label>
                        </div>
                            <div class="col-md-8">
                        <input type="number" name="panturrilhaEAluno" class="form-control col-md-12" id="panturrilhaEAluno" required/>
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
            </div>
    </body>
</html>
<jsp:include page="../../dashboard/javascripts.jsp"></jsp:include>