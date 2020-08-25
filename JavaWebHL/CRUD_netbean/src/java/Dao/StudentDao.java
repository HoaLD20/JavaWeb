/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.DataConnection;
import Model.Student;
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

    public StudentDao() throws ClassNotFoundException, SQLException {
        this.conn = db.getConnection();
    }

    public ResultSet getStudent() throws SQLException {
        String sql = "Select * from student";
        System.out.println("getstudent");
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
    }

    public int addStudent(Student student) throws SQLException {
        String sql = "Insert into student value(?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);

        ps.setString(1, student.getUsername());
        ps.setString(2, student.getPassword());
        ps.setString(3, student.getFullname());
        ps.setString(4, student.getGender());
        ps.setString(5, student.getBirthday());
        ps.setString(6, student.getEmail());
        ps.setString(7, student.getAddress());

        return ps.executeUpdate();
    }
    
    public Student getStudentInfo(String username) throws SQLException{
        String sql = "select * from student where username = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        Student s = new Student();
        while(rs.next()){
            s.setUsername(rs.getString("username"));
            s.setPassword(rs.getString("password"));
            s.setFullname(rs.getString("fullname"));
            s.setGender(rs.getString("gender"));
            s.setBirthday(rs.getString("birthday"));
            s.setEmail(rs.getString("email"));
            s.setAddress(rs.getString("address"));
        }
        return s;
        
    }
    public int updateStudent(Student student) throws SQLException{
        String sql = "update student set password=?, fullname=?, gender=?, birthday=?, email=?, address=? where username=?";
        ps = conn.prepareStatement(sql);
        ps.setString(7, student.getUsername());
        ps.setString(1, student.getPassword());
        ps.setString(2, student.getFullname());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getBirthday());
        ps.setString(5, student.getEmail());
        ps.setString(6, student.getAddress());
        return ps.executeUpdate();
    }

    public void deleteUser(String username) throws SQLException {
        String sql = "delete from student where username = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.executeUpdate();
        
    }
}
