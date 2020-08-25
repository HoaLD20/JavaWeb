package DB;

import java.sql.*;

/**
 * @author hoald
 */
public class DataConnection {
    private String username = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/meow";

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
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(conn != null){
                closeConnection(conn);
            }
        }
        return conn;
    }

    public void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
