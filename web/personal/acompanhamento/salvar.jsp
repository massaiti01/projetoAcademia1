<%-- 
    Document   : salvar
    Created on : 12/11/2019, 14:05:09
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../../dashboard/csss.jsp"></jsp:include>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Medidas</title>
    </head>
    <body>
          <table class="table ">
                    <tr>
                        <th>ID</th>
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
                                <td>${medida.idAcompanhamento}</td>
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
    <c:if test="${pessoa.tipoPessoa  eq 'PER'}">
        <h1>Cadastrar Medidas</h1>
            <form method="POST" action="${pageContext.request.contextPath}/SalvarMedidas">
                <!-- <input type="hidden" name="idAluno" value="${aluno.idPessoa}"> -->
                <input type="hidden" name="idAluno" value="${idAluno}">
                <input type="hidden" name="idPersonal" value="${personal}">
                <input type="hidden" name="idAcademia" value="${academia}">
                <div>
                    <h2>Musculos Superiores</h2>
                        <label for="ombroAluno">Ombro</label>
                        <input type="number" name="ombroAluno" id="ombroAluno"/><br />
                        <label for="peitoralAluno">Peitoral</label>
                        <input type="number" name="peitoralAluno" id="peitoralAluno"/><br />
                        <label for="bracoDAluno">Braço Direito</label>
                        <input type="number" name="bracoDAluno" id="bracoDAluno"/><br />
                        <label for="bracoEAluno">Braço Esquerdo</label>
                        <input type="number" name="bracoEAluno" id="bracoEAluno"/><br />
                        <label for="anteBracoDAluno">Antebraço Direito</label>
                        <input type="number" name="anteBracoDAluno" id="anteBracoDAluno"/><br />
                        <label for="anteBracoEAluno">Antebraço Esquerdo</label>
                        <input type="number" name="anteBracoEAluno" id="anteBracoEAluno"/><br />
                </div>
                <div>
                    <h2>Musculos Medianos</h2>
                    <label for="cinturaAluno">Cintura</label>
                    <input type="number" name="cinturaAluno" id="cinturaAluno"/><br />
                    <label for="gluteoAluno">Gluteos</label>
                    <input type="number" name="gluteoAluno" id="gluteoAluno"/><br />
                    <label for="quadrilAluno">Quadril</label>
                    <input type="number" name="quadrilAluno" id="quadrilAluno"/><br />
                </div>
                <div>
                    <h2>Musculos Inferiores</h2>
                        <label for="pernaDAluno">Perna Direita</label>
                        <input type="number" name="pernaDAluno" id="pernaDAluno"/><br />
                        <label for="pernaEAluno">Perna Esquerda</label>
                        <input type="number" name="pernaEAluno" id="pernaEAluno"/><br />
                        <label for="panturrilhaDAluno">Panturrilha Direita</label>
                        <input type="number" name="panturrilhaDAluno" id="panturrilhaDAluno"/><br />
                        <label for="panturrilhaEAluno">Panturrilha Esquerda</label>
                        <input type="number" name="panturrilhaEAluno" id="panturrilhaEAluno"/><br />
                </div>
                <div>
                    <input type="submit" value="Enviar">
                </div>
            </form>
    </c:if>
    </body>
</html>
