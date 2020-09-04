package Controller.Admin;

import Models.DAO.ProductsDAO;
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
@WebServlet(name = "DeleteProduct", urlPatterns = {"/admin/DeleteProduct"})
public class DeleteProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id from request jsp
        int id = Integer.parseInt(request.getParameter("pId"));
        String path = request.getServletContext().getRealPath("");
        //delete product with id and path of image
        //if delete success will show again in adminproductservlet
        if(new ProductsDAO().deleteProduct(id, path)){
            request.getSession().setAttribute("AlertMessage", "Product Delete Successfully");
            request.getSession().setAttribute("AlertType", "Success");
            response.sendRedirect("AdminProductServlet");
        }else{
            request.getSession().setAttribute("AlertMessage", "Can not Delete Product");
            request.getSession().setAttribute("AlertType", "Fail");
            response.sendRedirect("AdminProductServlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
