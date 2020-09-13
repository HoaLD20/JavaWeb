package Controller.User;

import Models.DAO.CartsDAO;
import Models.DAO.PaysDAO;
import Models.Entities.CartProduct;
import Models.Entities.User;
import Models.utilize.MailModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hoald
 */
@WebServlet(name = "PayController", urlPatterns = {"/PayController"})
public class PayController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartsDAO cartsDAO = new CartsDAO(); //create a new object of CartsDAO
        double total  = 0;
        String message = "";
        
        //get user from session
        User user = (User)request.getSession().getAttribute("LoginUser");
        
        //get product of user
        ArrayList<CartProduct> productCart = cartsDAO.getProductFromCart(user.getuId());
        
        
        //check quantity
        for (CartProduct cart : productCart) {
            total = cart.getpPrice() * cart.getCartQuantity();
            
            //number of order greater than available
            if(cart.getCartQuantity() > cart.getpQuantity()) {
                message += "* you order" + cart.getCartQuantity() + " of product" + cart.getpId()
                        + " which we have only " + cart.getpQuantity() + " pice <br/>";
            }
        }
        
        //check money
        if(total > user.getuCash()) {
            message += " * Your cash less than total require please charge your cash<br/>";
             request.getSession().setAttribute("message", message);
            response.sendRedirect("Failed.jsp");
            return;
        }
        
        //an error occure
        if(!message.trim().equals("")) {
            request.getSession().setAttribute("message", message);
            response.sendRedirect("Failed.jsp");
            return;
        }
        
        //-------------- Payment proccess ------------------
        
        //reduce balance in user
        user.setuCash(user.getuCash() - total);
        
        //call transaction
        if(new PaysDAO().startPayment(user, productCart)) {
            //send mail of success
            message = "Thanks for buying from Sneaker Shop ^_^ <br/>"
                    + "your product will delivered in two days ..";
            
            new MailModel(user.getuEmail(), "Successfull Payment", message).sendMail();
            HttpSession session =  request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("Success.jsp");
        } else { //if have error in process then show message and move to Failed.jsp
            request.getSession().setAttribute("message", "Error in proccess please try agine later :( "); 
            response.sendRedirect("Failed.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
