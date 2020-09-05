package Models.DAO;

import Models.Entities.History;
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
public class HistoryDAO extends DBConnection{
    private Connection conn;

    /**
     * constructor
     */
    public HistoryDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }

    public boolean addUserHistory(History h) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO `history`(`uId`, `pId`, `hDate`, `hQuantity`) VALUES (?, ?, ?, ?)");
        pst.setInt(1, h.getuId());
        pst.setInt(2, h.getpId());
        pst.setString(3, h.gethDate());
        pst.setInt(4, h.gethQuantity());
        
        int executeUpdate = pst.executeUpdate();
           closeConnection();
        if(executeUpdate > 0) {
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return object History in database
     */
    public ArrayList<History> getAllHistory(){
        ArrayList<History> listOfHistorys = new ArrayList<History>();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `history`");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                History history = new History();
                history.sethId(rs.getInt(1));
                history.setuId(rs.getInt(2));
                history.setpId(rs.getInt(3));
                history.sethDate(rs.getString(4));
                history.sethQuantity(rs.getInt(5));
                listOfHistorys.add(history);
            }
            
            conn.close();
            return listOfHistorys;
        } catch (Exception e) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return null;
    } 
}
