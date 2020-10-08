package Helper;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhndse04560
 */
public class DbConnectionHelper {

    public static Connection conn;

    public DbConnectionHelper() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/easycms", "root", "");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnectionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection connection) throws Exception {
        if ((connection != null) && (!connection.isClosed())) {
            connection.close();
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println(DbConnectionHelper.getConnection());
//
//    }
}
