package Models.DAO;

import Models.Entities.Charge;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hoald
 */
public class ChargeDAO extends DBConnection{
    private DBConnection db;
    private ResultSet rs;
    private PreparedStatement pst;
    
    /**
     *constructor
     */
    public ChargeDAO(){
        db = new DBConnection();
        rs = null;
        pst = null;
    }
    
    /**
     *
     * @return check charge have or not 
     */
    public int getProfit(){
        int profit = 0;
        try {
            pst = db.getConnect().prepareStatement("Select SUM(chargeValue) AS profit from charge where chargeTaken=1");
            rs = pst.executeQuery();
            
            if(rs.next()){
                profit = rs.getInt("profit");
                db.getConnect().close();
            }
        } catch (Exception e) {
            try {
                db.getConnect().close();
            } catch (SQLException ex) {
                Logger.getLogger(ChargeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return profit;
    }
    
    /**
     *
     * @param value value charge to buy
     * @return count of card
     */
    public int getSumCardNumber(int value){
        int coutOfCard = 0;
        try {
            pst = db.getConnect().prepareStatement("select count(chargeCardNumber) as count from charge where chargeValue=? and chargeUsed=0 and chargeTaken=0 ");
            pst.setInt(1, value);
            rs = pst.executeQuery();    
               closeConnection();
            while (rs.next()) {
                coutOfCard = Integer.parseInt(rs.getString("count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coutOfCard;
    }
    
    /**
     *
     * @param numbercheck
     * @return
     */
    public boolean numberOfCardIsFound(String numbercheck) {
        try {
            pst = db.getConnect().prepareStatement("select chargeCardNumber from charge where  chargeCardNumber=?  ");
            pst.setString(1, numbercheck);
            rs = pst.executeQuery();
               closeConnection();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     *
     * @param obj add new card from addmin
     * @return  true or false
     */
    public boolean addCard(Charge obj) {
        try {
            pst = db.getConnect().prepareStatement("INSERT INTO `charge`(`chargeCardNumber`, `chargeValue`, `chargeUsed`, `chargeTaken`) VALUES (?,?,?,?)");

            pst.setString(1, obj.getChargecardNumber());
            pst.setInt(2, obj.getChargeValue());
            pst.setInt(3, obj.getChargeUsed());
            pst.setInt(4, obj.getChargeTaken());
               closeConnection();
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
