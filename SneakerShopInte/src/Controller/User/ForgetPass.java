package Controller.User;

import Models.DAO.UserDAO;
import Models.Entities.User;
import Models.utilize.MailModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hoald
 */
@WebServlet(name = "ForgetPass", urlPatterns = {"/ForgetPass"})
public class ForgetPass extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("ForgetName");
        UserDAO us = new UserDAO();
        User user = new User();
        user = us.TakeNameForget(username);
        String CodeGetPass = getCodeConfirm(6);
           if(user == null ){
               //TODO : MAKE forget password
               request.setAttribute("message", "Cant't Found UserName !!!");
               getServletContext().getRequestDispatcher("/Failed.jsp").forward(request, response);
           } else {
               
                request.setAttribute("ShowComfirm", true);
                request.setAttribute("message", "Please Check Email to Comfirm Code!!!");
                HttpSession session = request.getSession();
                session.setAttribute("CodeGetPass", CodeGetPass);
                session.setAttribute("userNameForget",username);
                String mail = "The code to get the password is:  " + CodeGetPass;
                 new MailModel(user.getuEmail(), "Your Code", mail).sendMail();
                    
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success2.jsp");
                    dispatcher.forward(request, response);                //user
           }
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
    private String getCodeConfirm(int numSize) {
        Random rand = new Random();
        StringBuffer number = new StringBuffer();

        while (number.length() < numSize) {
            // Generates a random number between 0x10 and 0x99
            int myRandomNumber = rand.nextInt(0x99) + 0x10;
            number.append(Integer.toHexString(myRandomNumber));
        }

        return number.toString();
    }
}
