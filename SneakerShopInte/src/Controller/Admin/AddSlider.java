package Controller.Admin;

import Models.DAO.ProductsDAO;
import Models.DAO.SlidersDAO;
import Models.Entities.Product;
import Models.Entities.Sliders;
import Models.utilize.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddSlider", urlPatterns = {"/admin/AddSlider"})
@MultipartConfig
public class AddSlider extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get id from request
        int pId = Integer.parseInt(request.getParameter("pId"));
        //get product by id
        Product product = new ProductsDAO().getProduct(pId);
        //if can not find product
        if(product == null){
            request.getSession().setAttribute("message", "Product not found");
            response.sendRedirect("../Failed.jsp");
            //if file product
        }else{
            //set product by attribute request scope
            request.setAttribute("product", product);
            //forword to addslider.jsp
            request.getRequestDispatcher("/admin/AddSlider.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlidersDAO sliderDAO = new SlidersDAO();
        //get info from jsp
        String title = request.getParameter("tittle");
        String subtitle = request.getParameter("subTittle");
        String desc = request.getParameter("ProductDescription");
        int pId = Integer.parseInt(request.getParameter("id"));

        Sliders slider = new Sliders();
        slider.setsDescription(desc);
        slider.setsTitle(title);
        slider.setsSubtitle(subtitle);
        slider.setpId(pId);
        
//        --upload img--
        //get file part
        Part filePart = request.getPart("image");
        if (filePart.getSize() != 0) {      //if photo uploaded
            String path = request.getServletContext().getRealPath("");

            try {
                //get image from jsp
                String uploadedpath = FileUpload.uploadImage(filePart, path);
                slider.setsImage(uploadedpath);
            } catch (Exception ex) {
                ex.printStackTrace();
                request.getSession().setAttribute("AlertMessage", "please choose image only");
                request.getSession().setAttribute("AlertType", "Danger");
                response.sendRedirect("SlidersShow");
                return;
            }

        } else {                          //no photo uploaded
            slider.setsImage(request.getParameter("pImage"));
        }
        
//        --add slider-- 
        PrintWriter out = response.getWriter();
        //add to db if true will print successful
        if(new SlidersDAO().addSlider(slider)){
            out.print("<script>alert('Add successful')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
            //if not print fail
        }else{
            out.print("<script>alert('Add fail')</script>");
            out.print("<script>window.location.href='SlidersShow'</script>");
        }
    }
}
