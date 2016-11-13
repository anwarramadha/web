
package marketplace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for purchases complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="purchases"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="purchaseid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="uname_buyer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uname_seller" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="catalogname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="catalogprice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="catalogphoto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fullname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postal" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="creditcard" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="verification_number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purchases", propOrder = {
    "purchaseid",
    "unameBuyer",
    "unameSeller",
    "catalogname",
    "catalogprice",
    "catalogphoto",
    "fullname",
    "address",
    "postal",
    "phone",
    "creditcard",
    "verificationNumber",
    "quantity",
    "timestamp"
})
public class Purchases {

    protected int purchaseid;
    @XmlElement(name = "uname_buyer", required = true)
    protected String unameBuyer;
    @XmlElement(name = "uname_seller", required = true)
    protected String unameSeller;
    @XmlElement(required = true)
    protected String catalogname;
    protected int catalogprice;
    @XmlElement(required = true)
    protected String catalogphoto;
    @XmlElement(required = true)
    protected String fullname;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected String postal;
    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    protected String creditcard;
    @XmlElement(name = "verification_number", required = true)
    protected String verificationNumber;
    protected int quantity;
    @XmlElement(required = true)
    protected String timestamp;

    /**
     * Gets the value of the purchaseid property.
     * 
     */
    public int getPurchaseid() {
        return purchaseid;
    }

    /**
     * Sets the value of the purchaseid property.
     * 
     */
    public void setPurchaseid(int value) {
        this.purchaseid = value;
    }

    /**
     * Gets the value of the unameBuyer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnameBuyer() {
        return unameBuyer;
    }

    /**
     * Sets the value of the unameBuyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnameBuyer(String value) {
        this.unameBuyer = value;
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
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the postal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Sets the value of the postal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostal(String value) {
        this.postal = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the creditcard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditcard() {
        return creditcard;
    }

    /**
     * Sets the value of the creditcard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditcard(String value) {
        this.creditcard = value;
    }

    /**
     * Gets the value of the verificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationNumber() {
        return verificationNumber;
    }

    /**
     * Sets the value of the verificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationNumber(String value) {
        this.verificationNumber = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

}
