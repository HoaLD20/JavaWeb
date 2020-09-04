package Controller.User;

import Models.DAO.CartsDAO;
import Models.Entities.Cart;
import Models.Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hoald
 */
@WebServlet(name = "/addCart")
public class AddCart extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartsDAO cartsDAO = new CartsDAO();
        
        int pId = Integer.parseInt(request.getParameter("productID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        User user = (User)request.getSession().getAttribute("LoginUser");
        
        Cart cart = new Cart();
        cart.setpId(pId);
        cart.setCartQuantity(quantity);
        cart.setuId(user.getuId());

        if(cartsDAO.addCart(cart)) {
            response.getWriter().print(cartsDAO.getNumberOfCartsForUser(user.getuId()));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
