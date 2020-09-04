/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.*;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class UserDao {

    Connection conn = null;
    ResultSet rs;
    PreparedStatement ps;
    DataConnection dc = new DataConnection();

    public UserDao() {
        conn = dc.getConnection();
    }

    public boolean login(String username, String password) {
        try {
            String url = "select * from strut where username = ? and password=?";
            ps = conn.prepareStatement(url);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
     public ResultSet getUser() throws SQLException {
        String sql = "SELECT * FROM `employees` ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }

    

}
