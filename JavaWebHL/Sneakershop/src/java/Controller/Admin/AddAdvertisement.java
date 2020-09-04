package Controller.Admin;

import Models.DAO.AdvertisementDAO;
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
@WebServlet(name = "AddAdvertisement", urlPatterns = {"/admin/AddAdvertisement"})
@MultipartConfig
public class AddAdvertisement extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAdvertisement</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAdvertisement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        AdvertisementDAO adsDAO = new AdvertisementDAO();
        //get url request
        String url = request.getParameter("url");
        //get part of image
        Part filePart = request.getPart("image");
        if (filePart.getSize() != 0) {      //if photo uploaded
            String path = request.getServletContext().getRealPath("");

            try {
                //get image to uploadedpath
                String uploadedpath = FileUpload.uploadImage(filePart, path);
                //add to arraylist to add to db
                adsDAO.addAdvertisment(uploadedpath, url);
            } catch (Exception ex) {
                ex.printStackTrace();
                //set alert message
                request.getSession().setAttribute("AlertMessage", "please choose image only");
                //set alert type
                request.getSession().setAttribute("AlertType", "danger");
                response.sendRedirect("ShowAdvertisement");

                return;
            }

        } else {                          //no photo uploaded
            adsDAO.addAdvertisment(request.getParameter("photo"), url);
        }
        //print upload successful
        out.print("<script>alert('Add successful')</script>");
        out.print("<script>window.location.href='ShowAdvertisement'</script>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
