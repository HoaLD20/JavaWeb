package Controller.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hoald
 */
@WebServlet(name = "ConFirmCodeServlet", urlPatterns = {"/ConFirmCodeServlet"})
public class ConFirmCodeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CodeGetPass = request.getSession().getAttribute("CodeGetPass").toString();
        String CodeInput = request.getParameter("ForgetName");
        if (CodeGetPass.equals(CodeInput)) {
            response.sendRedirect("AddNewPass.jsp");
        } else {
            request.setAttribute("message", "Error! Your code is not match");
            getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
        }
    }
}
