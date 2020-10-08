package DB;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnection {
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/UserManagement";

    public DataConnection() {

    }

    public DataConnection(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

}
