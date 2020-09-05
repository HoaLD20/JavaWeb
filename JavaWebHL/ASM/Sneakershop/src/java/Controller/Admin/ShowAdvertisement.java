package Controller.Admin;

import Models.DAO.AdvertisementDAO;
import Models.Entities.Advertisement;
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
@WebServlet(name = "ShowAdvertisement", urlPatterns = {"/admin/ShowAdvertisement"})
public class ShowAdvertisement extends HttpServlet {

    ArrayList<Advertisement> arr;
    AdvertisementDAO model;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        model = new AdvertisementDAO();
        //get all ads from database
        arr = model.getAllAdvertisement();
        //set all ads to attribute
        request.setAttribute("allAdsAdmin", arr);
        String nextJSP = "/admin/ads.jsp";
        //and foword to ads.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
