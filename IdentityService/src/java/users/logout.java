/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static users.login.connectDB;

/**
 *
 * @author Mujahid Suriah
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {

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
        try {
            PreparedStatement pre;
            Cookie[] cookies = request.getCookies();
            String access_token="";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login"))
                    access_token=cookie.getValue();
            }
            pre = connectDB().prepareStatement("UPDATE users SET access_token='' "
                    + "WHERE access_token='"+access_token+"'");
            int i = pre.executeUpdate();
            connectDB().close();
            response.sendRedirect("http://localhost:8080/Client/login.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(logout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
