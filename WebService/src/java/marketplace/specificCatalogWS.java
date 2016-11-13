/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static marketplace.marketplace.connectDB;

/**
 *
 * @author Mujahid Suriah
 */
@WebService(serviceName = "specificCatalogWS")
public class specificCatalogWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSpecificCatalog")
    public ArrayList<marketplace> getSpecificCatalog(@WebParam(name = "catalogid") final int catalogid) throws ClassNotFoundException {
        ArrayList<marketplace> catalogList = new ArrayList<>();
        try {
            try (Statement st = connectDB().createStatement ()) {
                String query = "SELECT * FROM catalog WHERE catalogid="+catalogid;
                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        catalogList.add (new marketplace (rs.getInt("catalogid"),
                                rs.getString("catalogname"),
                                rs.getInt("catalogprice"),
                                rs.getString("catalogdesc"),
                                rs.getInt ("catalogliked"),
                                rs.getString("catalogtimestamp"),
                                rs.getInt ("catalogsold"),
                                rs.getString("catalogphoto"),
                                rs.getString("userid"),
                                rs.getString("userfullname"),
                                rs.getString("uname_seller")));
                    }
                }
            }
            connectDB().close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return catalogList;
    }
    
    @WebMethod(operationName = "addLike")
    public Integer addLike(@WebParam(name = "catalogid") final String catalogid, @WebParam(name = "action") final String action) {
        PreparedStatement pre;
        try {
            if (action.equals("like")) {
                pre = connectDB().prepareStatement("UPDATE catalog SET catalogliked=catalogliked+1 "
                        + "WHERE catalogid='"+catalogid+"'");
            }
            else {
                pre = connectDB().prepareStatement("UPDATE catalog SET catalogliked=catalogliked-1 "
                        + "WHERE catalogid='"+catalogid+"'");
            }
            int i = pre.executeUpdate();
            pre.close();
            connectDB().close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("exception");
            Logger.getLogger(specificCatalogWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
