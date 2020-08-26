package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html><html><head><meta  http-equiv=\"Content-Type\"  content=\"text/html;  charset=UTF-8\">\n");
      out.write("        <style>h1{color: yellowgreen;font-style: italic;}   \n");
      out.write("            div{margin-left: auto;margin-right: auto;width: 300px;}\n");
      out.write("            input[type=text]\n");
      out.write("            {width:150px;\n");
      out.write("             text-align:left;\n");
      out.write("             border:thin solid gray;\n");
      out.write("             padding: 2px 5px 2px 5px;\n");
      out.write("             border-radius: 3px 3px 3px 3px;}\n");
      out.write("            input[type=submit]\n");
      out.write("            {width:75px;\n");
      out.write("             text-align:center;\n");
      out.write("             border:thin solid gray;\n");
      out.write("             padding: 3px 5px 3px 5px;\n");
      out.write("             border-radius: 3px 3px 3px 3px;\n");
      out.write("             background-color: orange;}\n");
      out.write("            input[type=submit]\n");
      out.write("            :hover{width:75px;\n");
      out.write("                   text-align:center;\n");
      out.write("                   border:thin solid gray;\n");
      out.write("                   padding: 3px 5px 3px 5px;\n");
      out.write("                   border-radius: 3px 3px 3px 3px;\n");
      out.write("                   background-color: yellowgreen;}\n");
      out.write("        </style>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <h1>Shopping card demo</h1>\n");
      out.write("            ");
if (request.getParameter("btnOK") != null) {
                    codes.item item = new codes.item();
                    item.setId(Integer.parseInt(request.getParameter("txtID")));
                    item.setPrice(Integer.parseInt(request.getParameter("txtPrice")));
                    item.setQuantity(Integer.parseInt(request.getParameter("txtQuantity")));
                    java.util.ArrayList orders = new ArrayList();
                    if (session.getAttribute("Orders") != null) {
                        orders = ((java.util.ArrayList) session.getAttribute("Orders"));
                    }
                    orders.add(item);
                    session.setAttribute("Orders", orders);
                    response.sendRedirect("cart.jsp");
                }
      out.write("\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtID\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>                    \n");
      out.write("                        <td>Price</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtPrice\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>                \n");
      out.write("                        <td>Quantity</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtQuantity\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>          \n");
      out.write("                        <td><input type=\"submit\"value=\"OK\" name=\"btnOK\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
