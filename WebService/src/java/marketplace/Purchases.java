/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Atika Firdaus
 */
@XmlRootElement (name = "Purchases")
public class Purchases {
    @XmlElement(name="purchaseid", required=true)
    private final int purchaseid;
    @XmlElement(name="uname_buyer", required=true)
    private final String uname_buyer;
    @XmlElement(name="uname_seller", required=true)
    private final String uname_seller;
    @XmlElement (name="catalogname", required=true)
    private final String catalogname;
    @XmlElement (name="catalogprice", required=true)
    private final int catalogprice;
    @XmlElement (name="catalogphoto", required=true)
    private final String catalogphoto;
    @XmlElement (name="fullname", required=true)
    private final String fullname;
    @XmlElement (name="address", required=true)
    private final String address;
    @XmlElement (name="postal", required=true)
    private final String postal;
    @XmlElement (name="phone", required=true)
    private final String phone;
    @XmlElement (name="creditcard", required=true)
    private final String creditcard;
    @XmlElement (name="verification_number", required=true)
    private final String verification_number;
    @XmlElement (name="quantity", required=true)
    private final int quantity;
    @XmlElement(name="timestamp", required=true)
    private final String timestamp;
    
    //konstruktor
    public Purchases() {
        purchaseid = 0;
        uname_buyer = "";
        uname_seller = "";
        catalogname = "";
        catalogprice = 0;
        catalogphoto = "";
        fullname = "";
        address = "";
        postal = "";
        phone = "";
        creditcard = "";
        verification_number = "";
        quantity = 0;
        timestamp = "";
    }

    //konstruktor
    public Purchases(int pid, String ubuyer, String useller, String cname, int cprice, String cphoto, String fname, String addr, String post, String phonenum, String cc, String verif_num, int quant, String time) {
        purchaseid = pid;
        uname_buyer = ubuyer;
        uname_seller = useller;
        catalogname = cname;
        catalogprice = cprice;
        catalogphoto = cphoto;
        fullname = fname;
        address = addr;
        postal = post;
        phone = phonenum;
        creditcard = cc;
        verification_number = verif_num;
        quantity = quant;
        timestamp = time;
    }

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/marketplace?user=root&password=root");
        return conn;
    }
    
}