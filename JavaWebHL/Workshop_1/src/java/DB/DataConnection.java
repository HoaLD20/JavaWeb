/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class DataConnection {
    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/workshop";
     public DataConnection() {

    }

    public DataConnection(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }
    
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
