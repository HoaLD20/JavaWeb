package Models.DAO;




import Models.Entities.User;
import java.sql.*;
import java.util.ArrayList;
import Models.utilize.SHA;


/**
 * @author hoald
 */
public class UserDAO extends DBConnection{

    public User bean = new User();
    public Connection con;
    public boolean b = false;
    public UserDAO() {
        DBConnection db = new DBConnection();
        this.con = db.getConnect();  
    }
    private boolean search(String usrName) {

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM `users` WHERE `uName` = ? ");
            pst.setString(1, usrName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                b = true;
            } else {
                b = false;
            }
              closeConnection();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

        return b;
    }

    /**
     *
     * @param bean
     * @return
     */
    public boolean signUp(User bean) {
        
        boolean b = false;
        
        
        if (!search(bean.getuName())) {
            try {
             
                String sql = "INSERT INTO `users` (`uId`, `uName`, `uEmail`, `uAddress`, `uJob`, `uPassword`, `uCreditCard`, `uCash`, `uRole`, `uPhoto`) VALUES (NULL,?,?,?,?, MD5(?), ?, ?, ?, ?)";
                PreparedStatement pst1 = con.prepareStatement(sql);

                pst1.setString(1, bean.getuName());
                pst1.setString(2, bean.getuEmail());
                pst1.setString(3, bean.getuAddress());
                pst1.setString(5, bean.getuPassword());
                pst1.setString(4, bean.getuJob());
                pst1.setString(6, bean.getuCreditCard());
                pst1.setDouble(7, bean.getuCash());
                pst1.setString(8, bean.getuRole());
                pst1.setString(9, "upload/user.png");
                pst1.executeUpdate();
                b = true;
                ////////////////////////////////////////

                //con.close();
                   closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                return b ;
            }
        }


        return b;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User signIn(String username, String password) {

        User userSinIn = new User();
        userSinIn = null ;
        try {
            if (search(username)) {
//                con = db.getConnect();
                String sql = "SELECT * FROM `users` WHERE `uName`=? AND `uPassword`=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, SHA.encrypt(password));
                ResultSet rs = pst.executeQuery();
               
                if (rs.next()) {
                    userSinIn = new User(rs.getString("uName"),rs.getString("uEmail") , rs.getInt("uId"),rs.getString("uJob"), rs.getString("uPassword"), rs.getString("uRole"), rs.getString("uPhoto"), rs.getString("uAddress"),rs.getString("uCreditCard"),rs.getInt("uCash"));
                    System.out.println("tú tú ");
                    System.out.println(userSinIn);
                }
                
                System.out.println(userSinIn);
                return userSinIn;
            }
               closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("tú tú 111");
        return null;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Boolean UpdatePass(String username, String password) {
            try {
                PreparedStatement pst = con.prepareStatement("UPDATE `users` SET `uPassword`= ? WHERE `uName` = ?");
                pst.setString(1,SHA.encrypt(password));
                String passs = SHA.encrypt(password);
                pst.setString(2,username);
                pst.execute();
                   closeConnection();
                return true;
                
            }
         catch (SQLException ex) {
            ex.printStackTrace();
         }
        
        
        System.out.println("tú tú 111");
        return false;
    }

    /**
     *
     * @param username
     * @return
     */
    public User TakeNameForget(String username) {

        User userSinIn = new User();
        try {
            if (search(username)) {
//                con = db.getConnect();
                String sql = "SELECT * FROM `users` WHERE `uName`=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    userSinIn = new User(rs.getString("uName"),rs.getString("uEmail") , rs.getInt("uId"),rs.getString("uJob"), rs.getString("uPassword"), rs.getString("uRole"), rs.getString("uPhoto"), rs.getString("uAddress"),rs.getString("uCreditCard"),rs.getInt("uCash"));
                    System.out.println("tú tú ");
                    System.out.println(userSinIn);
                }
                
                System.out.println(userSinIn);
                   closeConnection();
                return userSinIn;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("tú tú 111");
        return null;
    }

    /**
     *
     * @param updateUser
     * @param path
     * @return
     */
    public boolean updateUser(User updateUser ,String path) {

        try {
            System.out.println("Start");
            if (search(updateUser.getuName())) {
                
                User temp=getUser(updateUser.getuId());
                if (!temp.getuPhoto().equalsIgnoreCase(updateUser.getuPhoto()))
                {
                     boolean deleteFile = Models.utilize.FileUpload.deleteFile(temp.getuPhoto(), path);
                     System.out.println("--=-=-=-=-=-=-=-=-=-==-0" + deleteFile);
                }
                System.out.println("-=-=-=-=-= 0 -=-=-=-=-= ");
                
                PreparedStatement pst = con.prepareStatement("UPDATE `users` SET `uName`=?,`uEmail`=?,`uAddress`=?,`uJob`=?,`uPassword`=?,`uCreditCard`=?,`uCash`=?,`uRole`=?,`uPhoto`=? WHERE `uId`= ?");
                pst.setString(1, updateUser.getuName());
                pst.setString(5, SHA.encrypt(updateUser.getuPassword()));
                pst.setString(2, updateUser.getuEmail());
                pst.setString(4, updateUser.getuJob());
                pst.setString(3, updateUser.getuAddress());
                pst.setString(6, updateUser.getuCreditCard());
                pst.setDouble(7, updateUser.getuCash());
                pst.setString(8, updateUser.getuRole());
                pst.setString(9, updateUser.getuPhoto());
                pst.setInt(10, updateUser.getuId());
                System.out.println("--=-=-=-=-=-=-=-=-=-==-1");
                pst.executeUpdate();
                System.out.println("--=-=-=-=-=-=-=-=-=-==-2");
                   closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
      
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<User> getAllUsers() {
        
        ArrayList<User> allUser = new ArrayList();
        try {
            //DriverManager.registerDriver(new OracleDriver());
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM `users` WHERE 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setuId(rs.getInt("uId"));
                user.setuName(rs.getString("uName"));
                user.setuEmail(rs.getString("uEmail"));
                user.setuAddress(rs.getString("uAddress"));
                user.setuPassword(rs.getString("uPassword"));
                user.setuJob(rs.getString("uJob"));
                user.setuCreditCard(rs.getString("uCreditCard"));
                user.setuCash(rs.getInt("uCash"));
                user.setuRole(rs.getString("uRole"));
                user.setuPhoto(rs.getString("uPhoto"));
                allUser.add(user);
            }
               closeConnection();
            return allUser;
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return null;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public User getUser(int id) {
        User user = null ;
        try {
             
          
            PreparedStatement pst = con.prepareStatement("SELECT * FROM `users` WHERE `uId`=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user= new User();
                user.setuId(rs.getInt("uId"));
                user.setuName(rs.getString("uName"));
                user.setuEmail(rs.getString("uEmail"));
                user.setuAddress(rs.getString("uAddress"));
                user.setuPassword(rs.getString("uPassword"));
                user.setuJob(rs.getString("uJob"));
                user.setuCreditCard(rs.getString("uCreditCard"));
                user.setuCash(rs.getInt("uCash"));
                user.setuRole(rs.getString("uRole"));
                user.setuPhoto(rs.getString("uPhoto"));
            }
               closeConnection();
        } catch (SQLException ex) {
          
            ex.printStackTrace();
            
        }
        return user ; 
        
    }
    
    /**
     *
     * @param updateUser
     * @return
     * @throws SQLException
     */
    public boolean updateUserBalance(User updateUser) throws SQLException {

       
            if (search(updateUser.getuName())) {
                
                PreparedStatement pst = con.prepareStatement("UPDATE `users` SET `uCash`=? WHERE `uId`=?");
                pst.setDouble(1, updateUser.getuCash());
                pst.setInt(2, updateUser.getuId());       
                pst.executeUpdate();
                   closeConnection();
                return true;
            }
       
        return false;
    }
}
