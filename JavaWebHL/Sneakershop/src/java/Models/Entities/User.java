package Models.Entities;

/**
 * @author hoald
 */
public class User implements Cloneable{
    private String uName;   //Stores name of user
    private String uEmail; //Stores email of user
    private int uId; //Stores id of user
    private String uJob;    //Stores job of user
    private String uPassword; //Stores password of user
    private String uRole; //Stores role of user
    private String uPhoto; //Stores photo of user
    private String uAddress; //Stores address of user
    private String uCreditCard; //Stores credit card of user
    private double uCash; //Stores cash of user

    /**
     * Constructor # creates new object for User
     */
    public User() {
    }

    /**
     * Constructor # creates new object for User
     * @param uName the name of user
     * @param uEmail the email of user
     * @param uId the id of user
     * @param uJob the job of user
     * @param uPassword the password of user
     * @param uRole the role of user
     * @param uPhoto the photo of user
     * @param uAddress the address of user
     * @param uCreditCard the credit card of user
     * @param uCash the cash of user
     */
    public User(String uName, String uEmail, int uId, String uJob, String uPassword, String uRole, String uPhoto, String uAddress, String uCreditCard, double uCash) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uId = uId;
        this.uJob = uJob;
        this.uPassword = uPassword;
        this.uRole = uRole;
        this.uPhoto = uPhoto;
        this.uAddress = uAddress;
        this.uCreditCard = uCreditCard;
        this.uCash = uCash;
    }

    /**
     * Gets the name of User
     * @return the name of object
     */
    public String getuName() {
        return uName;
    }

    /**
     * Sets name for User
     * @param uName the name of user
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * Gets the email of User
     * @return the email of object
     */
    public String getuEmail() {
        return uEmail;
    }

    /**
     * Sets email for User
     * @param uEmail the email of user
     */
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    /**
     * Gets the id of User
     * @return the id of object
     */
    public int getuId() {
        return uId;
    }

    /**
     * Sets id for User
     * @param uId the id of user
     */
    public void setuId(int uId) {
        this.uId = uId;
    }

    /**
     * Gets the job of User
     * @return the job of object
     */
    public String getuJob() {
        return uJob;
    }

    /**
     * Sets job for User
     * @param uJob the job of user
     */
    public void setuJob(String uJob) {
        this.uJob = uJob;
    }

    /**
     * Gets the password of User
     * @return the password of object
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * Sets password for User
     * @param uPassword the password of user
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    /**
     * Gets the role of User
     * @return the role of object
     */
    public String getuRole() {
        return uRole;
    }

    /**
     * Sets role for User
     * @param uRole the role of user
     */
    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    /**
     * Gets the photo of User
     * @return the photo of object
     */
    public String getuPhoto() {
        return uPhoto;
    }

    /**
     * Sets photo for User
     * @param uPhoto the photo of user
     */
    public void setuPhoto(String uPhoto) {
        this.uPhoto = uPhoto;
    }

    /**
     * Gets the address of User
     * @return the address of object
     */
    public String getuAddress() {
        return uAddress;
    }

    /**
     * Sets address for User
     * @param uAddress the address of user
     */
    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    /**
     * Gets the credit card of User
     * @return the credit card of object
     */
    public String getuCreditCard() {
        return uCreditCard;
    }

    /**
     * Sets credit card for User
     * @param uCreditCard the credit card of user
     */
    public void setuCreditCard(String uCreditCard) {
        this.uCreditCard = uCreditCard;
    }

    /**
     * Gets the cash of User
     * @return the cash of object
     */
    public double getuCash() {
        return uCash;
    }

    /**
     * Sets cash for User
     * @param uCash the cash of user
     */
    public void setuCash(double uCash) {
        this.uCash = uCash;
    }

    @Override
    public String toString() {
        return "name: " + uName + "\n role" +uRole;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
