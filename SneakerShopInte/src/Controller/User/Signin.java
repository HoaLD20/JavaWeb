package Controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Entities.User;
import Models.DAO.UserDAO;

/**
 * @author hoald
 */
@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get User Name and password when Customer inptut
        String username = request.getParameter("SigninName");
        String password = request.getParameter("SigninPassword");
        UserDAO us = new UserDAO(); // constructor User
        User user = new User();
        user = us.signIn(username, password); // call funtion to sinup
        // if null it mean user not have exist and sendirect failed.jsp
        if (user == null) {
            //TODO : MAKE forget password
            request.setAttribute("message", "Cant't Login <br/> Wrong username or password .. ");
            getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
        } else {
            //set session for login user
            HttpSession session = request.getSession(true);
            session.setAttribute("LoginUser", user);
//            session.setMaxInactiveInterval(60*15);

            if (user.getuRole().equalsIgnoreCase("admin")) {
//                System.out.println("admin dang nhap ne hihi");
                response.sendRedirect("admin/Index.jsp");   //admin
            } else {
//                System.out.println("ko phai admin nha");
                response.sendRedirect("index.jsp");
            }
        }
    }
}
