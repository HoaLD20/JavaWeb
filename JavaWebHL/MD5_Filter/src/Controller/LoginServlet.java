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
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter o = response.getWriter();
        String name = request.getParameter("txtname");
        String pass = request.getParameter("txtpassword");
        if (name.equals("hoa") && pass.equals("123")){
            o.println("<h1>ahihi dung gui</h1>");
            o.println("pass ne: " + request.getAttribute("pass"));
        }
        else {
            o.println("ngu wa");
        }
    }
}
