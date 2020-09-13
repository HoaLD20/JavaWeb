package Controller.User;

import Models.DAO.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
@WebServlet(name = "UpdateNewPass", urlPatterns = {"/UpdateNewPass"})
public class UpdateNewPass extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String passWord = request.getParameter("NewPassword");
        String Usenname = request.getSession().getAttribute("userNameForget").toString();
        UserDAO us = new UserDAO();
        boolean t = us.UpdatePass(Usenname, passWord);
        if (t) {
            request.setAttribute("message", "Update Success!!!");
            getServletContext().getRequestDispatcher("/Success2.jsp").forward(request, response);

        } else {
            request.setAttribute("message", "Error! Your code is not match!");
            getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
        }
    }

}
