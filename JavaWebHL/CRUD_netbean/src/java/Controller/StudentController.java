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
                if (page.compareTo("edit") == 0) {
                    String id = request.getParameter("id");
                    Student student = stdao.getStudentInfo(id);
                    if (student != null) {
                        getServletContext().setAttribute("userinfo", student);
                        dispatcher = request.getRequestDispatcher("update.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect("StudentController");
                    }

                }
                if(page.compareTo("delete") == 0){
                    String id = request.getParameter("id");
                    stdao.deleteUser(id);
                    response.sendRedirect("StudentController");
                }
            } else {
                ResultSet rs = (ResultSet) stdao.getStudent();
                getServletContext().setAttribute("studentList", rs);

                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("error doget");
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
                    response.sendRedirect("StudentController");
//                    RequestDispatcher dispatcher;
//                    dispatcher = request.getRequestDispatcher("index.jsp");
                } else {
                    response.sendRedirect("StudentController");
//                    System.out.println("ngu ne ahihi");
//                    RequestDispatcher dispatcher;
//                    dispatcher = request.getRequestDispatcher("index.jsp");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (request.getParameter("updatesubmit") != null) {
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
                int i = sd.updateStudent(student);
                if (i > 0) {
                    response.sendRedirect("StudentController");
//                    RequestDispatcher dispatcher;
//                    dispatcher = request.getRequestDispatcher("index.jsp");
//                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("StudentController");
//                    System.out.println("ngu ne ahihi");
//                    RequestDispatcher dispatcher;
//                    dispatcher = request.getRequestDispatcher("index.jsp");
//                    dispatcher.forward(request, response);
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
