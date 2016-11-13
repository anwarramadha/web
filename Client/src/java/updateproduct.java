/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import marketplace.UpdateProductWS_Service;

/**
 *
 * @author adesu
 */
@WebServlet(urlPatterns = {"/updateproduct"})
public class updateproduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/WebService/updateProductWS.wsdl")
    private UpdateProductWS_Service service;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
            System.out.println("update product");
            String id = request.getParameter("id_product");
            System.out.println("id = " + id);
            String namaproduk = request.getParameter("namaproduk");
            System.out.println("namaproduk = " + namaproduk);
            String harga = request.getParameter("harga");
            String deskripsi = request.getParameter("deskripsi");
            //String s = updateProduct(id,deskripsi,namaproduk,harga);
            String query = "UPDATE catalog SET catalogname='"+ namaproduk +"',catalogprice="+ harga +",catalogdesc='"+ deskripsi +"' WHERE catalogid=" + id + ";";
            try {
                PreparedStatement pre;
                pre = connectDB().prepareStatement (query);
                int i = pre.executeUpdate();
                System.out.println("pass Query");
                connectDB().close();
            }catch(Exception e){
                System.out.println("exception" + e);
            }
            System.out.println("Query valid");
            response.sendRedirect("http://localhost:8080/Client/product.jsp?access_token="+request.getParameter("access_token"));
        
    }

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/marketplace?user=root&password=root");
        return conn;
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private String updateProduct(java.lang.String id, java.lang.String des, java.lang.String namaproduk, java.lang.String harga) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplace.UpdateProductWS port = service.getUpdateProductWSPort();
        return port.updateProduct(id, des, namaproduk, harga);
    }

    

    

}
