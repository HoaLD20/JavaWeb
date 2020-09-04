package Models.Entities;

/**
 * @author hoald
 */
public class Charge {
    private String  chargecardNumber;   //Stores cart number of charge
    private int chargeValue;    //Stores value of charge
    private  int chargeUsed ;   //Stores used of charge
    private int chargeTaken;    //Stores taken of product
    
    /**
     * Constructor # creates new object for charge
     */
    public Charge() {
    }

    /**
     * Constructor # creates new object for charge
     * @param chargecardNumber the card number encryption of charge
     * @param chargeValue the value of charge is 50000, 100000, 200000, 500000
     * @param chargeUsed the card used of charge 
     * @param chargeTaken the card taken of charge
     */
    public Charge(String chargecardNumber, int chargeValue, int chargeUsed, int chargeTaken) {
        this.chargecardNumber = chargecardNumber;
        this.chargeValue = chargeValue;
        this.chargeUsed = chargeUsed;
        this.chargeTaken = chargeTaken;
    }

    /**
     * Gets the card number of charge
     * @return the cart number of object
     */
    public String getChargecardNumber() {
        return chargecardNumber;
    }

    /**
     * Sets card number for charge
     * @param chargecardNumber
     */
    public void setChargecardNumber(String chargecardNumber) {
        this.chargecardNumber = chargecardNumber;
    }

    /**
     * Gets the card value of charge
     * @return the card value of object
     */
    public int getChargeValue() {
        return chargeValue;
    }

    /**
     * Sets value for charge
     * @param chargeValue the value of charge is 50000, 100000, 200000, 500000
     */
    public void setChargeValue(int chargeValue) {
        this.chargeValue = chargeValue;
    }

    /**
     * Gets the card used of charge
     * @return the card used of object
     */
    public int getChargeUsed() {
        return chargeUsed;
    }

    /**
     * Sets card used for charge
     * @param chargeUsed the card used of charge 
     */
    public void setChargeUsed(int chargeUsed) {
        this.chargeUsed = chargeUsed;
    }

    /**
     * Gets the card taken of charge 
     * @return the card taken of object
     */
    public int getChargeTaken() {
        return chargeTaken;
    }

    /**
     * Sets card taken for charge
     * @param chargeTaken the card taken of charge
     */
    public void setChargeTaken(int chargeTaken) {
        this.chargeTaken = chargeTaken;
    }
    
}
