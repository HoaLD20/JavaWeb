/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.StudentDao;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class StudentController extends HttpServlet {

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
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
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
        try {
            RequestDispatcher dispatcher;
            StudentDao stdao = new StudentDao();
            if (request.getParameter("page") != null) {

                String page = request.getParameter("page");

                if (page.compareTo("") == 0 || page.compareTo("index") == 0) {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
                if (page.compareTo("add") == 0) {
                    dispatcher = request.getRequestDispatcher("addnew.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                ResultSet rs = (ResultSet) stdao.getStudent();
                getServletContext().setAttribute("studentList", rs);

                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

//            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            System.out.println("error doget");
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        if (request.getParameter("btnsubmit") != null) {
            Student student = new Student();
            student.setUsername(request.getParameter("txtusername"));
            student.setPassword(request.getParameter("txtpassword"));
            student.setFullname(request.getParameter("txtfullname"));
            student.setGender(request.getParameter("txtgender"));
            student.setBirthday(request.getParameter("txtbirthday"));
            student.setEmail(request.getParameter("txtemail"));
            student.setAddress(request.getParameter("txtaddress"));

            try {
                StudentDao sd = new StudentDao();
                int i = sd.addStudent(student);
                if (i > 0) {
                    RequestDispatcher dispatcher;
                    dispatcher = request.getRequestDispatcher("index.jsp");
                } else {
                    System.out.println("ngu ne ahihi");
                    RequestDispatcher dispatcher;
                    dispatcher = request.getRequestDispatcher("index.jsp");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }

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

}
