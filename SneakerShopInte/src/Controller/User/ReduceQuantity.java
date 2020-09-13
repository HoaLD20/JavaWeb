package Controller.User;

import Models.DAO.CartsDAO;
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
@WebServlet(name = "ReduceQuantity", urlPatterns = {"/ReduceQuantity"})
public class ReduceQuantity extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartsDAO cartsDAO = new CartsDAO(); //Creates a new object for CartsDAO
        int id = Integer.parseInt(request.getParameter("id")); //get parameter of id
        
        boolean reduceCart = cartsDAO.reduceQuantity(id); //Reduce cart from user cart in DB
        
        User user = (User)request.getSession().getAttribute("LoginUser"); //get id from session
        response.getWriter().print(cartsDAO.getNumberOfCartsForUser(user.getuId())); //and then display cart of user after reduce
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
