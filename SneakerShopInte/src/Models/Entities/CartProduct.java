package Models.Entities;


/**
 * @author hoald
 */
public class CartProduct {
    private int cartId; //Stores id of cart
    private int uId;    //Stores id of user
    private int cartQuantity;   //Stores quantity of cart
    private int pId;    //Stores id of product
    private String pName;   //Stores name of product
    private String pImage;  //Stores image of product
    private double pPrice;  //Stores price of product
    private int pWeight;    //Stores weight of product
    private String pDescription;    //Stores description of product
    private int pQuantity;  //Stores quantity of product
    private String pCreateDate; //Stores create date of product
   
    /**
     * Constructor # creates new object for CartProduct
     */
    public CartProduct() {
    }

    /**
     * Constructor # creates new object for CartProduct
     * @param cartId the id of cart
     * @param uId the id of user
     * @param cartQuantity the quantity in cart of user after add product
     * @param pId the id of product
     * @param pName the name of product
     * @param pImage  the location of the image of product, relative to the url argument
     * @param pPrice the price for each product
     * @param pWeight the weight of product is 1000g when buy
     * @param pDescription the description about product
     * @param pQuantity the quantity of product in stock
     * @param pCreateDate create date of product when show selling
     */
    public CartProduct(int cartId, int uId, int cartQuantity, int pId, String pName, String pImage, double pPrice, int pWeight, String pDescription, int pQuantity, String pCreateDate) {
        this.cartId = cartId;
        this.uId = uId;
        this.cartQuantity = cartQuantity;
        this.pId = pId;
        this.pName = pName;
        this.pImage = pImage;
        this.pPrice = pPrice;
        this.pWeight = pWeight;
        this.pDescription = pDescription;
        this.pQuantity = pQuantity;
        this.pCreateDate = pCreateDate;
    }

    /**
     * Gets the id of cart
     * @return the id of object
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Sets id for cart
     * @param cartId the id of cart
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    /**
     * Gets the id of user
     * @return the id of object 
     */
    public int getuId() {
        return uId;
    }

    /**
     * Sets id for user
     * @param uId the id of user
     */
    public void setuId(int uId) {
        this.uId = uId;
    }

    /**
     * Gets the quantity of cart
     * @return the quantity of object
     */
    public int getCartQuantity() {
        return cartQuantity;
    }

    /**
     * Sets quantity of cart
     * @param cartQuantity the quantity in cart of user after add product
     */
    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    /**
     * Gets the id of product
     * @return the id of object
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
     * Gets the name of product
     * @return the name of object
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
     * @return the image of object
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
     * @return the price of object
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
     * @return the weight of object
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
     * @return the description of object
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
     * @return the quantity of object
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
     * @return the create date of object
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
