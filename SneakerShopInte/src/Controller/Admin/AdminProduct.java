package Controller.Admin;

import Models.DAO.ProductsDAO;
import Models.Entities.Product;
import Models.utilize.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author hoald
 */
@WebServlet(name = "AdminProduct", urlPatterns = {"/admin/AdminProduct"})
@MultipartConfig
public class AdminProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id by request scope
        int id = Integer.parseInt(request.getParameter("pId"));
        //get product by id
        Product productobject = new ProductsDAO().getProduct(id);
        //if can not find product
        if (productobject == null) {
            request.getSession().setAttribute("message", "Product not found");
            response.sendRedirect("../Failed.jsp");
            //if find product
        } else {
            request.setAttribute("product", productobject);
            request.setAttribute("type", "Edit");
            request.getRequestDispatcher("/admin/AddProduct.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get data from jsp
        String name = request.getParameter("ProductName");
        double price = Double.parseDouble(request.getParameter("ProductPrice"));
        String date = LocalDate.now().toString();
        String discription = request.getParameter("ProductDescription");
        int quantity = Integer.parseInt(request.getParameter("ProductQuantity"));
        int weight = Integer.parseInt(request.getParameter("ProductWeight"));
        int category = Integer.parseInt(request.getParameter("category"));
        String image = "";
        
//        --upload img--
        Part filePart = request.getPart("image");
        if(filePart.getSize() != 0){
            String path = request.getServletContext().getRealPath("");
            
            try {
                image = FileUpload.uploadImage(filePart, path);
                
            } catch (Exception e) {
               e.printStackTrace();
               request.getSession().setAttribute("AlertMessage", "Please choose image only");
               request.getSession().setAttribute("AlertType", "Danger");
               response.sendRedirect("AdminProductServlet");
               return;
            }
        }else{
            image = request.getParameter("pImage");
        }
        
//        update product
        if(request.getParameter("id") != null && !request.getParameter("id").trim().equals("")){
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            if(new ProductsDAO().editProduct(id, category, name, price, quantity, weight, image, date, discription)){
                out.print("<script>alert('Update successful')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }else{
                out.print("<script>alert('Update fail')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }
        }
//        upload product        
        else{
            PrintWriter out = response.getWriter();
            if(new ProductsDAO().addProduct(category, name, price, quantity, weight, image, date, discription)){
                out.print("<script>alert('Add successful')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }else{
                out.print("<script>alert('Add fail')</script>");
                out.print("<script>window.location.href='AdminProductServlet'</script>");
                return;
            }
        }
    }
}
