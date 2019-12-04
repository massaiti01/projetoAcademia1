<%-- 
    Document   : perfilaluno
    Created on : 18/11/2019, 14:56:20
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
        <c:choose>
        <c:when test="${!empty pessoa}">
            
            <div class="col-md-12 ">
            <div class="alert alert-success" role="alert">
  Bem Vindo ${aluno.nomePessoa}
</div>
            <div class="row">
                <div class="card text-white bg-primary mb-4 col-md-3">
                    <div class="card-header">Grafico 1</div>
                    <div class="card-body">
                        <h5 class="card-title">Título de Card Primary</h5>
                        <p class="card-text">Um exemplo de texto rápido para construir o título do card e fazer preencher o conteúdo do card.</p>
                    </div>
                </div>

                <div class="card text-white bg-primary mb-4 col-md-3">
                    <div class="card-header">Grafico 2</div>
                    <div class="card-body">
                        <h5 class="card-title">Título de Card Primary</h5>
                        <p class="card-text">Um exemplo de texto rápido para construir o título do card e fazer preencher o conteúdo do card.</p>
                    </div>
                </div>
                
                <div class="card text-white bg-primary mb-4 col-md-3">
                    <div class="card-header">Grafico 3</div>
                    <div class="card-body">
                        <h5 class="card-title">Título de Card Primary</h5>
                        <p class="card-text">Um exemplo de texto rápido para construir o título do card e fazer preencher o conteúdo do card.</p>
                    </div>
                </div>
                
                <div class="card text-white bg-primary mb-4 col-md-3">
                    <div class="card-header">Grafico 3</div>
                    <div class="card-body">
                        <h5 class="card-title">Título de Card Primary</h5>
                        <p class="card-text">Um exemplo de texto rápido para construir o título do card e fazer preencher o conteúdo do card.</p>
                    </div>
                </div>
                
            </div>
            <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">

        <label>Nome:</label>
        <p> ${aluno.nomePessoa}</p><br />

        <label>Login:</label>
        <p> ${aluno.loginPessoa}</p><br />

        <label>CPF:</label>
        <p> ${aluno.cpfAluno}</p> <br />

        <label>Telefone:</label>
        <p> ${aluno.telefonePessoa}</p><br />

        <label>Telefone Emergencia:</label>
        <p> ${aluno.telefoneEmergencia}</p><br />

    <td><a href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a></td>
    <td><a href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a></td>
    <td><a href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a></td>
    
    </div>
     </c:forEach>
        </table>
        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>