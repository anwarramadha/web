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
 * @author adesu
 */
@WebService(serviceName = "myproductWS")
public class myproductWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "myproduct")
    public ArrayList<marketplace> myproduct(@WebParam(name="id") final String id) throws ClassNotFoundException {
        System.out.println("masuk myproduct");
//TODO write your implementation code here:
        ArrayList<marketplace> product = new ArrayList<>();
        
        try(
            Statement st = connectDB().createStatement ()){
            
            String query="SELECT * FROM catalog WHERE userid=" + id +";";
            try (
                ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println("terkoneksi");
                    product.add (new marketplace (
                            rs.getInt("catalogid"),
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
                System.out.println(rs.getString("catalogname") + " dijual " + rs.getString("uname_seller"));
            }
            connectDB().close();
        }catch(SQLException e){
            System.err.println("exception");
            System.err.println(e.getMessage());
        }
        return product;
    }   
}
