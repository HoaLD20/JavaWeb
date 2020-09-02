/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import static javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import static javax.servlet.jsp.tagext.Tag.SKIP_PAGE;

/**
 *
 * @author root
 */
public class employee extends BodyTagSupport {

  public employee() {
        super();
    }

    private void otherDoStartTagOperations() {

    }

    private void otherDoEndTagOperations() {
    }

    private void writeTagBodyContent(JspWriter out, BodyContent bodyContent) throws IOException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jsp", "root", "");
            PreparedStatement ps = conn.prepareStatement(bodyContent.getString());
           ResultSet result = ps.executeQuery();
            ResultSetMetaData meta = result.getMetaData();

            out.print("<table border='1px'><tr bgcolor='#ACE999'>");
            int count = 1;
            while (count <= meta.getColumnCount()) {
                out.print("<td>" + meta.getColumnName(count) + "</td>");
                count++;
            }
            out.print("</tr>");
            out.print("<tr>");
            while (result.next()) {
                count = 1;
                 
                while (count <= meta.getColumnCount()) {
                    out.print("<td>" + result.getString(meta.getColumnName(count)) + "</td>");
                    count++;
                }
               out.print("</tr>");
               // conn.close();
            }
             
                out.print("</table>");
        } catch (Exception e) {
            out.print(e.toString());
            bodyContent.clearBody();
        }

    }

    @Override
    public int doStartTag() throws JspException {
        otherDoStartTagOperations();

        if (theBodyShouldBeEvaluated()) {
            return EVAL_BODY_BUFFERED;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        otherDoEndTagOperations();

        if (shouldEvaluateRestOfPageAfterEndTag()) {
            return EVAL_PAGE;
        } else {
            return SKIP_PAGE;
        }
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            // This code is generated for tags whose bodyContent is "JSP"
            BodyContent bodyCont = getBodyContent();
            JspWriter out = bodyCont.getEnclosingWriter();

            writeTagBodyContent(out, bodyCont);
        } catch (Exception ex) {
            handleBodyContentException(ex);
        }

        if (theBodyShouldBeEvaluatedAgain()) {
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    /**
     * Handles exception from processing the body content.
     */
    private void handleBodyContentException(Exception ex) throws JspException {
        // Since the doAfterBody method is guarded, place exception handing code here.
        throw new JspException("Error in employee tag", ex);
    }

    /**
     * Fill in this method to determine if the rest of the JSP page should be
     * generated after this tag is finished. Called from doEndTag().
     */
    private boolean shouldEvaluateRestOfPageAfterEndTag() {
        // TODO: code that determines whether the rest of the page
        //       should be evaluated after the tag is processed
        //       should be placed here.
        //       Called from the doEndTag() method.
        //
        return true;
    }

    /**
     * Fill in this method to determine if the tag body should be evaluated
     * again after evaluating the body. Use this method to create an iterating
     * tag. Called from doAfterBody().
     */
    private boolean theBodyShouldBeEvaluatedAgain() {
        // TODO: code that determines whether the tag body should be
        //       evaluated again after processing the tag
        //       should be placed here.
        //       You can use this method to create iterating tags.
        //       Called from the doAfterBody() method.
        //
        return false;
    }

    private boolean theBodyShouldBeEvaluated() {
        // TODO: code that determines whether the body should be
        //       evaluated should be placed here.
        //       Called from the doStartTag() method.
        return true;
    }
}
