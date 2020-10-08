package Model;

public class User {
    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isSendNotification;
    private String website;
    private String roleID;
    private String email;

    public User() {
    }

    public User(String userID, String password, String firstName, String lastName, boolean isSendNotification, String website, String roleID, String email) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isSendNotification = isSendNotification;
        this.website = website;
        this.roleID = roleID;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSendNotification() {
        return isSendNotification;
    }

    public void setSendNotification(boolean sendNotification) {
        isSendNotification = sendNotification;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
