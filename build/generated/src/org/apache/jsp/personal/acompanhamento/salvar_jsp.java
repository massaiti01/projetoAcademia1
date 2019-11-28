package org.apache.jsp.personal.acompanhamento;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class salvar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../dashboard/csss.jsp", out, false);
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastrar Medidas</title>\n");
      out.write("         <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        google.charts.load('current', { packages: [ 'corechart' ] })\n");
      out.write("        google.charts.setOnLoadCallback(drawChart)\n");
      out.write("        function drawChart(dale[]) {\n");
      out.write("            const container = document.querySelector('#chart')\n");
      out.write("            const data = new google.visualization.arrayToDataTable([\n");
      out.write("                [ 'Nome', 'Braço D','Braço E' ],\n");
      out.write("                [ '20/04', 10,20 ],\n");
      out.write("                [ '20/05', 20,30 ],\n");
      out.write("                [ '20/06 ', 30 ,35],\n");
      out.write("                [ '20/07', 40 ,40],\n");
      out.write("                [ '20/08', 50 ,70],\n");
      out.write("            ])\n");
      out.write("            const options = {\n");
      out.write("                title: 'Tabela de Acompanhamento',\n");
      out.write("                height: 400,\n");
      out.write("                width: 720\n");
      out.write("            }\n");
      out.write("            // const chart = new google.visualization.ColumnChart(container)\n");
      out.write("            // const chart = new google.visualization.BarChart(container)\n");
      out.write("            // const chart = new google.visualization.LineChart(container)\n");
      out.write("            const chart = new google.visualization.LineChart(container)\n");
      out.write("            chart.draw(data, options)\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"chart\">\n");
      out.write("        </div>\n");
      out.write("          <table class=\"table \">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Medida Ombro</th>\n");
      out.write("                        <th>Medida Peitoral</th>\n");
      out.write("                        <th>Medida Braco D</th>\n");
      out.write("                        <th>Medida Braco E</th>\n");
      out.write("                        <th>Medida antebraco D</th>\n");
      out.write("                        <th>Medida antebraco E</th>\n");
      out.write("                        <th>Medida Cintura</th>\n");
      out.write("                        <th>Medida Gluteo</th>\n");
      out.write("                        <th>Medida Quadril</th>\n");
      out.write("                        <th>Medida Perna D</th>\n");
      out.write("                        <th>Medida Perna E</th>\n");
      out.write("                        <th>Medida Panturrilha D</th>\n");
      out.write("                        <th>Medida Panturrilha E</th>\n");
      out.write("                        <th>Data da Medição</th>\n");
      out.write("                        <th>Nome Personal</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </table>\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("medida");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medidas}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.idAcompanhamento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.ombro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.peitoral}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.bracoD}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.bracoE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.anteBracoD}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.anteBracoE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.cintura}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.gluteo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.quadril}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.pernaD}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.pernaE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.panturrilhaD}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.panturrilhaE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.data}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.personal.nomePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                \n");
          out.write("                            </tr>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.tipoPessoa  eq 'PER'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <h1>Cadastrar Medidas</h1>\n");
        out.write("            <form method=\"POST\" action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/SalvarMedidas\">\n");
        out.write("                <!-- <input type=\"hidden\" name=\"idAluno\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aluno.idPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"> -->\n");
        out.write("                <input type=\"hidden\" name=\"idAluno\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idAluno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                <input type=\"hidden\" name=\"idPersonal\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${personal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                <input type=\"hidden\" name=\"idAcademia\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                <div>\n");
        out.write("                    <h2>Musculos Superiores</h2>\n");
        out.write("                        <label for=\"ombroAluno\">Ombro</label>\n");
        out.write("                        <input type=\"number\" name=\"ombroAluno\" id=\"ombroAluno\"/><br />\n");
        out.write("                        <label for=\"peitoralAluno\">Peitoral</label>\n");
        out.write("                        <input type=\"number\" name=\"peitoralAluno\" id=\"peitoralAluno\"/><br />\n");
        out.write("                        <label for=\"bracoDAluno\">Braço Direito</label>\n");
        out.write("                        <input type=\"number\" name=\"bracoDAluno\" id=\"bracoDAluno\"/><br />\n");
        out.write("                        <label for=\"bracoEAluno\">Braço Esquerdo</label>\n");
        out.write("                        <input type=\"number\" name=\"bracoEAluno\" id=\"bracoEAluno\"/><br />\n");
        out.write("                        <label for=\"anteBracoDAluno\">Antebraço Direito</label>\n");
        out.write("                        <input type=\"number\" name=\"anteBracoDAluno\" id=\"anteBracoDAluno\"/><br />\n");
        out.write("                        <label for=\"anteBracoEAluno\">Antebraço Esquerdo</label>\n");
        out.write("                        <input type=\"number\" name=\"anteBracoEAluno\" id=\"anteBracoEAluno\"/><br />\n");
        out.write("                </div>\n");
        out.write("                <div>\n");
        out.write("                    <h2>Musculos Medianos</h2>\n");
        out.write("                    <label for=\"cinturaAluno\">Cintura</label>\n");
        out.write("                    <input type=\"number\" name=\"cinturaAluno\" id=\"cinturaAluno\"/><br />\n");
        out.write("                    <label for=\"gluteoAluno\">Gluteos</label>\n");
        out.write("                    <input type=\"number\" name=\"gluteoAluno\" id=\"gluteoAluno\"/><br />\n");
        out.write("                    <label for=\"quadrilAluno\">Quadril</label>\n");
        out.write("                    <input type=\"number\" name=\"quadrilAluno\" id=\"quadrilAluno\"/><br />\n");
        out.write("                </div>\n");
        out.write("                <div>\n");
        out.write("                    <h2>Musculos Inferiores</h2>\n");
        out.write("                        <label for=\"pernaDAluno\">Perna Direita</label>\n");
        out.write("                        <input type=\"number\" name=\"pernaDAluno\" id=\"pernaDAluno\"/><br />\n");
        out.write("                        <label for=\"pernaEAluno\">Perna Esquerda</label>\n");
        out.write("                        <input type=\"number\" name=\"pernaEAluno\" id=\"pernaEAluno\"/><br />\n");
        out.write("                        <label for=\"panturrilhaDAluno\">Panturrilha Direita</label>\n");
        out.write("                        <input type=\"number\" name=\"panturrilhaDAluno\" id=\"panturrilhaDAluno\"/><br />\n");
        out.write("                        <label for=\"panturrilhaEAluno\">Panturrilha Esquerda</label>\n");
        out.write("                        <input type=\"number\" name=\"panturrilhaEAluno\" id=\"panturrilhaEAluno\"/><br />\n");
        out.write("                </div>\n");
        out.write("                <div>\n");
        out.write("                    <input type=\"submit\" value=\"Enviar\">\n");
        out.write("                </div>\n");
        out.write("            </form>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
