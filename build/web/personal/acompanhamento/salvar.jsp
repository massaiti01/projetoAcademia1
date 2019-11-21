<%-- 
    Document   : salvar
    Created on : 12/11/2019, 14:05:09
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Medidas</title>
    </head>
    <body>
        <h1>Cadastrar Medidas</h1>
            <form method="POST" action="${pageContext.request.contextPath}/SalvarMedidas">
                <!-- <input type="hidden" name="idAluno" value="${aluno.idPessoa}"> -->
                <input type="hidden" name="idAluno" value="6">
                <input type="hidden" name="idPersonal" value="1">
                <input type="hidden" name="idAcademia" value="${academia}">
                <div>
                    <h2>Geral</h2>
                        <label for="imcAluno">IMC</label>
                        <input type="number" name="imcAluno" id="imcAluno"/><br />
                        <label for="taxaGordura">Taxa de Gordura Corporal</label>
                        <input type="number" name="taxaGordura" id="taxaGordura"/><br />
                </div>
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
    </body>
</html>
