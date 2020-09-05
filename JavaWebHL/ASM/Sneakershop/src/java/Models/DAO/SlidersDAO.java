package Models.DAO;

import Models.Entities.Sliders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hoald
 */
public class SlidersDAO extends DBConnection{
    DBConnection db = new DBConnection();
    private Connection conn;
    private ResultSet rs = null;

    /**
     *
     */
    public SlidersDAO() {  
        this.conn = db.getConnect();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Sliders> getAllSliders() {
        ArrayList<Sliders> listSliders = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `slides`");
            rs = pst.executeQuery();
            while(rs.next()) {
                Sliders slide = new Sliders(rs.getInt("sId"), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(2));
                listSliders.add(slide);
            }
               closeConnection();
            return listSliders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     *
     * @param sliders
     * @return
     */
    public boolean addSlider(Sliders sliders){
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO `slides`(`pId`, `sTitle`, `sSubtitle`, `sDescription`, `sImage`) VALUES (?,?,?,?,?)");
            pst.setInt(1, sliders.getpId());
            pst.setString(2, sliders.getsTitle());
            pst.setString(3, sliders.getsSubtitle());
            pst.setString(4, sliders.getsDescription());
            pst.setString(5, sliders.getsImage());
            
            int i = pst.executeUpdate();
            if(i > 0 ){
                closeConnection();
                return true;
            }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteSlider(int id) {
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM `slides` WHERE sId=?");
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate > 0) {
                closeConnection();
                return true;
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
