<%-- 
    Document   : salvar.jsp
    Created on : 12/11/2019, 10:41:07
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
            <title>Aluno</title>
        </head>
        <body>
            <c:choose>
        <c:when test="${!empty pessoa}">
            <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                </c:if>
            <div class="col-md-12">
                <div class="col-md-12">
                    <h1 class="text-center">Salvar Aluno</h1>
                    <form method="POST" class="form-group" action="${pageContext.request.contextPath}/SalvarAluno">

                   

                    <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">
                    <input type="hidden" name="idAcademia" value="${academia}">
                    <div class="col-md-12">
                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="nomePessoa">Nome:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="nomePessoa" class="form-control col-md-12" id="nomePessoa" value="${aluno.nomePessoa}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="cpfAluno">CPF:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="cpfAluno" class="form-control col-md-12" id="cpfAluno" value="${aluno.cpfAluno}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">   
                                <label for="telefonePessoa">Telefone:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="telefonePessoa" class="form-control col-md-12" id="telefonePessoa" value="${aluno.telefonePessoa}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="telefoneEmergencia">Telefone Emergencia:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="telefoneEmergencia" class="form-control col-md-12" id="telefoneEmergencia" value="${aluno.telefoneEmergencia}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="loginPessoa">Login:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="loginPessoa" class="form-control col-md-12" id="loginPessoa" value="${aluno.loginPessoa}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="senhaPessoa">Senha</label>
                            </div>
                            <div class="col-md-10">
                                <input type="password" name="senhaPessoa" class="form-control col-md-12" id="senhaPessoa" value="${aluno.senhaPessoa}">
                            </div>
                        </div>
                    </div>
                    <br />
                    <input type="submit" class="btn btn-success py-3 col-md-12" value="Enviar">
                </form>
            </div>
        </div>
        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>