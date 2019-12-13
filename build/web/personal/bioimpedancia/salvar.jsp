<%-- 
    Document   : salvar
    Created on : 29/11/2019, 12:38:21
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
            <title>Bioimpedancia</title>
            <script>
                function Mostrar7D() {
                    var x = document.getElementById("7Dobras");

                    x.style.display = "block";

                }
                function Sumir7D() {
                    var x = document.getElementById("7Dobras");

                    x.style.display = "none";

                }

            </script>
        </head>
        <body>
        <c:choose> 
            <c:when test="${!empty pessoa}">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <tr class="thead-dark">
                            <th>Tipo</th>
                            <th>% Gordura</th>
                            <th>Peso Gordura</th>
                            <th>Massa Magra</th>
                            <th>Peso Ósseo</th>
                            <th>Peso Muscular</th>
                            <th>Peso Residual</th>
                            <th>IMC</th>
                            <th>Indice Ponderal</th>
                            <th>Indice de Conicidade</th>
                            <th>Personal</th>
                            <th>Opções</th>
                        </tr>

                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                            <tr>
                                <td>${bioimpedancia.tipo}</td>
                                <td>${bioimpedancia.gorduraDobras}</td>
                                <td>${bioimpedancia.pesodeGorduraDobras}</td>
                                <td>${bioimpedancia.massaMagraDobras}</td>
                                <td>${bioimpedancia.pesoOsseoDobras}</td>
                                <td>${bioimpedancia.pesoMuscularDobras}</td>
                                <td>${bioimpedancia.pesoResidualDobras}</td>
                                <td>${bioimpedancia.imc}</td>
                                <td>${bioimpedancia.indicePonderal}</td>
                                <td>${bioimpedancia.indiceConicidade}</td>
                                <td>${bioimpedancia.personal.nomePessoa}</td>
                                <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/ExcluirBioimpedancia?idBioimpedancia=${bioimpedancia.idBioimpedancia}&&idAluno=${bioimpedancia.aluno.idAluno}">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                </c:if>
                <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
                    <div class="col-md-12">
                        <h1 class="text-center">Cadastrar bioimpedancia</h1>
                        <form method="POST" action="${pageContext.request.contextPath}/SalvarBioimpedancia">
                            <!-- <input type="hidden" name="idAluno" value="${aluno.idPessoa}"> -->
                            <input type="hidden" name="idAluno" value="${idAluno}">
                            <input type="hidden" name="idPersonal" value="${personal}">
                            <input type="hidden" name="idAcademia" value="${academia}">
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="idade">Idade</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="idade" id="idade" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="altura">Altura</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="altura" id="altura" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="peso">Peso</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="peso" id="peso" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="abdominal">Abdominal</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="abdominal" id="abdominal" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="coxa">Coxa</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="coxa" id="coxa" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="peitoral">Peitoral</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="peitoral" id="peitoral" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="biestiloide">biestilóide</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="biestiloide" id="biestiloide" required/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="bicondiliano">bicondiliano</label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control col-md-12" name="bicondiliano" id="bicondiliano" required/><br />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2">
                                    <label for="tipo">Tipo</label>
                                </div>
                                <div class="col-md-10">
                                    <div class="col-md-6"> 
                                        <input type="radio" class="form-check-input" name="tipo" id="7dobras" onclick="Mostrar7D()" value="7dobras" required/>
                                        <label for="7dobras">7 dobras</label>
                                    </div>
                                    <div class="col-md-6"> 
                                        <input type="radio" class="form-check-input" name="tipo" id="3dobras" onclick="Sumir7D()" value="3dobras" required/>
                                        <label for="3dobras">3 dobras</label> 
                                    </div>
                                </div>

                            </div>
                            <div id="7Dobras" style="display:none;">
                                <div class="form-group row">
                                    <div class="col-md-2">
                                        <label for="sexo">Sexo</label>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="col-md-6">
                                            <input type="radio" class="form-check-input" name="sexo" id="f" value="f" /><label for="f">Feminino</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="radio" class="form-check-input" name="sexo" id="m" value="m" /><label for="m">Masculino</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-2">
                                        <label for="triciptal">triciptal</label>
                                    </div>
                                    <div class="col-md-10">
                                        <input type="number" class="form-control col-md-12" name="triciptal" id="triciptal" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-2">
                                        <label for="subescapular">subescapular</label>
                                    </div>
                                    <div class="col-md-10">
                                        <input type="number" class="form-control col-md-12" name="subescapular" id="subescapular" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-2">
                                        <label for="auxiliarMedio">auxiliar medio</label>
                                    </div>
                                    <div class="col-md-10">
                                        <input type="number" class="form-control col-md-12" name="auxiliarMedio" id="auxiliarMedio" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-2">
                                        <label for="suprailiaca">suprailiaca</label>
                                    </div>
                                    <div class="col-md-10">
                                        <input type="number" class="form-control col-md-12" name="suprailiaca" id="suprailiaca" />
                                    </div>
                                </div>

                            </div>
                            <input class="btn btn-success col-md-12" type="submit" value="Enviar">
                            </div>



                        </form>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <jsp:forward page="../../login/login.jsp"></jsp:forward>
                </c:otherwise>
            </c:choose>
    </body>
</html>
