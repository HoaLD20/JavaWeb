package Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * @author hoald
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
@MultipartConfig(fileSizeThreshold = 100, maxFileSize = 400, maxRequestSize = 50, location = "/Pictures")
public class UploadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter o = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if(!isMultipartContent){
            o.println("No File Uploaded<br>");
            return;
        }
        o.println("You are trying to upload:<br>");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fields = upload.parseRequest(request);
            o.println("Number of fields: " + fields.size() + "<br> <br>");
            Iterator<FileItem> it = fields.iterator();
            if(!it.hasNext()){
                o.println("No fields found!");
                return;
            }
            while (it.hasNext()){
                FileItem fileItem= it.next();
                boolean isFormField = fileItem.isFormField();
                if(!isFormField){
                    String fileName = fileItem.getName();
                    File file = new File(fileName);
                    fileItem.write(file);
                    o.println("Uploaded file name: " + fileName + "<br>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
