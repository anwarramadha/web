/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static marketplace.addPurchase.connectDB;

/**
 *
 * @author adesu
 */
@WebService(serviceName = "addproductWS")
public class addproductWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "query") String query) {
        //TODO write your implementation code here:
        try{
            PreparedStatement presql = connectDB().prepareStatement(query);
           
            int x = presql.executeUpdate();
            System.out.println(x);
            connectDB().close();
            System.out.println("Query success pass");
            
        }catch(ClassNotFoundException | SQLException e){
            Object ex = null;
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exception" + e);
        }
        return "";
    }
}
