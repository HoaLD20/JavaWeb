package Dao;

import DB.DataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author hoald
 */
public class UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DataConnection dataConnection = new DataConnection();

    public UserDao(Connection conn) {
        this.conn = dataConnection.getConnection();
    }

    public boolean userLogin(String username, String password){

    }
}
