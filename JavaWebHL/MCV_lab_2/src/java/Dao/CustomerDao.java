/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class CustomerDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    DataConnection dataConnection = new DataConnection();

    public CustomerDao() throws ClassNotFoundException {
        this.conn = dataConnection.getConnection();
    }

    public ResultSet getAllCustomer() {
        try {
            String sql = "Select * from customer";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public boolean loginCustomer(String username, String password) {
        try {
            String sql = "Select username, password from customer where username=? and password=?";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            String username1 = rs.getString("username"); //fetch the values present in database
            String password1 = rs.getString("password");

            if (username.equals(username1) && password.equals(password1)) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
