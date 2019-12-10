<%-- 
    Document   : salvar
    Created on : 14/11/2019, 15:57:51
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <div class="col-md-12">
                <h1 class="text-center">Cadastrar Academia</h1>
                <form method="POST" action="${pageContext.request.contextPath}/SalvarAcademia">

                <p>${mensagem}</p>

                <input type="hidden" name="idPessoa" value="${academia.idPessoa}">

                <div class="col-md-12">
                    <div class="form-group row">
                        <div class="col-md-2">
                            <label for="nomePessoa">Nome:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" name="nomePessoa" id="nomePessoa" class="form-control col-md-12" value="${academia.nomePessoa}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-2">

                            <label for="cnpjAcademia">CNPJ</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" name="cnpjAcademia" id="cnpjAcademia" class="form-control col-md-12" value="${academia.cnpjAcademia}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-2">

                            <label for="telefonePessoa">Telefone:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" name="telefonePessoa" id="telefonePessoa" class="form-control col-md-12" value="${academia.telefonePessoa}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-2">
                            <label for="loginPessoa">Login:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" name="loginPessoa" id="loginPessoa" class="form-control col-md-12" value="${academia.loginPessoa}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-2">
                            <label for="senhaPessoa">Senha</label>
                        </div>
                        <div class="col-md-10">
                            <input type="password" name="senhaPessoa" id="senhaPessoa" class="form-control col-md-12" value="${academia.senhaPessoa}">
                        </div>
                    </div>

                    <input type="submit" class="btn btn-success py-3 col-md-12"  value="Cadastrar">
                </div>
            </form>
        </div>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>

