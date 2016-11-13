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
@WebService(serviceName = "purchasesWS")
public class purchasesWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPurchases")
    public ArrayList<Purchases> getPurchases(@WebParam(name = "username") final String username) throws ClassNotFoundException {
        ArrayList<Purchases> purchasesList = new ArrayList<>();
        try {
            try (Statement st = connectDB().createStatement ()) {
                String query = "SELECT * FROM purchases WHERE uname_buyer='" + username + "' ORDER BY timestamp DESC;";
                System.out.println("jalan");
                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        purchasesList.add (new Purchases(
                            rs.getInt("purchaseid"),
                            rs.getString("uname_buyer"),
                            rs.getString("uname_seller"),
                            rs.getString("catalogname"),
                            rs.getInt("catalogprice"),
                            rs.getString("catalogphoto"),
                            rs.getString("fullname"),
                            rs.getString("address"),
                            rs.getString("postal"),
                            rs.getString("phone"),
                            rs.getString("creditcard"),
                            rs.getString("verification_number"),
                            rs.getInt("quantity"),
                            rs.getString("timestamp")));
                    }
                }
            }
            connectDB().close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return purchasesList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSales")
    public ArrayList<Purchases> getSales(@WebParam(name = "username") final String username) throws ClassNotFoundException {
        ArrayList<Purchases> salesList = new ArrayList<>();
        try {
            try (Statement st = connectDB().createStatement ()) {
                String query = "SELECT * FROM purchases WHERE uname_seller='" + username + "' ORDER BY timestamp DESC;";
                System.out.println("jalan");
                try (ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        salesList.add (new Purchases(
                            rs.getInt("purchaseid"),
                            rs.getString("uname_buyer"),
                            rs.getString("uname_seller"),
                            rs.getString("catalogname"),
                            rs.getInt("catalogprice"),
                            rs.getString("catalogphoto"),
                            rs.getString("fullname"),
                            rs.getString("address"),
                            rs.getString("postal"),
                            rs.getString("phone"),
                            rs.getString("creditcard"),
                            rs.getString("verification_number"),
                            rs.getInt("quantity"),
                            rs.getString("timestamp")));
                    }
                }
            }
            connectDB().close();
        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return salesList;
    }
}
