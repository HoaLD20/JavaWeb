/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySource;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author root
 */
public class Footer extends SimpleTagSupport {

    private String companyName;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
           

            JspFragment f = getJspBody();
            out.print("<hr/><div align='right'><h4>"+ companyName +"</h4>");
            out.print("<h5>Education Department</h5>");
            out.print("<h6>JSP LAP_2013</h6></div>");
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Footer tag", ex);
        }
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
