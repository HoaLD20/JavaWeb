package Controller.User;

import Models.DAO.AdvertisementDAO;
import Models.DAO.ProductsDAO;
import Models.Entities.Advertisement;
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
@WebServlet(name = "AdsController", urlPatterns = {"/AdsController"})
public class AdsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("maxPrice", (int)(new ProductsDAO().getMaxProductByPrice())); //get product have HighestPrice
        Advertisement randomAds = new AdvertisementDAO().getRandomAds(); //get new random to display ads
        if(randomAds != null) { //if have random ads
            request.setAttribute("ads", randomAds); //then set request attribute
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
