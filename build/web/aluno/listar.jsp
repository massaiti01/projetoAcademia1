<%-- 
    Document   : listar
    Created on : 12/11/2019, 10:41:15
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Lista de Alunos</title>
             <script type="text/javascript">

                window.onload = function () {

                    //para nomes
                    var filtro = document.getElementById('filtro-nome');
                    var tabela = document.getElementById('lista');
                    filtro.onkeyup = function () {
                        var nomeFiltro = filtro.value;
                        for (var i = 1; i < tabela.rows.length; i++) {
                            var conteudoCelula = tabela.rows[i].cells[0].innerText;
                            var corresponde = conteudoCelula.toLowerCase().indexOf(nomeFiltro) >= 0;
                            tabela.rows[i].style.display = corresponde ? '' : 'none';
                        }
                    };
                }

            </script>
        </head>
        <body>
            <c:choose> 
                <c:when test="${!empty pessoa}">
        <jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
         <nav class="navbar navbar-light bg-light col-md-12">
                    <div class="form-group row">
                        <a class="navbar-brand col-md-12">Alunos</a>
                        <div class="col-md-8">
                            <input class="form-control mr-sm-2 col-md-12" id="filtro-nome" placeholder="Pesquisar" aria-label="Search">
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="aluno/salvar.jsp">Cadastrar Aluno</a>
                        </div>
                    </div>
                </nav>
            <div class="col-sm-12 table-responsive" >
                    <table class="table table-striped" id="lista">
                        <thead>    
                            <tr class="thead-dark">
                                <th scope="col">Nome</th>
                                <th scope="col">Telefone</th>
                                <th scope="col">Telefone Emergencia</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">CPF</th>
                                <th scope="col">LOGIN</th>
                                <th scope="col">Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="aluno" items="${alunos}">
                                <tr>
                                    <td>${aluno.nomePessoa}</td>
                                    <td>${aluno.telefonePessoa}</td>
                                    <td>${aluno.telefoneEmergencia}</td>
                                    <td>${aluno.tipoPessoa}</td>
                                    <td>${aluno.cpfAluno}</td>
                                    <td>${aluno.loginPessoa}</td>
                                    <td><a class="btn btn-warning col-sm-12  col-lg-2" href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-2" href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-2" href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a>
                                        <a class="btn btn-primary col-sm-12 col-lg-3" href="${pageContext.request.contextPath}/DadosBioimpedancia?idAluno=${aluno.idAluno}">Bioimpedancia</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
        </div>
                </c:when>
                <c:otherwise>
                    <jsp:forward page="../login/login.jsp"></jsp:forward>
                </c:otherwise>
            </c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
