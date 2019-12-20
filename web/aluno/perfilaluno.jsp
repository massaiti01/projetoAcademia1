<%-- 
    Document   : perfilaluno
    Created on : 18/11/2019, 14:56:20
    Author     : ERICMASSAITIUEMURA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="../dashboard/menualuno.jsp"></jsp:include>
<jsp:include page="../dashboard/csss.jsp"></jsp:include>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>JSP Page</title>
        </head>
        <script>
            function mostrarTreino() {
                var m = document.getElementById("treino");
                var e = document.getElementById("grafico");

                m.style.display = "block";
                e.style.display = "none";
            }

            function mostrarGrafico() {
                var m = document.getElementById("grafico");
                var e = document.getElementById("treino");

                m.style.display = "block";
                e.style.display = "none";
            }
            function MostrareEsconder(nome) {
                var x = document.getElementById(nome);
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
        <body>
        <c:if test="${!empty mensagem}">
            <div class="alert alert-success" role="alert">
                <p>${mensagem}</p>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${!empty pessoa}">

                <div class="form-group row col-md-12">
                    <div class="col-md-6"><button class="btn btn-success col-md-12 py-3" onclick="mostrarTreino()">Ver Treino</button></div>
                    <div class="col-md-6"><button class="btn btn-dark col-md-12 py-3" onclick="mostrarGrafico()">Ver Graficos</button></div>
                </div>

                <div class="table-responsive-sm col-md-12" id="treino" style="display:none">
                    <h3 class="text-center">Lista de Treinos</h3>
                    <table class="table">
                        <tr class="thead-dark">
                            <th class="espacotabela">Nome Treino</th>
                            <th class="espacotabela">Data Treino</th>
                            <th class="espacotabela">Personal</th>
                            <th class="espacotabela">Opções</th>
                        </tr>
                    </table>
                    <c:forEach var="treino" items="${treinos}">
                        <div class="table-responsive-sm">
                            <table class="table">

                                <tr>
                                    <td class="espacotabela">${treino.nomeTreino}</td>
                                    <td class="espacotabela">${treino.dataTreino}</td>
                                    <td class="espacotabela">${treino.personal.nomePessoa}</td>
                                    <td class="espacotabela"><button class="btn btn-primary" onclick="MostrareEsconder('divsumir${treino.idTreino}')">Ver Exercicios Do treino</button></td>
                                </tr>
                            </table>
                        </div>
                        <div id="divsumir${treino.idTreino}" style="display:none;">
                            <div class="col-md-12" >
                                <table class="table ">
                                    <tr class="thead-dark">
                                        <th class="col-md-3">Descricao</th>
                                        <th class="col-md-2">Grupo Muscular</th>
                                        <th class="col-md-2">Exercicio</th>
                                        <th class="col-md-2">Aparelho</th>
                                        <th class="col-md-3" row="3">repeticoes,series,carga,</th>
                                    </tr>
                                    <c:forEach var="exerciciot" items="${exerciciotreinos}">
                                        <c:if test="${exerciciot.treino.idTreino == treino.idTreino}">
                                            <tr>
                                                <td>${exerciciot.descricaoExercicioTreino}</td>
                                                <td>${exerciciot.grupoMuscular.nomeGrupoMuscular}</td>
                                                <td>${exerciciot.exercicio.nomeExercicio}</td>
                                                <td>${exerciciot.aparelho.nomeAparelho}</td>
                                                <td>${exerciciot.seriesTreino} de
                                                    ${exerciciot.repeticoesTreino} com
                                                    ${exerciciot.cargaTreino}KG
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </c:forEach> 
                    <a href="${pageContext.request.contextPath}/Imprimir?idAluno=${idAluno}" class="btn btn-primary">Imprimir Treino</a>
                </div>


                <div class="col-md-12" id="grafico" style="display:none;">
                    <h3 class="text-center">Graficos de Evolução</h3>
                    <h4 class="text-center">Acompanhamento</h4>
                    <div class="row">
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Ombro</div>
                            <div class="card-body">
                                <canvas id="ombro" width="400" height="400"></canvas>
                            </div>
                        </div>

                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Peitoral</div>
                            <div class="card-body">
                                <canvas id="peitoral" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Braços</div>
                            <div class="card-body">
                                <canvas id="bracos" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Antebraços</div>
                            <div class="card-body">
                                <canvas id="antebraco" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Cintura</div>
                            <div class="card-body">
                                <canvas id="cintura" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Quadril</div>
                            <div class="card-body">
                                <canvas id="quadril" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Gluteo</div>
                            <div class="card-body">
                                <canvas id="gluteos" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Pernas</div>
                            <div class="card-body">
                                <canvas id="perna" width="400" height="400"></canvas>
                            </div>
                        </div>
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Panturrilhas</div>
                            <div class="card-body">
                                <canvas id="panturrilha" width="400" height="400"></canvas>
                            </div>
                        </div>

                    </div> 

                    <h4 class="text-center">Bioimpendância</h4>
                    <div class="row">
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">% de Gorudura Corporal</div>
                            <div class="card-body">
                                <canvas id="pgordura" width="400" height="400"></canvas>
                            </div>
                        </div>

                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Índice de Conicidade</div>
                            <div class="card-body">
                                <canvas id="indiceconicidade" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Índice Ponderal</div>
                            <div class="card-body">
                                <canvas id="indiceponderal" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Índice de Massa Corporal</div>
                            <div class="card-body">
                                <canvas id="imc" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Peso de Gordura</div>
                            <div class="card-body">
                                <canvas id="pesogordura" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Massa Magra</div>
                            <div class="card-body">
                                <canvas id="massamagra" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Peso Residual</div>
                            <div class="card-body">
                                <canvas id="pesoresidual" width="400" height="400"></canvas>
                            </div>
                        </div>
                        
                        <div class="card mb-4 col-md-3">
                            <div class="card-header">Peso Muscular</div>
                            <div class="card-body">
                                <canvas id="pesomuscular" width="400" height="400"></canvas>
                            </div>
                        </div>
                    </div>

                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.cintura};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('cintura').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Cintura',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.gorduraDobras};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('pgordura').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: '% de Gordura Corporal',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.imc};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('imc').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Índice de Massa Corporal',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.pesodeGorduraDobras};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('pesogordura').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Peso de Gordura',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.massaMagraDobras};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('massamagra').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Massa Magra',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.pesoResidualDobras};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('pesoresidual').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Peso Residual',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.pesoMuscularDobras};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('pesomuscular').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Peso Muscular',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.indicePonderal};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('indiceponderal').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Índice Ponderal',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="bioimpedancia" items="${bioimpedancias}">
                        valores[i] = ${bioimpedancia.indiceConicidade};
                        datas[i] = "${bioimpedancia.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('indiceconicidade').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Índice de Conicidade',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.quadril};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('quadril').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Quadril',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 0, 0.2)'
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

                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.ombro};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>
                        var datas = [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]];
                        var ctx = document.getElementById('ombro').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Ombro',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
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
                    <script>
                        var valores = [];
                        var valores2 = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.bracoD};
                        valores2[i] = ${acompanhamento.bracoE};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('bracos').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Braço Direito',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 255, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(0 , 0, 255, 1)'

                                        ],
                                        borderWidth: 1
                                    }, {
                                        label: 'Braço Esquerdo',
                                        data: [valores2[0], valores2[1], valores2[2], valores2[3], valores2[4], valores2[5]],
                                        backgroundColor: [
                                            'rgba(255 , 0, 0, 0.2)',
                                        ],
                                        borderColor: [
                                            'rgba(255, 0, 0, 1)'

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
                    <script>
                        var valores = [];
                        var valores2 = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.pernaD};
                        valores2[i] = ${acompanhamento.pernaE};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('perna').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Perna Direita',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 255, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(0, 0, 255, 1)'

                                        ],
                                        borderWidth: 1
                                    }, {
                                        label: 'Perna Esquerda',
                                        data: [valores2[0], valores2[1], valores2[2], valores2[3], valores2[4], valores2[5]],
                                        backgroundColor: [
                                            'rgba(255 , 0, 0, 0.2)',
                                        ],
                                        borderColor: [
                                            'rgba(255, 0, 0, 1)'

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
                    <script>
                        var valores = [];
                        var valores2 = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.panturrilhaD};
                        valores2[i] = ${acompanhamento.panturrilhaE};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('panturrilha').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Panturrilha Direita',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 255, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(0, 0, 255, 1)'

                                        ],
                                        borderWidth: 1
                                    }, {
                                        label: 'Panturrilha Esquerda',
                                        data: [valores2[0], valores2[1], valores2[2], valores2[3], valores2[4], valores2[5]],
                                        backgroundColor: [
                                            'rgba(255 , 0, 0, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(255, 0, 0, 1)'

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
                    <script>
                        var valores = [];
                        var valores2 = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.anteBracoD};
                        valores2[i] = ${acompanhamento.anteBracoE};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('antebraco').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Antebraço Direito',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
                                        backgroundColor: [
                                            'rgba(0 , 0, 255, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(0, 0, 255, 1)'

                                        ],
                                        borderWidth: 1
                                    }, {
                                        label: 'Antebraço Esquerdo',
                                        data: [valores2[0], valores2[1], valores2[2], valores2[3], valores2[4], valores2[5]],
                                        backgroundColor: [
                                            'rgba(255 , 0, 0, 0.2)',
                                        ],
                                        borderColor: [
                                            'rgba(255, 0, 0, 1)'

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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.gluteo};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>
                        var ctx = document.getElementById('gluteos').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Gluteos',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
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
                    <script>
                        var valores = [];
                        var datas = [];
                        var i = 0;
                        <c:forEach var="acompanhamento" items="${acompanhamentos}">
                        valores[i] = ${acompanhamento.peitoral};
                        datas[i] = "${acompanhamento.data}";
                        i = i + 1;
                        </c:forEach>

                        var ctx = document.getElementById('peitoral').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: [datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]],
                                datasets: [{
                                        label: 'Petoral',
                                        data: [valores[0], valores[1], valores[2], valores[3], valores[4], valores[5]],
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
            </c:when>
            <c:otherwise>
                <jsp:forward page="../login/login.jsp"></jsp:forward>
            </c:otherwise>
        </c:choose>
    </body>
</html>
<jsp:include page="../dashboard/javascripts.jsp"></jsp:include>