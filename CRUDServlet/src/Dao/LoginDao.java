package Dao;

import Model.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hoald
 */
public class LoginDao {
    public static boolean CheckLogin(LoginModel loginModel) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc://mysql://localhost:3306/meow", "root", "root");
        PreparedStatement PS = conn.prepareStatement("Select * from login where username = ? and password = ?");
        return true;
    }
}
