<%-- 
    Document   : perfilaluno
    Created on : 18/11/2019, 14:56:20
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
        <c:choose>
        <c:when test="${!empty pessoa}">
            
            <div class="col-md-12 ">
            <div class="alert alert-success" role="alert">
  Bem Vindo ${aluno.nomePessoa}
</div>
            <div class="row">
                <div class="card mb-4 col-md-3">
                    <div class="card-header">Medida</div>
                    <div class="card-body">
                        <h5 class="card-title">Cintura</h5>
<canvas id="myChart" width="400" height="400"></canvas>
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script>
	var valores = [10.4,40.6,60.6,56.6,60.1,60];
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],
        datasets: [{
            label: 'Cintura',
            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],
            backgroundColor: [
                'rgba(0 , 0, 0, 0.2)',
                         ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>

                <div class="card mb-4 col-md-3">
                    <div class="card-header">Medida</div>
                    <div class="card-body">
                        <h5 class="card-title">Peitoral</h5>
                       <canvas id="myChart2" width="400" height="400"></canvas>
                    </div>
                </div>
                <script>
	var valores = [80,85,86,90,87,92];
var ctx = document.getElementById('myChart2').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],
        datasets: [{
            label: 'Petoral',
            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],
            backgroundColor: [
                'rgba(0 , 0, 0, 0.2)',
                         ],
            borderColor: [
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
                <div class="card mb-4 col-md-3">
                    <div class="card-header">Medida</div>
                    <div class="card-body">
                        <h5 class="card-title">Gluteos</h5>
                       <canvas id="myChart3" width="400" height="400"></canvas>
                    </div>
                </div>
                <script>
	var valores = [80,85,86,90,87,92];
var ctx = document.getElementById('myChart3').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],
        datasets: [{
            label: 'Gluteos',
            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],
            backgroundColor: [
                'rgba(0 , 0, 0, 0.2)',
                         ],
            borderColor: [
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
                <div class="card mb-4 col-md-3">
                    <div class="card-header">Medida</div>
                    <div class="card-body">
                        <h5 class="card-title">Ombro</h5>
                   <canvas id="myChart4" width="400" height="400"></canvas>
                    </div>
                </div>
                <script>
	var valores = [80,85,86,90,87,92];
var ctx = document.getElementById('myChart4').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],
        datasets: [{
            label: 'Ombro',
            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],
            backgroundColor: [
                'rgba(0 , 0, 0, 0.2)',
                         ],
            borderColor: [
                'rgba(0, 0, 0, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
            </div>
            <input type="hidden" name="idPessoa" value="${aluno.idPessoa}">

        <label>Nome:</label>
        <p> ${aluno.nomePessoa}</p><br />

        <label>Login:</label>
        <p> ${aluno.loginPessoa}</p><br />

        <label>CPF:</label>
        <p> ${aluno.cpfAluno}</p> <br />

        <label>Telefone:</label>
        <p> ${aluno.telefonePessoa}</p><br />

        <label>Telefone Emergencia:</label>
        <p> ${aluno.telefoneEmergencia}</p><br />

    <td><a href="${pageContext.request.contextPath}/CarregarAluno?idAluno=${aluno.idPessoa}">Alterar</a></td>
    <td><a href="${pageContext.request.contextPath}/DadosTreino?idAluno=${aluno.idAluno}">Treinos</a></td>
    <td><a href="${pageContext.request.contextPath}/DadosMedida?idAluno=${aluno.idAluno}">Medidas</a></td>
    
    </div>

        </c:when>
<c:otherwise>
    <jsp:forward page="../login/login.jsp"></jsp:forward>
</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>