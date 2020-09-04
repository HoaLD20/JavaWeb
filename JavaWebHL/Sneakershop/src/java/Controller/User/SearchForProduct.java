package Controller.User;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
public class SearchForProduct extends HttpServlet {

    ArrayList<Product> products = new ArrayList<>();
    ProductsDAO pDAO = new ProductsDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("search") != null) {
            String productName = request.getParameter("search");

            System.out.println(productName);

            products = pDAO.getProductByName(productName);  //get product by name when user use search
            System.out.println(products.size());
        } else {
            System.out.println("else");
            int min = Integer.parseInt(request.getParameter("down"));
            System.out.println(min);
            int max = Integer.parseInt(request.getParameter("up"));
            System.out.println(max);

            products = pDAO.getAllProductByPrice(min, max); //get all product by price from min to max
            System.out.println("sizeof product" + products.size());
        }

        request.setAttribute("allProducts", products);
        //redirect to shop
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("./shop.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
