package Controller.Admin;

import Models.DAO.SlidersDAO;
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
@WebServlet(name = "DeleteSlider", urlPatterns = {"/admin/DeleteSlider"})
public class DeleteSlider extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //create string writer
        PrintWriter out = response.getWriter();
        SlidersDAO slidersDAO = new SlidersDAO();
        //get id from request jsp
        int id = Integer.parseInt(request.getParameter("id"));
        //get return boolean of delete 
        boolean deleteSlider = slidersDAO.deleteSlider(id);
        //if delete true will alert delete successful
        if (deleteSlider) {
            out.print("<script>alert('Delete successful')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
        //if false will alert delete fail   
        } else {
            out.print("<script>alert('Delete fail')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
           
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
