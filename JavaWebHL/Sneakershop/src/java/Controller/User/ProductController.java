package Controller.User;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("id")); //get parameter product id
        ProductsDAO pDAO = new ProductsDAO(); //creates a new object ProductsDAO
        Product product = pDAO.getProduct(productID); //get product by id
        
        //no product with this id
        if(product == null) {
            response.sendRedirect("404.jsp");
        } else {
            //assign it on request
            request.setAttribute("product", product);
            //get recommended product
            ArrayList<Product> recommendedItem = pDAO.getRecommendedItem(product.getcId(), productID);
            request.setAttribute("recomed", recommendedItem);
            
            request.getRequestDispatcher("/product-details.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
