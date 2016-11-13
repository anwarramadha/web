/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mujahid Suriah
 */
@WebServlet(name = "addPurchase", urlPatterns = {"/addPurchase"})
public class addPurchase extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PreparedStatement pre = connectDB().prepareStatement("INSERT INTO purchases "
                    + "(catalogname, catalogprice, "
                    + "catalogphoto, fullname, uname_buyer, address, postal, phone, creditcard, "
                    + "verification_number, quantity, uname_seller, timestamp)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pre.setString(1, request.getParameter("catalogname"));
            pre.setString(2, request.getParameter("price"));
            pre.setString(3, request.getParameter("catalogphoto"));
            pre.setString(4, request.getParameter("consigne"));
            pre.setString(5, request.getParameter("username"));
            pre.setString(6, request.getParameter("address"));
            pre.setString(7, request.getParameter("postal"));
            pre.setString(8, request.getParameter("phone"));
            pre.setString(9, request.getParameter("credit-card"));
            pre.setString(10, request.getParameter("verf"));
            pre.setString(11, request.getParameter("quantity"));
            pre.setString(12, request.getParameter("unameseller"));
            pre.setString(13, getDateNow());
            int i = pre.executeUpdate();
            connectDB().close();
            PreparedStatement pre1 = connectDB().prepareStatement("UPDATE catalog "
                    + "SET catalogsold=catalogsold+"+request.getParameter("quantity")+" "
                            + "WHERE catalogid="+ request.getParameter("product-id"));
            i = pre1.executeUpdate();
            connectDB().close();
            response.sendRedirect("http://localhost:8080/Client/catalog.jsp?access_token="+request.getParameter("access_token")+"&purchased=true");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addPurchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/marketplace?user=root&password=root");
        return conn;
    }
    
    private String getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());
        return date;
    }
}
