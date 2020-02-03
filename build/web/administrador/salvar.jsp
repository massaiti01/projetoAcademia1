<%-- 
    Document   : salvar
    Created on : 09/01/2020, 12:14:48
    Author     : Eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Cadastrar Administrador</title>
        </head>
        <body>
      
            <c:if test="${!empty mensagem}">
                    <div class="alert alert-success" role="alert">
                        <p>${mensagem}</p>
                    </div>
                </c:if>
            <div class="col-md-12">
                <div class="col-md-12">
                    <h1 class="text-center">Salvar Administrador</h1>
                    <form method="POST" class="form-group" action="${pageContext.request.contextPath}/SalvarAdm">
                 <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">
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
                                <label for="telefonePessoa">Telefone:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="telefonePessoa" class="form-control col-md-12" id="telefonePessoa" value="${adm.telefonePessoa}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="telefoneAdm">Telefone Administrador</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="telefoneAdm" class="form-control col-md-12" id="telefoneAdm" value="${adm.telefoneAdm}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="email">Email</label>
                            </div>
                            <div class="col-md-10">
                                <input type="email" name="email" class="form-control col-md-12" id="email" value="${adm.emailAdm}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="emailAdm">Email Administrador</label>
                            </div>
                            <div class="col-md-10">
                                <input type="email" name="emailAdm" class="form-control col-md-12" id="emailAdm" value="${adm.emailAdm}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">  
                                <label for="loginPessoa">Login:</label>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="loginPessoa" class="form-control col-md-12" id="loginPessoa" value="${adm.loginPessoa}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-2">
                                <label for="senhaPessoa">Senha</label>
                            </div>
                            <div class="col-md-10">
                                <input type="password" name="senhaPessoa" class="form-control col-md-12" id="senhaPessoa" value="${adm.senhaPessoa}">
                            </div>
                        </div>
                    </div>
                    <br />
                    <input type="submit" class="btn btn-success py-3 col-md-12" value="Enviar">
                </form>
            </div>
        </div>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>