package Controller.User;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
@WebServlet(name = "IndexProductServlet", urlPatterns = {"/IndexProductServlet"})
public class IndexProductServlet extends HttpServlet {
    List<Product> limitedProducts = new ArrayList<Product>(); //creates a list of product

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductsDAO pDAO = new ProductsDAO(); //creates new object of ProductsDAO
        limitedProducts = pDAO.getLastProducts(); //get latest product to display
        
        request.setAttribute("limitedProducts", limitedProducts);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
