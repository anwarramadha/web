/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

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
        
        System.out.println("check");
        String[] input = new String[7];
        input[0] = request.getParameter("name");
        input[1] = request.getParameter("username");
        input[2] = request.getParameter("email");
        input[3] = request.getParameter("password");
        input[4] = request.getParameter("address");
        input[5] = request.getParameter("postal");
        input[6] = request.getParameter("phone");
        PrintWriter out = response.getWriter();
        try {
            PreparedStatement pre;
            pre = connectDB().prepareStatement (
                    "INSERT INTO users (fullname, username, email, pass, address, postal, phone, likes) "
                            + "values (?,?,?,?,?,?,?,?)");
            
            pre.setString(1,input[0]);
            pre.setString(2,input[1]);
            pre.setString(3,input[2]);
            pre.setString(4,input[3]);
            pre.setString(5,input[4]);
            pre.setString(6,input[5]);
            pre.setString(7,input[6]);
            pre.setString(8,";");
            int i = pre.executeUpdate();
            connectDB().close();
            Statement st = connectDB().createStatement();
            ResultSet rs = st.executeQuery("SELECT userid, fullname, username, pass FROM users WHERE username='"+input[1]+"'");
            connectDB().close();
            while(rs.next()) {
                login log = new login();
                log.doLogin (rs.getString("username"), rs.getString("pass"));
                usersWS uw = new usersWS();
                if (uw.isTokenValid(login.access_token)) {
                    Cookie cookie = new Cookie("login", login.access_token);
                    response.addCookie(cookie);
                    response.sendRedirect("http://localhost:8080/Client/catalog.jsp?access_token="+login.access_token);
                }
                else {
                    response.sendRedirect("http://localhost:8080/Client/login.jsp?valid=false");
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("http://localhost:8080/Client/register.jsp?valid=false");
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
