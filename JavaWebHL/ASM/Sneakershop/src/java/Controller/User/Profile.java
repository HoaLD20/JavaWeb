package Controller.User;

import Models.DAO.UserDAO;
import Models.Entities.User;
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
 * @author hoald
 */
@MultipartConfig
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //get id from session
            User user = (User)request.getSession().getAttribute("LoginUser");
            
            User newUser = (User)user.clone();
            String path = request.getServletContext().getRealPath("");
            //get request paramater & update object user
            newUser.setuName(request.getParameter("username"));
            newUser.setuEmail(request.getParameter("email"));
            newUser.setuPassword(request.getParameter("password"));
            newUser.setuAddress(request.getParameter("address"));
            newUser.setuJob(request.getParameter("job"));
            newUser.setuCreditCard(request.getParameter("creditcard"));
            
            //-------------- upload photo ------------------
            Part filePart = request.getPart("image");
            if(filePart.getSize() != 0) { //if photo uploaded
                try {
                    String uploadedPath = FileUpload.uploadImage(filePart, path); 
                    newUser.setuPhoto(uploadedPath); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                    request.setAttribute("message", "please choose image only");
                    request.getRequestDispatcher("/Failed.jsp").forward(request, response);
                    return;
                }
                
            }
            if(new UserDAO().updateUser(newUser, path)) {
                //upload user successfully
                newUser.setuPassword(""); //remove password from object
                request.getSession().setAttribute("LoginUser", newUser); //update session user
                
                //redirect to profile
                request.setAttribute("mesageInfo", "Update user info successfully!");
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                //can't update user
                request.setAttribute("message", "Can't update user now... <br/>"
                        + "email or credit card used before");
                request.getRequestDispatcher("/Failed.jsp").forward(request, response);
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }
}
