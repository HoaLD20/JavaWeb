package Controller.Admin;

import Models.DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Models.Entities.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoald
 */
@WebServlet(name = "AdminUserServlet", urlPatterns = {"/admin/AdminUserServlet"})
public class AdminUserServlet extends HttpServlet {
    ArrayList<User> listOfUser = new ArrayList<User>();

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        //get all user from db
        listOfUser = userDAO.getAllUsers();
        //set list of user to attribute
        request.setAttribute("listOfUser", listOfUser);
        //foword to user.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/users.jsp");
        dispatcher.forward(request, response);
    }
}
