/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static marketplace.marketplace.connectDB;

/**
 *
 * @author Mujahid Suriah
 */
@WebService(serviceName = "marketplaceWS")
public class marketplaceWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCatalog")
    public ArrayList<marketplace> getCatalog(@WebParam(name = "keyword") final String keyword, @WebParam(name = "by") final String by) throws ClassNotFoundException {
        ArrayList<marketplace> catalogList = new ArrayList<>();
        try {
            try (Statement st = connectDB().createStatement ()) {
                String query = "";
                System.out.println("jalan");
                switch (by) {
                    case "product":
                        if (keyword.equals("\"\"")) query = "SELECT * FROM catalog ORDER BY catalogtimestamp ASC";
                        else query = "SELECT * FROM catalog WHERE catalogname LIKE '%"+keyword+"%' ORDER BY catalogtimestamp ASC";
                        break;
                    case "store":
                        if (keyword.equals("\"\"")) query = "SELECT * FROM catalog ORDER BY catalogtimestamp ASC";
                        else query = "SELECT * FROM catalog WHERE userfullname LIKE '%"+keyword+"%' ORDER BY catalogtimestamp ASC";
                        break;
                    default:
                        System.out.println("if null");
                        if (keyword.equals("\"\"")) query = "SELECT * FROM catalog ORDER BY catalogtimestamp ASC";
                        else query = "SELECT * FROM catalog WHERE userfullname LIKE '%"+keyword+"%' "
                                + "OR catalogname LIKE '%"+keyword+"%' ORDER BY catalogtimestamp ASC";
                        break;
                }
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
}
