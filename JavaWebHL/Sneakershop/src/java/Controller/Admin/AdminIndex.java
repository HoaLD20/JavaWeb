package Controller.Admin;

import Models.DAO.ChargeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoald
 */
@WebServlet(name = "AdminIndex", urlPatterns = {"/AdminIndex"})
public class AdminIndex extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get all user online
        request.setAttribute("onlineUser", SessionHandler.getOnlineUsers());
        //get current profit
        request.setAttribute("profit", new ChargeDAO().getProfit());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
