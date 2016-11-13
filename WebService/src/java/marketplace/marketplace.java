/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Mujahid Suriah
 */
@XmlRootElement (name = "marketplace")
public class marketplace {
    @XmlElement(name="catalogid", required=true)
    private final int catalogid;
    @XmlElement (name="catalogname", required=true)
    private final String catalogname;
    @XmlElement (name="catalogprice", required=true)
    private final int catalogprice;
    @XmlElement (name="catalogdesc", required=true)
    private final String catalogdesc;
    @XmlElement (name="catalogliked", required=true)
    private final int catalogliked;
    @XmlElement (name="catalogtimestamp", required=true)
    private final String catalogtimestamp;
    @XmlElement (name="catalogsold", required=true)
    private final int catalogsold;
    @XmlElement (name="catalogphoto", required=true)
    private final String catalogphoto;
    @XmlElement (name="userid", required=true)
    private final String userid;
    @XmlElement (name="userfullname", required=true)
    private final String userfullname;
    @XmlElement (name="uname_seller", required=true)
    private final String uname_seller;
    //konstruktor
    public marketplace() {
        catalogid = 0;
        catalogname = "";
        catalogprice = 0;
        catalogdesc = "";
        catalogliked = 0;
        catalogtimestamp = "";
        catalogsold = 0;
        catalogphoto = "";
        userid = "";
        userfullname = "";
        uname_seller = "";
    }

    public marketplace(int cid, String cname, int cprice, String cdes, int clike, 
            String ctime, int csold, String cphoto, String uid, String username, String us) {
        catalogid = cid;
        catalogname = cname;
        catalogprice = cprice;
        catalogdesc = cdes;
        catalogliked = clike;
        catalogtimestamp = ctime;
        catalogsold = csold;
        catalogphoto = cphoto;
        userid = uid;
        userfullname = username;
        uname_seller = us;
    }
    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/marketplace?user=root&password=root");
        return conn;
    }
}
