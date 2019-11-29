package org.apache.jsp.personal.bioimpedancia;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class salvar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <table class=\"table \">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>% Gordura</th>\n");
      out.write("                        <th>Peso Gordura</th>\n");
      out.write("                        <th>Massa Magra</th>\n");
      out.write("                        <th>Peso Ósseo</th>\n");
      out.write("                        <th>Peso Muscular</th>\n");
      out.write("                        <th>Peso Residual</th>\n");
      out.write("                        <th>IMC</th>\n");
      out.write("                        <th>Indice Ponderal</th>\n");
      out.write("                        <th>Indice de Conicidade</th>\n");
      out.write("                        <th>Personal</th>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <c:forEach var=\"bioimpedancia\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancias}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.idBioimpedancia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.pGordura}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.pesoGordura}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.massaMagra}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.pesoOsseo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.pesoMuscular}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.pesoResidual}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.imc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.indicePonderal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.indiceConicidade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bioimpedancia.personal.nomePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                    </c:forEach>\n");
      out.write("                </table>\n");
      out.write("    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.tipoPessoa  eq 'PER'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <h1>Cadastrar bioimpedancia</h1>\n");
      out.write("            <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SalvarBioimpedancia\">\n");
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
      out.write("                        <label for=\"idade\">Idade</label>\n");
      out.write("                        <input type=\"number\" name=\"idade\" id=\"idade\"/><br />\n");
      out.write("                        <label for=\"altura\">Altura</label>\n");
      out.write("                        <input type=\"number\" name=\"altura\" id=\"altura\"/><br />\n");
      out.write("                        <label for=\"peso\">Peso</label>\n");
      out.write("                        <input type=\"number\" name=\"peso\" id=\"peso\"/><br />\n");
      out.write("                        <label for=\"abdominal\">Abdominal</label>\n");
      out.write("                        <input type=\"number\" name=\"abdominal\" id=\"abdominal\"/><br />\n");
      out.write("                        <label for=\"coxa\">Coxa</label>\n");
      out.write("                        <input type=\"number\" name=\"coxa\" id=\"coxa\"/><br />\n");
      out.write("                        <label for=\"peitoral\">Peitoral</label>\n");
      out.write("                        <input type=\"number\" name=\"peitoral\" id=\"peitoral\"/><br />\n");
      out.write("                       \n");
      out.write("                        <label for=\"tipo\">Tipo</label>\n");
      out.write("                        <input type=\"radio\" name=\"tipo\" id=\"7dobras\" value=\"7dobras\"/><label for=\"7dobras\">7dobras</label>\n");
      out.write("                        <input type=\"radio\" name=\"tipo\" id=\"3dobras\" value=\"3dobras\"/><label for=\"3dobras\">3dobras</label>\n");
      out.write("                        <div class=\"7dobras\">\n");
      out.write("                            <label for=\"sexo\">Sexo</label>\n");
      out.write("                        <input type=\"radio\" name=\"sexo\" id=\"f\" value=\"f\"/><label for=\"f\">Feminino</label>\n");
      out.write("                        <input type=\"radio\" name=\"sexo\" id=\"m\" value=\"m\"/><label for=\"m\">Masculino</label>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"triciptal\">triciptal</label>\n");
      out.write("                        <input type=\"number\" name=\"triciptal\" id=\"triciptal\"/><br />\n");
      out.write("                        <label for=\"subescapular\">subescapular</label>\n");
      out.write("                        <input type=\"number\" name=\"subescapular\" id=\"subescapular\"/><br />\n");
      out.write("                        <label for=\"auxiliarMedio\">auxiliar medio</label>\n");
      out.write("                        <input type=\"number\" name=\"auxiliarMedio\" id=\"auxiliarMedio\"/><br />\n");
      out.write("                        <label for=\"suprailiaca\">suprailiaca</label>\n");
      out.write("                        <input type=\"number\" name=\"suprailiaca\" id=\"suprailiaca\"/><br />\n");
      out.write("                        <label for=\"biestiloide\">biestilóide</label>\n");
      out.write("                        <input type=\"number\" name=\"biestiloide\" id=\"biestiloide\"/><br />\n");
      out.write("                        <label for=\"bicondiliano\">bicondiliano</label>\n");
      out.write("                        <input type=\"number\" name=\"bicondiliano\" id=\"bicondiliano\"/><br />\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("                <div>\n");
      out.write("                    <input type=\"submit\" value=\"Enviar\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("    </c:if>\n");
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
}
