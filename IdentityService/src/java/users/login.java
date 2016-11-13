/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mujahid Suriah
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
    private boolean isValid;
    public static String access_token;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

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
        //processRequest(request, response);
        isValid=false;
        String uname, pass;
        uname = request.getParameter("username");
        pass = request.getParameter("password");
        doLogin(uname, pass);
        if (isValid) {
            Cookie cookie = new Cookie("login", access_token);
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8080/Client/catalog.jsp?access_token="+access_token);
        }
        else {
            response.sendRedirect("http://localhost:8080/Client/login.jsp?valid=false");
        }
    }
    
    
    public static Connection connectDB() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
        try {
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/users?user=root&password=root");
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void redirect() {
        
    }
    public void doLogin (String uname, String pass) throws IOException {
        try {
            try (Statement st = connectDB().createStatement()) {
                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE email='"+uname+"' "
                        + "AND pass='"+pass+"'");
                if (rs.next()) {
                String userid = rs.getString("userid");
                    access_token = getSaltString();
                    ResultSet ars = st.executeQuery("SELECT count(*) FROM users WHERE access_token ='"
                            + access_token +"'");
                    while (!isUnique(ars)) {
                        access_token = getSaltString();
                        ars = st.executeQuery("SELECT count(*) FROM users WHERE access_token ='"
                                + access_token +"'");
                    }
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.MINUTE, 20);
                    String date = dateFormat.format(cal.getTime());
                    System.out.println(dateFormat.format(cal.getTime()));
                    PreparedStatement pre;
                    pre = connectDB().prepareStatement("UPDATE users SET access_token = ?, "
                            + " expiredate = ? WHERE userid = ?");
                    pre.setString(1, access_token);
                    pre.setString(2, date);
                    pre.setString(3, userid);
                    pre.executeUpdate();
                    pre.close();
                    isValid = true;
                }
                else {
                    System.out.println("null");
                    isValid = false;
                }
                rs.close();
            }
            connectDB().close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("exception");
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    private boolean isUnique (ResultSet rs) throws SQLException {
        while (rs.next()) {
            if (rs.getInt(1) == 0) return true;
        }
        return false;
    }
  
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
