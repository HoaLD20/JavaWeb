package Dao;

import DB.DataConnection;
import Model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.sql.SQLException;

public class UserDao {
    private Connection conn = null;
    private ResultSet rs;
    private PreparedStatement ps;
    private DataConnection db = new DataConnection();

    public UserDao(){
        this.conn = db.getConnection();
    }

    public User login(String userID, String password) {

        User user = new User();
        String sql = "SELECT * FROM user WHERE userID = ? and password = ?";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);

            ResultSet result = (ResultSet) ps.executeQuery();


            if (result.next()) {
                user = new User();
                user.setUserID(result.getString("userID"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ResultSet getStudent(){
        String sql = "Select * from student";
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
