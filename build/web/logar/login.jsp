<%-- 
    Document   : login
    Created on : 18/11/2019, 12:50:09
    Author     : ERICMASSAITIUEMURA
--%>

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

  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Acessar Sistema</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="login" name="login" class="form-control" placeholder="Nome de Usuário" required="required" autofocus="autofocus">
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
          <a class="btn btn-primary btn-block" href="index.html">Entrar</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Cadastre-se</a>
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

</body>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>
</html>
