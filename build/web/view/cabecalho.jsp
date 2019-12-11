<%-- 
    Document   : cabecalho
    Created on : 11/11/2019, 12:49:32
    Author     : ERICMASSAITIUEMURA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8" />
    <link rel="icon" href="favicon.png" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
    <link href="${pageContext.request.contextPath}/view/css/vendor/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/vendor/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/vendor/slick.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/vendor/slick-theme.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/vendor/odometer-theme-default.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/main.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/view/css/alterado.css" rel="stylesheet" />
</head>
<body>

    <header>
        <div class="container">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/view/assets/img/LOGO_1.png" id="logotipo" alt="Logo Data projects"/><span id="logotipoletra">Data</span> <span id="logotipoletra2">Projects</span></a>
            </div>
            <div class="menu">
                <ul id="fontelink">
                    <li><a href="${pageContext.request.contextPath}/index.jsp" class="active">INICIO</a></li>
                    <li><a href="services.html">SERVIÇOS</a></li>
                    <li><a href="portfolio.html">SOBRE</a></li>
                    <li><a href="about.html">CONTATO</a></li>
                    <li><a href="${pageContext.request.contextPath}/login/login.jsp">ACESSAR SISTEMA</a></li>
                </ul>
            </div>
             <div class="mobile-menu"><i class="fa fa-bars"></i></div>
        </div>
    </header>

    <div class="home-slider">
        <div class="home-slider--wrapper">
            <div>
                <div class="home-slider--wrapper__inner" style="background-image: url('${pageContext.request.contextPath}/view/assets/img/img1.jpg')">
                    <div class="container">
                        <h3>Softwares de Controle</h3>
                        <h1 id="titulofonte">Data Projects</h1>
                        <span class="dot-dash">.</span>
                        <p>Softwares de controle de Academia</p>
                    </div>
                </div>
            </div>
            <div>
                <div class="home-slider--wrapper__inner" style="background-image: url('${pageContext.request.contextPath}/view/assets/img/teste2.jpg')">
                    <div class="container">
                        <h3>DATA PROJECTS</h3>
                        <h1  id="titulofonte">Feedback Gym</h1>
                        <span class="dot-dash">.</span>
                        <p>Feedback Gym visa auxiliar Personal a controlar e monitorar o treino de seus alunos.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="home-slider--nav">
            <div class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></div>
            <div class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></div>
        </div>
        <div class="home-slider--anchor">
            <span><i class="fa fa-anchor" aria-hidden="true"></i></span>
        </div>
    </div>
<script type="text/javascript">
        window.odometerOptions = {
            format: '(,ddd)',
        };
    </script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/jquery-3.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/tether.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/slick.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/isotope.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/vendor/odometer.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/main.js"></script>
    </body>
</html>
