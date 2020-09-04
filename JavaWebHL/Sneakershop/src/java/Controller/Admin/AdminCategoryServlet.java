package Controller.Admin;

import Models.DAO.CategoryDAO;
import Models.Entities.Category;
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
@WebServlet(name = "AdminCategoryServlet", urlPatterns = {"/admin/AdminCategoryServlet"})
public class AdminCategoryServlet extends HttpServlet {
    ArrayList<Category> listOfCategory = new ArrayList<Category>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        //get all category from db
        listOfCategory = categoryDAO.allCategoriess();
        //set all category to attribute
        request.setAttribute("listOfCategory", listOfCategory);
        //forword to categry.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/category.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
