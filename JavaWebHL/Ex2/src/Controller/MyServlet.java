package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author hoald
 */
@WebServlet(name = "MyServlet", urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Read All Header Request</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Data sent from client is " + request.getParameter("txtDemo")+ "</h1>");
        Enumeration list = request.getHeaderNames();
        while (list.hasMoreElements()) {
            String s = list.nextElement().toString();
            out.println("<br>"+s+": <b>"+request.getHeader(s)+"</b>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
