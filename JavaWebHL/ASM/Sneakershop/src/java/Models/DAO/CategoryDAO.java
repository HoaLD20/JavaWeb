package Models.DAO;

import Models.Entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hoald
 */
public class CategoryDAO extends DBConnection{
    Category bean = new Category();
    Connection conn;
    DBConnection db = new DBConnection();

    /**
     *
     */
    public CategoryDAO() {
        this.conn = db.getConnect();
    }
    
    /**
     *
     * @return List of category
     */
    public ArrayList<Category> allCategoriess() {
        ArrayList<Category> allCategory = new ArrayList<>();
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * from category ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Category category = new Category();
                category.setcId(rs.getInt("cId"));
                category.setcName(rs.getString("cName"));
                allCategory.add(category);
            }
               closeConnection();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return allCategory;
    }
    
    /**
     *
     * @param category object category
     * @return true or false
     */
    public boolean addCategory(Category category){
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO `category`(`cName`) VALUES (?)");
            pst.setString(1, category.getcName());
            int i = pst.executeUpdate();
               closeConnection();
            if(i>0){
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
