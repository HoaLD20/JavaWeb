package Models.DAO;

import Models.Entities.Advertisement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author hoald
 */
public class AdvertisementDAO extends DBConnection{
    Connection conn;
    ResultSet rs;

    /**
     *Constructor
     */
    public AdvertisementDAO() {
        DBConnection dBConnection = new DBConnection();
        this.conn = dBConnection.getConnect();
    }

    /**
     *
     * @return Random Advertisement by Admin add in database
     */
    public Advertisement getRandomAds() {
        ArrayList<Advertisement> allAds = getAllAdvertisement();
        if(allAds.size() == 0) {
            return null;
        } else {
            return allAds.get(new Random().nextInt(allAds.size()));
        }
    }

    /**
     *
     * @return all Advertisement in database
     */
    public ArrayList<Advertisement> getAllAdvertisement() {
        try {
            ArrayList<Advertisement> arr = new ArrayList<>();

            PreparedStatement pst = conn.prepareStatement("select * From ads");
            rs = pst.executeQuery();
            while(rs.next()) {
                Advertisement ads = new Advertisement();
                ads.setaId(rs.getInt("aId"));
                ads.setaImage(rs.getString(2));
                ads.setaURL(rs.getString(3));
                arr.add(ads);
            }
            closeConnection();
            return arr;
        } catch (SQLException ex) {
               closeConnection();
            ex.printStackTrace();

        }
           closeConnection();
        return  null;
    }

    /**
     *
     * @param id of Advertisement
     * @return true or false
     */
    public boolean deleteAdvertisment(int id){
        try {
            PreparedStatement pst = conn.prepareStatement("delete From ads where aId=?");
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();

            if (executeUpdate > 0) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param img image of Advertisement
     * @param url link Url of Advertisement
     * @return true or flase
     */
    public boolean addAdvertisment(String img, String url){
        try {
            PreparedStatement pst = conn.prepareStatement("insert into ads (aImage ,aURL)Values (?,?)");

            pst.setString(1, img);
            pst.setString(2, url);

            int executeUpdate = pst.executeUpdate();

            if (executeUpdate > 0) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
