package Models.DAO;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hoald
 */
public class DBConnection {

    public Connection conn = null;
    public DBConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sneakershop", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return conn;
    }
   public boolean closeConnection() {
        try {

            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

//    public static void main(String[] args) {
//        DBConnection connection = new DBConnection();
//        System.out.println(connection.getConnect());
//    }
}
