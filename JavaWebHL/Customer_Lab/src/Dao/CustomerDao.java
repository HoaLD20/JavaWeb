/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.DataConnection;
import Model.CustomerModel;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author root
 */
public class CustomerDao {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
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

    public static boolean validate(CustomerModel customerModel) throws ClassNotFoundException {
        boolean status = false;
        try {
            ps = conn.prepareStatement("select * from login where username = ? and password = ? ");
            ps.setString(1, customerModel.getUsername());
            ps.setString(2, customerModel.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;

    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
