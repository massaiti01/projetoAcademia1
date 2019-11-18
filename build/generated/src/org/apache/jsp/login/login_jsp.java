package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>ENTRAR </title>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../dashboard/csss.jsp", out, false);
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"bg-dark\">\n");
      out.write("\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"card card-login mx-auto mt-5\">\n");
      out.write("         <div class=\"logo\">\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/index.jsp\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/view/assets/img/LOGO_1.png\" id=\"logotipo\" alt=\"Logo Data projects\"/><span id=\"logotipoletra\">Data</span> <span id=\"logotipoletra2\">Projects</span></a>\n");
      out.write("            </div>\n");
      out.write("      <div class=\"card-header\">Acessar Sistema</div>\n");
      out.write("      <div class=\"card-body\">\n");
      out.write("        <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/LogarPessoa\">\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <div class=\"form-label-group\">\n");
      out.write("              <input type=\"text\" id=\"login\" name=\"login\" class=\"form-control\" placeholder=\"Nome de Usuário\" required=\"required\" autofocus=\"autofocus\">\n");
      out.write("              <label for=\"login\">Nome de Usuário</label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <div class=\"form-label-group\">\n");
      out.write("              <input type=\"password\" id=\"senha\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\" required=\"required\">\n");
      out.write("              <label for=\"senha\">Senha</label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <div class=\"checkbox\">\n");
      out.write("              <label>\n");
      out.write("                <input type=\"checkbox\" value=\"remember-me\">\n");
      out.write("                Lembrar Senha\n");
      out.write("              </label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <input type=\"hidden\" name=\"acao\" value=\"logar\">\n");
      out.write("          <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Entrar\">\n");
      out.write("        </form>\n");
      out.write("        <div class=\"text-center\">\n");
      out.write("          <a class=\"d-block small mt-3\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/academia/salvar.jsp\">Cadastre-se</a>\n");
      out.write("          <a class=\"d-block small\" href=\"forgot-password.html\">Esqueceu sua Senha?</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core JavaScript-->\n");
      out.write("  <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Core plugin JavaScript-->\n");
      out.write("  <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../dashboard/javascripts.jsp", out, false);
      out.write("\n");
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
