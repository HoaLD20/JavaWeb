package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @author hoald
 */
@WebServlet(name = "UploadfieServlet", urlPatterns = "/UploadServlet")
@MultipartConfig(fileSizeThreshold = 100, maxFileSize = 400, maxRequestSize = 50, location = "/Pictures")
public class UploadfieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter o = response.getWriter();
//        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
//        if(!isMultipartContent){
//            o.println("No File Uploaded<br>");
//            return;
//        }
//        o.println("You are trying to upload:<br>");
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            List<FileItemp> it = upload.parseRequest(request);
//            o.println("Number of fields: " + fields.size() + "<br> <br>");
//            Iterator<FileItemp> it = fields.iterator();
//            if(!it.hasNext()){
//                o.println("No fields found!");
//                return;
//            }
//            while (it.hasNext()){
//                FileItem = (FileItem)it.next();
//                boolean isFormField = fileItem.isFormField();
//                if(!isFormField){
//                    String fileName = fileItem.getName();
//                    File = new File(fileName);
//                    fileItem.write(file);
//                    o.println("Uploaded file name: " + fileName + "<br>");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
