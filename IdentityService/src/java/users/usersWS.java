/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static users.login.connectDB;

/**
 *
 * @author Mujahid Suriah
 */
@WebService(serviceName = "usersWS")
public class usersWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserData")
    public ArrayList<users> getUserData(@WebParam(name = "token") final String token) throws ClassNotFoundException {
        Statement st;
        ArrayList<users> listUser = new ArrayList<>();
        try {
            st = connectDB().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE access_token='"+token+"'");
            connectDB().close();
            while (rs.next()) {
                listUser.add(new users (rs.getString("userid"),
                                        rs.getString("username"),
                                        rs.getString("fullname"),
                                        rs.getString("email"),
                                        rs.getString("address"),
                                        rs.getString("postal"),
                                        rs.getString("phone"),
                                        rs.getString("likes")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(usersWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isTokenValid")
    public Boolean isTokenValid(@WebParam(name = "token") final String token) throws ClassNotFoundException, ParseException {
        Statement st;
        try {
            st = connectDB().createStatement();
                ResultSet rs = st.executeQuery("SELECT expiredate FROM users WHERE access_token='"+token+"'");
            connectDB().close();
            if (rs.next()) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                System.out.println(rs.getString("expiredate"));

                long msDiff = parseDate(rs.getString("expiredate")).getTime() - 
                        parseDate(dateFormat.format(date)).getTime();
                System.out.println("msdiff " +msDiff);
                return msDiff > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(usersWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private Date parseDate(String dateString) throws ParseException {
        System.out.println(dateString);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date  date = df.parse(dateString);
        return date;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addLike")
    public Integer addLike(@WebParam(name = "access_token") final String access_token, @WebParam(name = "catalogid") final String catalogid, @WebParam(name = "action") final String action) {
        String cid="";
        if (action.equals("like")) {
            Statement st;
            try {
                st = connectDB().createStatement();
                ResultSet rs = st.executeQuery("SELECT likes FROM users WHERE access_token='"+access_token+"'");
                while(rs.next()) {
                    cid  = rs.getString("likes");
                }
                connectDB().close();
                st.close();
                System.out.println(access_token);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(usersWS.class.getName()).log(Level.SEVERE, null, ex);
            }
            cid += catalogid;
            cid += ";";
        }
        else {
            Statement st;
            String tempCatalogid="";
            try {
                st = connectDB().createStatement();
                ResultSet rs = st.executeQuery("SELECT likes FROM users WHERE access_token='"+access_token+"'");
                while(rs.next()) {
                   tempCatalogid = rs.getString("likes");
                }
                st.close();
                connectDB().close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(usersWS.class.getName()).log(Level.SEVERE, null, ex);
            }
            cid = catalogid;
            cid = tempCatalogid.replace(cid+";", "");
        }
        PreparedStatement pre;
        try {
            pre = connectDB().prepareStatement("UPDATE users SET likes='"+cid+"' "
                    + "WHERE access_token='"+access_token+"'");
            int i = pre.executeUpdate();
            pre.close();
            connectDB().close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(usersWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
