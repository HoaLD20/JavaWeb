package Controller.Admin;

import Models.DAO.ChargeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoald
 */
@WebServlet(name = "ChargeServlet", urlPatterns = {"/admin/ChargeServlet"})
public class ChargeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChargeDAO chargeDAO = new ChargeDAO();
        PrintWriter out = response.getWriter();
        //increate card with 50
        int SumCard50 = chargeDAO.getSumCardNumber(50000);
        //set attribute is new card 50
        request.setAttribute("SumCard50", SumCard50);
        //incraete card with 100
        int SumCard100 = chargeDAO.getSumCardNumber(100000);
        //set attrubute is new card 100
        request.setAttribute("SumCard100", SumCard100);
        //increate card with 200
        int SumCard200 = chargeDAO.getSumCardNumber(200000);
        //set attribute is new card 200
        request.setAttribute("SumCard200", SumCard200);
        //increate card with 500
        int SumCard500 = chargeDAO.getSumCardNumber(500000);
        //set attribute with new card 500
        request.setAttribute("SumCard500", SumCard500);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
}
