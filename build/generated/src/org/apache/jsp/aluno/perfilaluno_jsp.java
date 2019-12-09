package org.apache.jsp.aluno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class perfilaluno_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../dashboard/menualuno.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../dashboard/csss.jsp", out, false);
      out.write("\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>JSP Page</title>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../dashboard/javascripts.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write('\n');
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!empty pessoa}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            \n");
        out.write("            <div class=\"col-md-12 \">\n");
        out.write("            <div class=\"alert alert-success\" role=\"alert\">\n");
        out.write("  Bem Vindo ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.nomePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("</div>\n");
        out.write("            <div class=\"row\">\n");
        out.write("                <div class=\"card mb-4 col-md-3\">\n");
        out.write("                    <div class=\"card-header\">Medida</div>\n");
        out.write("                    <div class=\"card-body\">\n");
        out.write("                        <h5 class=\"card-title\">Cintura</h5>\n");
        out.write("<canvas id=\"myChart\" width=\"400\" height=\"400\"></canvas>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.8.0\"></script>\n");
        out.write("<script>\n");
        out.write("\tvar valores = [10.4,40.6,60.6,56.6,60.1,60];\n");
        out.write("var ctx = document.getElementById('myChart').getContext('2d');\n");
        out.write("var myChart = new Chart(ctx, {\n");
        out.write("    type: 'line',\n");
        out.write("    data: {\n");
        out.write("        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],\n");
        out.write("        datasets: [{\n");
        out.write("            label: 'Cintura',\n");
        out.write("            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],\n");
        out.write("            backgroundColor: [\n");
        out.write("                'rgba(0 , 0, 0, 0.2)',\n");
        out.write("                         ],\n");
        out.write("            borderColor: [\n");
        out.write("                'rgba(0, 0, 0, 1)',\n");
        out.write("                'rgba(54, 162, 235, 1)',\n");
        out.write("                'rgba(255, 206, 86, 1)',\n");
        out.write("                'rgba(75, 192, 192, 1)',\n");
        out.write("                'rgba(153, 102, 255, 1)',\n");
        out.write("                'rgba(255, 159, 64, 1)'\n");
        out.write("            ],\n");
        out.write("            borderWidth: 1\n");
        out.write("        }]\n");
        out.write("    },\n");
        out.write("    options: {\n");
        out.write("        scales: {\n");
        out.write("            yAxes: [{\n");
        out.write("                ticks: {\n");
        out.write("                    beginAtZero: true\n");
        out.write("                }\n");
        out.write("            }]\n");
        out.write("        }\n");
        out.write("    }\n");
        out.write("});\n");
        out.write("</script>\n");
        out.write("\n");
        out.write("                <div class=\"card mb-4 col-md-3\">\n");
        out.write("                    <div class=\"card-header\">Medida</div>\n");
        out.write("                    <div class=\"card-body\">\n");
        out.write("                        <h5 class=\"card-title\">Peitoral</h5>\n");
        out.write("                       <canvas id=\"myChart2\" width=\"400\" height=\"400\"></canvas>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <script>\n");
        out.write("\tvar valores = [80,85,86,90,87,92];\n");
        out.write("var ctx = document.getElementById('myChart2').getContext('2d');\n");
        out.write("var myChart = new Chart(ctx, {\n");
        out.write("    type: 'line',\n");
        out.write("    data: {\n");
        out.write("        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],\n");
        out.write("        datasets: [{\n");
        out.write("            label: 'Petoral',\n");
        out.write("            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],\n");
        out.write("            backgroundColor: [\n");
        out.write("                'rgba(0 , 0, 0, 0.2)',\n");
        out.write("                         ],\n");
        out.write("            borderColor: [\n");
        out.write("                'rgba(0, 0, 0, 1)'\n");
        out.write("            ],\n");
        out.write("            borderWidth: 1\n");
        out.write("        }]\n");
        out.write("    },\n");
        out.write("    options: {\n");
        out.write("        scales: {\n");
        out.write("            yAxes: [{\n");
        out.write("                ticks: {\n");
        out.write("                    beginAtZero: true\n");
        out.write("                }\n");
        out.write("            }]\n");
        out.write("        }\n");
        out.write("    }\n");
        out.write("});\n");
        out.write("</script>\n");
        out.write("                <div class=\"card mb-4 col-md-3\">\n");
        out.write("                    <div class=\"card-header\">Medida</div>\n");
        out.write("                    <div class=\"card-body\">\n");
        out.write("                        <h5 class=\"card-title\">Gluteos</h5>\n");
        out.write("                       <canvas id=\"myChart3\" width=\"400\" height=\"400\"></canvas>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <script>\n");
        out.write("\tvar valores = [80,85,86,90,87,92];\n");
        out.write("var ctx = document.getElementById('myChart3').getContext('2d');\n");
        out.write("var myChart = new Chart(ctx, {\n");
        out.write("    type: 'line',\n");
        out.write("    data: {\n");
        out.write("        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],\n");
        out.write("        datasets: [{\n");
        out.write("            label: 'Gluteos',\n");
        out.write("            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],\n");
        out.write("            backgroundColor: [\n");
        out.write("                'rgba(0 , 0, 0, 0.2)',\n");
        out.write("                         ],\n");
        out.write("            borderColor: [\n");
        out.write("                'rgba(0, 0, 0, 1)'\n");
        out.write("            ],\n");
        out.write("            borderWidth: 1\n");
        out.write("        }]\n");
        out.write("    },\n");
        out.write("    options: {\n");
        out.write("        scales: {\n");
        out.write("            yAxes: [{\n");
        out.write("                ticks: {\n");
        out.write("                    beginAtZero: true\n");
        out.write("                }\n");
        out.write("            }]\n");
        out.write("        }\n");
        out.write("    }\n");
        out.write("});\n");
        out.write("</script>\n");
        out.write("                <div class=\"card mb-4 col-md-3\">\n");
        out.write("                    <div class=\"card-header\">Medida</div>\n");
        out.write("                    <div class=\"card-body\">\n");
        out.write("                        <h5 class=\"card-title\">Ombro</h5>\n");
        out.write("                   <canvas id=\"myChart4\" width=\"400\" height=\"400\"></canvas>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <script>\n");
        out.write("\tvar valores = [80,85,86,90,87,92];\n");
        out.write("var ctx = document.getElementById('myChart4').getContext('2d');\n");
        out.write("var myChart = new Chart(ctx, {\n");
        out.write("    type: 'line',\n");
        out.write("    data: {\n");
        out.write("        labels: ['22/06', '22/07', '22/08', '22/09', '22/10', '22/11'],\n");
        out.write("        datasets: [{\n");
        out.write("            label: 'Ombro',\n");
        out.write("            data: [valores[0],valores[1],valores[2],valores[3],valores[4],valores[5]],\n");
        out.write("            backgroundColor: [\n");
        out.write("                'rgba(0 , 0, 0, 0.2)',\n");
        out.write("                         ],\n");
        out.write("            borderColor: [\n");
        out.write("                'rgba(0, 0, 0, 1)'\n");
        out.write("            ],\n");
        out.write("            borderWidth: 1\n");
        out.write("        }]\n");
        out.write("    },\n");
        out.write("    options: {\n");
        out.write("        scales: {\n");
        out.write("            yAxes: [{\n");
        out.write("                ticks: {\n");
        out.write("                    beginAtZero: true\n");
        out.write("                }\n");
        out.write("            }]\n");
        out.write("        }\n");
        out.write("    }\n");
        out.write("});\n");
        out.write("</script>\n");
        out.write("            </div>\n");
        out.write("            <input type=\"hidden\" name=\"idPessoa\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.idPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("\n");
        out.write("        <label>Nome:</label>\n");
        out.write("        <p> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.nomePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p><br />\n");
        out.write("\n");
        out.write("        <label>Login:</label>\n");
        out.write("        <p> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.loginPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p><br />\n");
        out.write("\n");
        out.write("        <label>CPF:</label>\n");
        out.write("        <p> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.cpfAluno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p> <br />\n");
        out.write("\n");
        out.write("        <label>Telefone:</label>\n");
        out.write("        <p> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.telefonePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p><br />\n");
        out.write("\n");
        out.write("        <label>Telefone Emergencia:</label>\n");
        out.write("        <p> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.telefoneEmergencia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p><br />\n");
        out.write("\n");
        out.write("    <td><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/CarregarAluno?idAluno=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.idPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Alterar</a></td>\n");
        out.write("    <td><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/DadosTreino?idAluno=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.idAluno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Treinos</a></td>\n");
        out.write("    <td><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/DadosMedida?idAluno=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.idAluno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Medidas</a></td>\n");
        out.write("    \n");
        out.write("    </div>\n");
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    ");
        if (true) {
          _jspx_page_context.forward("../login/login.jsp");
          return true;
        }
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
