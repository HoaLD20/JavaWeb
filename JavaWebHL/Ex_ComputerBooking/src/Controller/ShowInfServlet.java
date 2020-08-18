package Controller;

import javafx.print.Printer;

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
@WebServlet(name = "ShowInfServlet", urlPatterns = "/ShowInfServlet")
public class ShowInfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter o = response.getWriter();
        o.println("<!Doctype html>");
        o.println("<html>");
        o.println("<title>Product Infor</title>");
        o.println("<h1>Product</h1>");
        o.println("Name:" + request.getParameter("txtProduct"));
        o.println("<br>");
        o.println("Price:" + request.getParameter("txtPrice"));
        o.println("<br>");
        o.println("Quantity:" + request.getParameter("txtQuantity"));
        o.println("<br>");
        if (request.getParameter("Dis").equalsIgnoreCase("Discount")){
            o.println("Total is:" + (Double.parseDouble(request.getParameter("txtPrice")) *
                    Double.parseDouble(request.getParameter("txtQuantity")) * (1 - Double.parseDouble(request.getParameter("txtPerDis")) / 100)));
        }
        else {
            o.println("Total is:" + (Double.parseDouble(request.getParameter("txtPrice")) *
                    Double.parseDouble(request.getParameter("txtQuantity"))));
        }


        o.println("</html>");

    }
}
