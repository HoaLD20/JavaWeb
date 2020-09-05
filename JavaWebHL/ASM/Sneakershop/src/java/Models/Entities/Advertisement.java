package Models.Entities;

/**
 * @author hoald
 */
public class Advertisement {
    private int aId; //Stores id for advertisement
    private String aImage;  //Stores image for advertisement
    private String aURL;    //Stores URL for advertisement

    /**
     * Constructor # creates new object for Advertisement
     */
    public Advertisement() {
    }

    /**
     * Constructor # creates new object for Advertisement
     * @param aId  the id of advertisement
     * @param aImage the location of the image, relative to the url argument
     * @param aURL an absolute URL giving the base location of the advertisement
     */
    public Advertisement(int aId, String aImage, String aURL) {
        this.aId = aId;
        this.aImage = aImage;
        this.aURL = aURL;
    }

    /**
     * Gets the id of advertisement
     * @return the id of object
     */
    public int getaId() {
        return aId;
    }

    /**
     * Sets id for advertisement
     * @param aId the id of advertisement
     */
    public void setaId(int aId) {
        this.aId = aId;
    }

    /**
     * Gets the image of advertisement
     * @return the image of object
     */
    public String getaImage() {
        return aImage;
    }

    /**
     * Sets image for advertisement
     * @param aImage the location of the image, relative to the url argument
     */
    public void setaImage(String aImage) {
        this.aImage = aImage;
    }

    /**
     * Gets the URL of advertisement 
     * @return the URL of object
     */
    public String getaURL() {
        return aURL;
    }

    /**
     * Sets URL for advertisement
     * @param aURL an absolute URL giving the base location of the advertisement
     */
    public void setaURL(String aURL) {
        this.aURL = aURL;
    }
    
}
