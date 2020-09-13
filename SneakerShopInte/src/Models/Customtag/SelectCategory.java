package Models.Customtag;

import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import Models.DAO.CategoryDAO;
import Models.Entities.Category;

/**
 * @author hoald
 */
public class SelectCategory extends SimpleTagSupport {

    private int selectID;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            out.print("<select name='category'>");
            String selected = ""; 
            //get all category
            ArrayList<Category> categoriess = new CategoryDAO().allCategoriess();
            for (Category categories : categoriess) {
                if(selectID == categories.getcId())
                    selected = "selected";
                out.print("<option value='"+categories.getcId()+"' "+selected+">"+categories.getcName()+"</option>");
                selected ="";
            }
            out.print("</select>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Category tag", ex);
        }
    }

    public void setSelectID(int selectID) {
        this.selectID = selectID;
    }
    
}
