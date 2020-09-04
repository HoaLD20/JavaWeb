package Controller.Admin;

import Models.DAO.HistoryDAO;
import Models.Entities.History;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AdminHistoryServlet", urlPatterns = {"/admin/AdminHistoryServlet"})
public class AdminHistoryServlet extends HttpServlet {

    ArrayList<History> listOfHistorys = new ArrayList<History>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HistoryDAO historyDAO = new HistoryDAO();
        try {
            //get all history
            listOfHistorys = historyDAO.getAllHistory();
            //set all history to atttribute
            request.setAttribute("listOfHistorys", listOfHistorys);
            //forword to history.jsp
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/history.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
