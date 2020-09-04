package Controller.User;

import Models.DAO.SlidersDAO;
import Models.Entities.Sliders;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author hoald
 */
@WebServlet(name = "SliderController", urlPatterns = {"/SliderIndex"})
public class SliderController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Sliders> allSliders = new SlidersDAO().getAllSliders();
        request.setAttribute("slides", allSliders);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
