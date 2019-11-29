<%-- 
    Document   : salvar
    Created on : 29/11/2019, 12:38:21
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table class="table ">
                    <tr>
                        <th>ID</th>
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
                    </tr>
                    
                    <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                            <tr>
                                <td>${bioimpedancia.idBioimpedancia}</td>
                                <td>${bioimpedancia.pGordura}</td>
                                <td>${bioimpedancia.pesoGordura}</td>
                                <td>${bioimpedancia.massaMagra}</td>
                                <td>${bioimpedancia.pesoOsseo}</td>
                                <td>${bioimpedancia.pesoMuscular}</td>
                                <td>${bioimpedancia.pesoResidual}</td>
                                <td>${bioimpedancia.imc}</td>
                                <td>${bioimpedancia.indicePonderal}</td>
                                <td>${bioimpedancia.indiceConicidade}</td>
                                <td>${bioimpedancia.personal.nomePessoa}</td>
                            </tr>
                    </c:forEach>
                </table>
    <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
        <h1>Cadastrar bioimpedancia</h1>
            <form method="POST" action="${pageContext.request.contextPath}/SalvarBioimpedancia">
                <!-- <input type="hidden" name="idAluno" value="${aluno.idPessoa}"> -->
                <input type="hidden" name="idAluno" value="${idAluno}">
                <input type="hidden" name="idPersonal" value="${personal}">
                <input type="hidden" name="idAcademia" value="${academia}">
                <div>
                        <label for="idade">Idade</label>
                        <input type="number" name="idade" id="idade"/><br />
                        <label for="altura">Altura</label>
                        <input type="number" name="altura" id="altura"/><br />
                        <label for="peso">Peso</label>
                        <input type="number" name="peso" id="peso"/><br />
                        <label for="abdominal">Abdominal</label>
                        <input type="number" name="abdominal" id="abdominal"/><br />
                        <label for="coxa">Coxa</label>
                        <input type="number" name="coxa" id="coxa"/><br />
                        <label for="peitoral">Peitoral</label>
                        <input type="number" name="peitoral" id="peitoral"/><br />
                       
                        <label for="tipo">Tipo</label>
                        <input type="radio" name="tipo" id="7dobras" value="7dobras"/><label for="7dobras">7dobras</label>
                        <input type="radio" name="tipo" id="3dobras" value="3dobras"/><label for="3dobras">3dobras</label>
                        <div class="7dobras">
                            <label for="sexo">Sexo</label>
                        <input type="radio" name="sexo" id="f" value="f"/><label for="f">Feminino</label>
                        <input type="radio" name="sexo" id="m" value="m"/><label for="m">Masculino</label>
                        <br>
                        <label for="triciptal">triciptal</label>
                        <input type="number" name="triciptal" id="triciptal"/><br />
                        <label for="subescapular">subescapular</label>
                        <input type="number" name="subescapular" id="subescapular"/><br />
                        <label for="auxiliarMedio">auxiliar medio</label>
                        <input type="number" name="auxiliarMedio" id="auxiliarMedio"/><br />
                        <label for="suprailiaca">suprailiaca</label>
                        <input type="number" name="suprailiaca" id="suprailiaca"/><br />
                        <label for="biestiloide">biestilóide</label>
                        <input type="number" name="biestiloide" id="biestiloide"/><br />
                        <label for="bicondiliano">bicondiliano</label>
                        <input type="number" name="bicondiliano" id="bicondiliano"/><br />
                        </div>
                        
                </div>
            
                <div>
                    <input type="submit" value="Enviar">
                </div>
            </form>
    </c:if>
    </body>
</html>
