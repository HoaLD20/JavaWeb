package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hoald
 */
@WebServlet(name = "AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentication</title>");
            out.println("</head>");
        } catch (
                Exception ex) {
            System.out.print(ex.toString());
            out.close();
        }
        out.println("<body>");
        out.println("<h1>Servlet     Authentication     at     " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        if (request.getParameter("txtUser").equalsIgnoreCase("admin")) {
            request.getSession().setAttribute("login", "admin");
            if (request.getParameter("returnURL") != null) {
                response.sendRedirect(request.getParameter("returnURL") + "");
            } else {
                response.sendRedirect("../index.jsp");
            }
        } else {
            request.getRequestDispatcher("../login.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
