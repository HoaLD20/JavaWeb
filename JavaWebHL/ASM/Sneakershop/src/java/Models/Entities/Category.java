package Models.Entities;

/**
 * @author hoald
 */
public class Category {
    private int cId;    //Stores id of category
    private String cName;   //Stores name of category

    /**
     * Constructor # creates new object for category
     */
    public Category() {
    }

    /**
     * Constructor # creates new object for category
     * @param cId the id of category
     * @param cName the name of category
     */
    public Category(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    /**
     * Gets the id of category
     * @return the id of object
     */
    public int getcId() {
        return cId;
    }

    /**
     * Sets id for category
     * @param cId the id of category
     */
    public void setcId(int cId) {
        this.cId = cId;
    }

    /**
     * Gets the name of product
     * @return the name of object
     */
    public String getcName() {
        return cName;
    }

    /**
     * Sets name for product
     * @param cName the name of category
     */
    public void setcName(String cName) {
        this.cName = cName;
    }
    
}
