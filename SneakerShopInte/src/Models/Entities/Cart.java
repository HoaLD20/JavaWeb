package Models.Entities;

/**
 * @author hoald
 */
public class Cart {
    private int cartId; //Stores id of cart
    private int uId;    //Stores id of user
    private int pId;    //Stores id of product
    private int cartQuantity; //Stores quantity of cart

    /**
     * Constructor # creates new object for Cart
     */
    public Cart() {
    }

    /**
     * Constructor # creates new object for Cart
     * @param cartId the id of cart
     */
    public Cart(int cartId) {
        this.cartId = cartId;
    }

    /**
     * Constructor # creates new object for Cart
     * @param cartId the id of cart
     * @param uId the id of user
     * @param pId the id of product
     * @param cartQuantity the quantity in cart of user after add product
     */
    public Cart(int cartId, int uId, int pId, int cartQuantity) {
        this.cartId = cartId;
        this.uId = uId;
        this.pId = pId;
        this.cartQuantity = cartQuantity;
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
     * @return  the id of object user
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
     * Gets the quantity of cart
     * @return the quantity of object cart
     */
    public int getCartQuantity() {
        return cartQuantity;
    }

    /**
     * Sets quantity for cart
     * @param cartQuantity the quantity in cart of user after add product
     */
    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
    
    
}
