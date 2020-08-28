/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.DataConnection;
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
public class ProductDao {
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs;
    DataConnection db = new DataConnection();
    public ProductDao() {
        this.conn = db.getConnection();
    }
    
    public ResultSet getProduct(){
        try {
            String sql = "Select * from product";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
}
