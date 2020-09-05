package Models.Entities;

/**
 * @author hoald
 */
public class Sliders {
    private int sId;    //Stores id of sliders
    private String sImage; //Stores image of sliders
    private String sTitle; //Stores tittle of sliders
    private String sSubtitle; //Stores subtitle of sliders
    private String sDescription; //Stores description of sliders
    private int pId; //Stores id of product

    /**
     * Constructor # creates new object for Sliders
     */
    public Sliders() {
    }

    /**
     * Constructor # creates new object for Sliders
     * @param sId the id of sliders
     * @param sImage Relative path for image
     * @param sTitle the title about product sliders
     * @param sSubtitle the subtitle about product sliders
     * @param sDescription the description for product of sliders
     * @param pId the id of product
     */
    public Sliders(int sId, String sImage, String sTitle, String sSubtitle, String sDescription, int pId) {
        this.sId = sId;
        this.sImage = sImage;
        this.sTitle = sTitle;
        this.sSubtitle = sSubtitle;
        this.sDescription = sDescription;
        this.pId = pId;
    }

    /**
     * Gets the id of sliders
     * @return the id of object sliders
     */
    public int getsId() {
        return sId;
    }

    /**
     * Sets id for sliders
     * @param sId the id of sliders
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
     * Gets the image of sliders
     * @return the image of object sliders
     */
    public String getsImage() {
        return sImage;
    }

    /**
     * Sets image for sliders
     * @param sImage Relative path for image
     */
    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    /**
     * Gets title of sliders
     * @return the title of object sliders
     */
    public String getsTitle() {
        return sTitle;
    }

    /**
     * Sets title for sliders
     * @param sTitle the title about product sliders
     */ 
    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    /**
     * Gets the subtitle of sliders
     * @return the subtitle of object sliders
     */
    public String getsSubtitle() {
        return sSubtitle;
    }

    /**
     * Sets subtitle for sliders
     * @param sSubtitle the subtitle about product sliders
     */
    public void setsSubtitle(String sSubtitle) {
        this.sSubtitle = sSubtitle;
    }

    /**
     * Gets description of sliders
     * @return the description of object sliders
     */
    public String getsDescription() {
        return sDescription;
    }

    /**
     * Sets description for sliders
     * @param sDescription the description for product of sliders
     */
    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
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
    
}
