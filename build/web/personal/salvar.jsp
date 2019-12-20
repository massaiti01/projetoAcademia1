<%-- 
    Document   : salvar
    Created on : 11/11/2019, 10:03:02
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Personal</title>
        </head>
        <body>

        <c:choose> 
            <c:when test="${pessoa.tipoPessoa eq 'ACA'}">
                <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                </c:if>
                    <div class="col-md-12">
                <h1 class="text-center">Cadastrar Personal</h1>
                <form method="POST" action="${pageContext.request.contextPath}/SalvarPersonal">

                    <input type="hidden" name="idPessoa" value="${personal.idPessoa}">
                    <input type="hidden" name="idAcademia" value="${academia}">

                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="nomePessoa">Nome:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="nomePessoa" id="nomePessoa" class="form-control col-md-12" value="${personal.nomePessoa}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">

                                <label for="telefonePessoa">Telefone:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="telefonePessoa" id="telefonePessoa" class="form-control col-md-12" value="${personal.telefonePessoa}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">

                                <label for="crefPersonal">Cref Personal:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="crefPersonal" id="crefPersonal" class="form-control col-md-12" value="${personal.crefPersonal}" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="loginPessoa">Login:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="loginPessoa" id="loginPessoa" class="form-control col-md-12" value="${personal.loginPessoa}" required>
                            </div></div>
                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="senhaPessoa">Senha</label>
                            </div>
                            <div class="col-md-10">
                                <input type="password" name="senhaPessoa" id="senhaPessoa" class="form-control col-md-12" value="" required>
                            </div>
                        </div>

                    <input class="btn btn-success col-md-12" type="submit" value="Salvar">
                </form>
                    </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
