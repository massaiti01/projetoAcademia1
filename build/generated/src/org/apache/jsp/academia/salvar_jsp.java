package org.apache.jsp.academia;

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
      out.write("        <div class=\"col-md-6\">\n");
      out.write("       <h1>Cadastrar Academia</h1>\n");
      out.write("        <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SalvarAcademia\">\n");
      out.write("            \n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"idPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.idPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            <label for=\"nomePessoa\">Nome:</label>\n");
      out.write("            <input type=\"text\" name=\"nomePessoa\" id=\"nomePessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.nomePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("            \n");
      out.write("             <label for=\"cnpjAcademia\">CNPJ</label>\n");
      out.write("            <input type=\"text\" name=\"cnpjAcademia\" id=\"cnpjAcademia\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.cnpjAcademia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("            \n");
      out.write("            <label for=\"telefonePessoa\">Telefone:</label>\n");
      out.write("            <input type=\"text\" name=\"telefonePessoa\" id=\"telefonePessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.telefonePessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("            \n");
      out.write("            <label for=\"loginPessoa\">Login:</label>\n");
      out.write("            <input type=\"text\" name=\"loginPessoa\" id=\"loginPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.loginPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("            \n");
      out.write("            <label for=\"senhaPessoa\">Senha</label>\n");
      out.write("            <input type=\"password\" name=\"senhaPessoa\" id=\"senhaPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${academia.senhaPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"enviar\">\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
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
