/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import marketplace.ClassNotFoundException_Exception;
import marketplace.Purchases;
import marketplace.PurchasesWS_Service;
import users.UsersWS_Service;

/**
 *
 * @author Mujahid Suriah
 */
@WebServlet(urlPatterns = {"/showsales"})
public class showsales extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/IdentityService/usersWS.wsdl")
    private UsersWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/WebService/purchasesWS.wsdl")
    private PurchasesWS_Service service;
    
    String uname = "";
    String access_token = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        access_token = request.getParameter("access_token");
        try { int i = 1; java.util.List<users.Users> result = getUserData(access_token);
            for (users.Users res : result) {
                uname = res.getUsername();
                System.out.println("username = " + uname);
            }
        } catch (Exception ex) { 
            out.print("Exception: " + ex); 
        }
        try (PrintWriter out = response.getWriter()) {
            try {
                java.util.List<Purchases> result = getSales(uname);
                System.out.println("try");
                result.forEach(new Consumer<Purchases>() {
                    @Override
                    public void accept(Purchases answer) {
                        String date = null;
                        String time = null;
                        try {
                            date = parseDate(answer.getTimestamp());
                        } catch (ParseException ex) {
                            out.print("ini yang e");
                            Logger.getLogger(showsales.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            time = parseTime(answer.getTimestamp());
                        } catch (ParseException ex) {
                            out.print("ini yang e");
                            Logger.getLogger(showsales.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.print("<br><br><form role=\"form\" action=\"\" enctype=\"multipart/form-data\" class=\"market\">"
                                + "<span class=\"date-added\"><b>" + date + "</b><br>at " + time + "</span>"
                                + "<hr class=\"catalog-hr\"><br><table class=\"content\"><tr><td style=\"width: 205px\">"
                                + "<img class=\"catalog-img\" src=\"images/" + answer.getCatalogphoto() + "\"></img></td>"
                                + "<td style=\"width: 250px\"><span class=\"sales-info\"><b>" + answer.getCatalogname()
                                + "</b><br>IDR " + answer.getCatalogprice()*answer.getQuantity() + "<br>"
                                + answer.getQuantity() + " pcs<br>@IDR "+ answer.getCatalogprice() + "</span><br><br><br>"
                                + "<span class=\"product-buyer\">bought by <b>" + answer.getUnameBuyer() + "</b></span>"
                                + "</td><td><span class=\"delivery\">Delivery to <b>" + answer.getFullname() + "</b><br>"
                                + answer.getAddress() + "<br>" + answer.getPostal() + "<br>" + answer.getPhone()
                                + "</span></td></tr></table><br><br><hr></form>");
                    }   
                });
                System.out.println("pass");
            } catch (Exception ex) { 
                out.print("haloException: " + ex); 
            }
        }
    }

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
            processRequest(request, response);
        } catch (ClassNotFoundException_Exception ex) {
            System.out.println("class not found");
            Logger.getLogger(showpurchases.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException_Exception ex) {
            System.out.println("class not found");
            Logger.getLogger(showpurchases.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private java.util.List<marketplace.Purchases> getSales(java.lang.String username) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplace.PurchasesWS port = service.getPurchasesWSPort();
        return port.getSales(username);
    }

    private java.util.List<users.Users> getUserData(java.lang.String token) throws users.ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        users.UsersWS port = service_1.getUsersWSPort();
        return port.getUserData(token);
    }
    
    private String parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(dateString);
        formatter = new SimpleDateFormat("E, dd MM yyyy");
        return formatter.format(date);
    }
    
    private String parseTime(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(dateString);
        formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
    }

}