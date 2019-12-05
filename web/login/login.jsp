<%-- 
    Document   : login
    Created on : 18/11/2019, 12:50:09
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>ENTRAR </title>

<jsp:include page="../dashboard/csss.jsp"></jsp:include>
</head>

<body class="bg-dark">
<c:choose> <c:when test="${empty pessoa}">

  <div class="container">
    <div class="card card-login mx-auto mt-5">
         <div class="logo text-center">
                <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/view/assets/img/LOGO_1.png" id="logotipo" alt="Logo Data projects"/><span id="logotipoletra">Data</span> <span id="logotipoletra2">Projects</span></a>
            </div>
      <div class="card-header">Acessar Sistema</div>
      <div class="card-body">
        <form method="POST" action="${pageContext.request.contextPath}/LogarPessoa">
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="login" name="login" class="form-control" placeholder="Nome de Usuário" required="required" autofocus="autofocus">
              <label for="login">Nome de Usuário</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required="required">
              <label for="senha">Senha</label>
            </div>
          </div>
          <div class="form-group">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me">
                Lembrar Senha
              </label>
            </div>
          </div>
          <input type="hidden" name="acao" value="logar">
          <input type="submit" class="btn btn-primary btn-block" value="Entrar">
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.request.contextPath}/academia/salvar.jsp">Cadastre-se</a>
          <a class="d-block small" href="forgot-password.html">Esqueceu sua Senha?</a>
        </div>
      </div>
    </div>
  </div>
         

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
 </c:when><c:otherwise>
     <jsp:forward page="../indexS.jsp"></jsp:forward>
 </c:otherwise> </c:choose>
</body>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
</html>
