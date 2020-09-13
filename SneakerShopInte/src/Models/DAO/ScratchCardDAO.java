package Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hoald
 */
public class ScratchCardDAO extends DBConnection{
    private final Connection conn;

    /**
     *
     */
    public ScratchCardDAO() {
        DBConnection db = new DBConnection();
        this.conn = db.getConnect();
    }
    
    /**
     *
     * @param value:test
     * @return test
     */
    public int getSumCardNumber(int value) {
        int countOfCart = 0;
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(chargeCardNumber) AS COUNT FROM charge WHERE chargeValue=? AND chargeUsed=0 AND chargeTaken= 0");
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                countOfCart = Integer.parseInt(rs.getString("count"));
            }
               closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return countOfCart;
    }
    
    /**
     *
     * @param value
     * @return
     */
    public String getCard(int value) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT chargeCardNumber FROM charge WHERE  chargeValue=? AND chargeUsed=0");
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                closeConnection();
                return  rs.getString("chargeCardNumber");
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     *
     * @param number
     * @return
     */
    public boolean setCardTaken(String number) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE charge set chargeTaken=1 WHERE  chargeCardNumber=?");
            pst.setString(1, number);
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate == 1) {
                closeConnection();
                return true;
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     *
     * @param number
     * @return
     */
    public boolean checkCardExistForUser(String number) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT chargeCardNumber FROM charge WHERE  chargeCardNumber=? and chargeUsed=0");
            pst.setString(1, number);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                 closeConnection();
                return true;
            }
              
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     *
     * @param chargeNumberCard
     * @return
     */
    public int getValueFromNumber(String chargeNumberCard) {
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT chargeValue FROM charge WHERE  chargeCardNumber= ?");
            pst.setString(1, chargeNumberCard);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                closeConnection();
                return rs.getInt("chargeValue");
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    /**
     *
     * @param number
     * @return
     */
    public boolean setCardUsed(String number) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE charge set chargeUsed=1 WHERE  chargeCardNumber=?");
            pst.setString(1, number);
            int executeUpdate = pst.executeUpdate();
            if(executeUpdate == 1) {
                closeConnection();
                return true;
            }
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
