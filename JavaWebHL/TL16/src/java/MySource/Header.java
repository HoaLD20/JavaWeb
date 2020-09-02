/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySource;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author root
 */
public class Header implements Tag {

    private String companyName = "";

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    PageContext pageContext;
    Tag parent;

    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        this.parent = t;
    }

    @Override
    public Tag getParent() {
        return parent;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("<h1>" + companyName + "</h1>");
            pageContext.getOut().print("<h3>Education Department</h3>");
        } catch (IOException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public void release() {
    }
}
