package Controller.Admin;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
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
@WebServlet(name = "AdminProductServlet", urlPatterns = {"/admin/AdminProductServlet"})
public class AdminProductServlet extends HttpServlet {

    ArrayList<Product> listOfProducts = new ArrayList<Product>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductsDAO productsDAO = new ProductsDAO();
        //get all product from db
        listOfProducts = productsDAO.getAllProducts();
        //set attribute to list of product
        request.setAttribute("listOfProducts", listOfProducts);
        //forword to products.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/Products.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
