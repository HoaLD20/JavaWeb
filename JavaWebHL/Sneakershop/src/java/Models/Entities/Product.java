package Models.Entities;


/**
 * @author hoald
 */
public class Product {
    private int pId;    //Stores id of product
    private int cId;    //Stores id of category
    private String pName;   //Stores name of product
    private String pImage;  //Stores image of product
    private double pPrice; //Stores price of product
    private int pWeight;    //Stores weight of product
    private String pDescription;    //Stores description of product
    private int pQuantity;  //Stores quantity of product
    private String pCreateDate; //Stores create date of product

    /**
     * Constructor # creates new object for Product
     */
    public Product() {
    }

    /**
     * Constructor # creates new object for Product
     * @param pId the id of product
     */
    public Product(int pId) {
        this.pId = pId;
    }

    /**
     * Constructor # creates new object for Product
     * @param pId the id of product
     * @param cId the id of category
     * @param pName the name of product
     * @param pImage  the location of the image of product, relative to the url argument
     * @param pPrice  the price for each product
     * @param pWeight the weight of product is 1000g when buy
     * @param pDescription the description about product
     * @param pQuantity the quantity of product in stock
     * @param pCreateDate create date of product when show selling
     */
    public Product(int pId, int cId, String pName, String pImage, double pPrice, int pWeight, String pDescription, int pQuantity, String pCreateDate) {
        this.pId = pId;
        this.cId = cId;
        this.pName = pName;
        this.pImage = pImage;
        this.pPrice = pPrice;
        this.pWeight = pWeight;
        this.pDescription = pDescription;
        this.pQuantity = pQuantity;
        this.pCreateDate = pCreateDate;
    }

    /**
     * Gets the id of product
     * @return the id of object product
     */
    public int getpId() {
        return pId;
    }

    /**
     * Sets id for product
     * @param pId the id of product
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * Gets the id of category
     * @return the id of object category
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
     * @return the name of object product
     */
    public String getpName() {
        return pName;
    }

    /**
     * Sets name for product
     * @param pName the name of product
     */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * Gets the image of product
     * @return the image of object product
     */
    public String getpImage() {
        return pImage;
    }

    /**
     * Sets image for product
     * @param pImage the location of the image of product, relative to the url argument
     */
    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    /**
     * Gets the price of product
     * @return the price of object product
     */
    public double getpPrice() {
        return pPrice;
    }

    /**
     * Sets price for product
     * @param pPrice the price for each product
     */
    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * Gets the weight of product
     * @return the weight of object product
     */
    public int getpWeight() {
        return pWeight;
    }

    /**
     * Sets weight for product
     * @param pWeight the weight of product is 1000g when buy
     */
    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

    /**
     * Gets description of product
     * @return the description of object product
     */
    public String getpDescription() {
        return pDescription;
    }

    /**
     * Sets description for product
     * @param pDescription the description about product
     */
    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    /**
     * Gets the quantity of product
     * @return the quantity of object product
     */
    public int getpQuantity() {
        return pQuantity;
    }

    /**
     * Sets quantity for product
     * @param pQuantity the quantity of product in stock
     */
    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    /**
     * Gets the create date of product
     * @return the create date of object product
     */
    public String getpCreateDate() {
        return pCreateDate;
    }

    /**
     * Sets create date for product
     * @param pCreateDate create date of product when show selling
     */
    public void setpCreateDate(String pCreateDate) {
        this.pCreateDate = pCreateDate;
    }

    

    
}
