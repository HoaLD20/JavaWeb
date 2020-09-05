package Controller.User;

import Models.DAO.CartsDAO;
import Models.Entities.CartProduct;
import Models.Entities.User;
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
 * @author hoald
 */
@WebServlet(name = "CartHandlerServlet", urlPatterns = {"/CartHandlerServlet"})
public class CartHandlerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<CartProduct> carts = new ArrayList<CartProduct>(); //create a arraylist
        User user = (User)request.getSession().getAttribute("LoginUser"); //get id from session
        int userId = user.getuId(); //get id of user
        CartsDAO cartsDAO = new CartsDAO(); //creates a new object CartsDAO
        carts = cartsDAO.getProductFromCart(userId); //get object in cart db of user to display in checkout page
        
        request.setAttribute("carts", carts);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkout.jsp"); //move to checkout.jsp
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
