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
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static jdk.nashorn.internal.runtime.Debug.id;
import static marketplace.marketplace.connectDB;

/**
 *
 * @author adesu
 */
@WebService(serviceName = "deleteproductWS")
public class deleteproductWS {

    /**
     * This is a sample web service operation
     */
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteproduct")
    public String deleteproduct(@WebParam(name = "catalogid") final int id) throws ClassNotFoundException{
        //TODO write your implementation code here:
            String idcatalog = Integer.toString(id);
            System.out.println("delete product in WS");
            //try(Statement st = connectDB().createStatement()){
            String Query = "DELETE FROM catalog WHERE catalogid=" + idcatalog + ";";
            try {
                PreparedStatement pre;
                pre = connectDB().prepareStatement (Query);
                int i = pre.executeUpdate();
                System.out.println("pass Query");
                connectDB().close();
            }catch(Exception e){
                System.out.println(e);
            }
            
        return "";
    }

    private String parseToString(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
