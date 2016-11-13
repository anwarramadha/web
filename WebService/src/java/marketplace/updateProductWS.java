/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static marketplace.addPurchase.connectDB;
import static marketplace.marketplace.connectDB;

/**
 *
 * @author adesu
 */
@WebService(serviceName = "updateProductWS")
public class updateProductWS {

    /**
     * This is a sample web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateProduct")
    public String updateProduct(@WebParam(name = "id") final String id,@WebParam(name = "des") final String des,
            @WebParam(name = "namaproduk") final String namaproduk,@WebParam(name = "harga") final String harga) {
        //TODO write your implementation code here:
        System.out.println("update product di ws");
         String query = "UPDATE catalog SET catalogname="+ namaproduk +",description="+ des +",price="+ harga +" WHERE catalogid=" + id + ";";
            try {
                PreparedStatement pre;
                pre = connectDB1().prepareStatement (query);
                int i = pre.executeUpdate();
                System.out.println("pass Query");
                connectDB1().close();
            }catch(Exception e){
                System.out.println(e);
            }
        return "";
    }
    public static Connection connectDB1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/marketplace?user=root&password=root");
        return conn;
    }
}
