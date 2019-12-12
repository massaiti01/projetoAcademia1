<%-- 
    Document   : listar
    Created on : 11/11/2019, 11:32:48
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Lista de Personais</title>
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
                    }
                }

            </script>
        </head>
        <body>
        <c:choose> 
            <c:when test="${pessoa.tipoPessoa eq 'ACA'}">
                <div class="col-md-12">
                    <nav class="navbar navbar-light bg-light col-md-12">
                        <div class="form-group row">
                            <a class="navbar-brand col-md-12">Personais</a>
                            <div class="col-md-7">
                                <input class="form-control mr-sm-2 col-md-12" id="filtro-nome" placeholder="Pesquisar" aria-label="Search">
                            </div>
                            <div class="col-md-5">
                                <a class="btn btn-success" href="personal/salvar.jsp">Cadastrar Personal</a>
                            </div>
                        </div>
                    </nav>
                    <table class="table table-striped" id="lista">
                        <tr class="thead-dark">
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>Tipo</th>
                            <th>LOGIN</th>
                            <th>Cref</th>
                            <th row="2">Opções</th>
                        </tr>


                        <c:forEach var="personal" items="${personais}">
                            <tr>
                                <td>${personal.nomePessoa}</td>
                                <td>${personal.telefonePessoa}</td>
                                <td>${personal.tipoPessoa}</td>
                                <td>${personal.loginPessoa}</td>
                                <td>${personal.crefPersonal}</td>
                                <td><a href="${pageContext.request.contextPath}/CarregarPersonal?idPersonal=${personal.idPessoa}">Alterar</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="../../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
