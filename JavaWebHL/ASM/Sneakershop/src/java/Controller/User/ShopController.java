package Controller.User;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
@WebServlet(name = "ShopController", urlPatterns = {"/ShopController"})
public class ShopController extends HttpServlet {

    List<Product> allProducts = new ArrayList<Product>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductsDAO pDAO = new ProductsDAO();
        int pageid = 1;
        int totalPerPage = 9; //1 page only 9 product
        int start;
        
        if(request.getParameter("page") != null) {
            pageid = Integer.parseInt(request.getParameter("page"));
        }
        
        //end & start for paging
        start = (pageid - 1) * totalPerPage;
        //if category
        if(request.getParameter("cate") != null) {
            int cate = Integer.parseInt(request.getParameter("cate"));
            allProducts = pDAO.getAllProductByCategoryId(cate, start, totalPerPage); //get all product by id of category with 1 to 9 product
        } else {
            allProducts = pDAO.getAllProducts(start, totalPerPage); //get all product from 1 to 9 product
        }
        
        int noOfRecords = pDAO.getNoOfRecords(); //get no of records
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / totalPerPage); //cal no of pages
        
        request.setAttribute("allProducts", allProducts);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", pageid);
        request.setAttribute("query", request.getParameter("cate"));
        
        //redirect to shop
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
