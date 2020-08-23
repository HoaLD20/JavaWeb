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

/**
 *
 * @author root
 */
public class StudentDao {
    Connection conn = null;
    ResultSet rs;
    PreparedStatement ps;
    DataConnection db = new DataConnection();
    public StudentDao() throws ClassNotFoundException, SQLException{
        this.conn = db.getConnection();
    }
    
    public ResultSet getStudent() throws SQLException{
        String sql = "Select * from student";
        System.out.println("getstudent");
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }
}
