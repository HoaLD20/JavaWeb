package Controller;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Servlet2", urlPatterns = "/Servlet2")

public class Servlet2 extends HttpServlet {
    public static int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
        out.println("<h1>Content from servlet 2</h1>");
        RequestDispatcher re = request.getRequestDispatcher("index.jsp");
        re.include(request, response);
        out.print("<br/>This is initial value from web server for company name:  " + getServletContext().getInitParameter("CompanyName"));
        out.print("<br/>This is number of user request form 1 servlet: " + Servlet2.count++);
        getServletContext().setAttribute("Count", Servlet2.count );
        out.print("\n"+ "Cai nay la cai attribute ten count: " + getServletContext().getAttribute("Count"));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
        out.println("<h1>Content from servlet 2</h1>");
        RequestDispatcher re = request.getRequestDispatcher("index.jsp");
        re.include(request, response);
        out.print("<br/>This is initial value from web server for company name:  " + getServletContext().getInitParameter("CompanyName"));
        out.print("<br/>This is number of user request form 1 servlet: " + Servlet2.count++);
        getServletContext().setAttribute("Count", Servlet2.count);
        out.print("\n Cai nay la cai attribute ten count: " + getServletContext().getAttribute("Count"));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public String getServletInfo() {
        return "Short description";
    }
}
