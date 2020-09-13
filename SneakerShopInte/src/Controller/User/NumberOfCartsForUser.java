package Controller.User;

import Models.DAO.CartsDAO;
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
@WebServlet("/getCartCount")
public class NumberOfCartsForUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CartsDAO cartsDAO = new CartsDAO(); //creates a new object of CartsDAO
        int id = Integer.parseInt(request.getParameter("id")); //get parameter of id
        int addCart = cartsDAO.getNumberOfCartsForUser(id);  //get number of product in user cart
        response.getWriter().print(addCart); //print number of product in user cart
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
