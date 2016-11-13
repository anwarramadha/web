
package marketplace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for marketplace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="marketplace"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="catalogid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="catalogname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="catalogprice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="catalogdesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="catalogliked" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="catalogtimestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="catalogsold" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="catalogphoto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userfullname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uname_seller" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "marketplace", propOrder = {
    "catalogid",
    "catalogname",
    "catalogprice",
    "catalogdesc",
    "catalogliked",
    "catalogtimestamp",
    "catalogsold",
    "catalogphoto",
    "userid",
    "userfullname",
    "unameSeller"
})
public class Marketplace {

    protected int catalogid;
    @XmlElement(required = true)
    protected String catalogname;
    protected int catalogprice;
    @XmlElement(required = true)
    protected String catalogdesc;
    protected int catalogliked;
    @XmlElement(required = true)
    protected String catalogtimestamp;
    protected int catalogsold;
    @XmlElement(required = true)
    protected String catalogphoto;
    @XmlElement(required = true)
    protected String userid;
    @XmlElement(required = true)
    protected String userfullname;
    @XmlElement(name = "uname_seller", required = true)
    protected String unameSeller;

    /**
     * Gets the value of the catalogid property.
     * 
     */
    public int getCatalogid() {
        return catalogid;
    }

    /**
     * Sets the value of the catalogid property.
     * 
     */
    public void setCatalogid(int value) {
        this.catalogid = value;
    }

    /**
     * Gets the value of the catalogname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogname() {
        return catalogname;
    }

    /**
     * Sets the value of the catalogname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogname(String value) {
        this.catalogname = value;
    }

    /**
     * Gets the value of the catalogprice property.
     * 
     */
    public int getCatalogprice() {
        return catalogprice;
    }

    /**
     * Sets the value of the catalogprice property.
     * 
     */
    public void setCatalogprice(int value) {
        this.catalogprice = value;
    }

    /**
     * Gets the value of the catalogdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogdesc() {
        return catalogdesc;
    }

    /**
     * Sets the value of the catalogdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogdesc(String value) {
        this.catalogdesc = value;
    }

    /**
     * Gets the value of the catalogliked property.
     * 
     */
    public int getCatalogliked() {
        return catalogliked;
    }

    /**
     * Sets the value of the catalogliked property.
     * 
     */
    public void setCatalogliked(int value) {
        this.catalogliked = value;
    }

    /**
     * Gets the value of the catalogtimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogtimestamp() {
        return catalogtimestamp;
    }

    /**
     * Sets the value of the catalogtimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogtimestamp(String value) {
        this.catalogtimestamp = value;
    }

    /**
     * Gets the value of the catalogsold property.
     * 
     */
    public int getCatalogsold() {
        return catalogsold;
    }

    /**
     * Sets the value of the catalogsold property.
     * 
     */
    public void setCatalogsold(int value) {
        this.catalogsold = value;
    }

    /**
     * Gets the value of the catalogphoto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogphoto() {
        return catalogphoto;
    }

    /**
     * Sets the value of the catalogphoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogphoto(String value) {
        this.catalogphoto = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the userfullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserfullname() {
        return userfullname;
    }

    /**
     * Sets the value of the userfullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserfullname(String value) {
        this.userfullname = value;
    }

    /**
     * Gets the value of the unameSeller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnameSeller() {
        return unameSeller;
    }

    /**
     * Sets the value of the unameSeller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnameSeller(String value) {
        this.unameSeller = value;
    }

}
