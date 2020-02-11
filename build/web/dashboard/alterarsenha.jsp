<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">

<head>

  <meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Alterar Senha </title>
<jsp:include page="csss.jsp"></jsp:include>
<jsp:include page="menualuno.jsp"></jsp:include>
</head>

<body class="fundopreto">
<c:choose> <c:when test="${!empty pessoa}">

  <div class="container">
    <div class="card card-login mx-auto mt-5">
         <div class="logo text-center">
                <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/view/assets/img/LOGO_1.png" id="logotipo" alt="Logo Data projects"/><span id="logotipoletra1">Data</span> <span id="logotipoletra21">Projects</span></a>
            </div>
      <div class="card-header text-center">Alterar Senha</div>
      <div class="card-body">
        <form method="POST" action="${pageContext.request.contextPath}/AlterarSenha">
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="senha" name="senha" class="form-control" required="required" autofocus="autofocus">
              <label for="senha">Nova Senha</label>
            </div>
          </div>
          <input type="submit" class="btn btn-primary btn-block" value="Alterar Senha">
        </form>
      </div>
    </div>
  </div>
         

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
 </c:when><c:otherwise>
     <jsp:forward page="../../indexS.jsp"></jsp:forward>
 </c:otherwise> </c:choose>
</body>
<jsp:include page="javascripts.jsp"></jsp:include>
</html>
