package Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Entities.Sliders;
import Models.DAO.SlidersDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author hoald
 */
@WebServlet(name = "SlidersShow", urlPatterns = {"/admin/SlidersShow"})
public class SlidersShow extends HttpServlet {

    ArrayList<Sliders> listOfSlider = new ArrayList<Sliders>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlidersDAO slidersDAO = new SlidersDAO();
        //get all slider from database
        listOfSlider = slidersDAO.getAllSliders();
        //set listOfAttribute of list of slider
        request.setAttribute("listOfSlider", listOfSlider);
        //foword to offers.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/offers.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
