//package Controller.Admin;
//
//import Models.DAO.AdvertisementDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author hoald
// */
//@WebServlet(name = "DeleteAdvertisement", urlPatterns = {"/admin/DeleteAdvertisement"})
//public class DeleteAdvertisement extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        //get id from jsp
//        int id = Integer.parseInt(request.getParameter("id"));
//        AdvertisementDAO adsDAO = new AdvertisementDAO();
//        //use deleteADs with id. if true will alert delete successful
//        if (adsDAO.deleteAdvertisment(id)) {
//            out.print("<script>alert('Delete successful')</script>");
//            out.print("<script>window.location.href='ShowAdvertisement'</script>");
//            //if not will alert delete fail
//        } else {
//           out.print("<script>alert('Delete fail')</script>");
//            out.print("<script>window.location.href='ShowAdvertisement'</script>");
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    }
//
//}
