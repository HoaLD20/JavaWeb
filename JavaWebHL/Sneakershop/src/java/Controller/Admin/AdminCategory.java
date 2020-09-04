package Controller.Admin;

import Models.DAO.CategoryDAO;
import Models.Entities.Category;
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
@WebServlet(name = "AdminCategory", urlPatterns = {"/admin/AdminCategory"})
public class AdminCategory extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get name from request
        String name = request.getParameter("CategoryName");
        
        Category category = new Category();
        category.setcName(name);
        PrintWriter out = response.getWriter();
        //if add successfull alert successful
        if(new CategoryDAO().addCategory(category)){
            out.print("<script>alert('Add successful')</script>");
            out.print("<script>window.location.href='AdminCategoryServlet'</script>");
            //if ot alert error
        }else{
            out.print("<script>alert('Add fail')</script>");
            out.print("<script>window.location.href='AdminCategoryServlet'</script>");
        }
    }
}
