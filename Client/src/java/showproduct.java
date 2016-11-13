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
import java.util.ArrayList;
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
import marketplace.Marketplace;
import marketplace.MarketplaceWS_Service;
import marketplace.MyproductWS_Service;

/**
 *
 * @author adesu
 */
@WebServlet(urlPatterns = {"/showproduct"})
public class showproduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/WebService/myproductWS.wsdl")
    private MyproductWS_Service service;
    
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
        //out.print("<h1> TES AJA <h1>");
        //request.getValue("login");
        String id = request.getParameter("id");
        String token = request.getParameter("access_token");
        System.out.println("id = "+id+", access_token = "+token);
//tok = response.getValue();
        try (PrintWriter out = response.getWriter()) {
        
        java.util.List<marketplace.Marketplace> result;
        result = (java.util.List<marketplace.Marketplace>)myproduct(id);
        //System.out.println("method myproduct pass");
        result.forEach(new Consumer<Marketplace>() {
            @Override
            public void accept(Marketplace answer) {
                String date = null;
                try {
                    date = parseDate(answer.getCatalogtimestamp());
                } catch (ParseException ex) {
                    Logger.getLogger(showproduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Masuk Method dan id_user = " + id + ", token = " + token);
                out.print("<br><br><form role=\"form\" action=\"\" enctype=\"multipart/form-data\">");
                out.print("<span class=\"market\"><b>"+answer.getUserfullname()+"</b></span>");
                out.print("<br>" + "<span class=\"date-added\">added this on " + date);
                out.print("<hr class=\"catalog-hr\">" +"<br>" +"<img class=\"catalog-img\" src=\"images/"+answer.getCatalogphoto()+"\"></img>");
                out.print("<span class=\"product-name\"><b>"+answer.getCatalogname()+"</b></span><br><br>");
                out.print("<span class=\"product-cost\">IDR "+currency(answer.getCatalogprice())+"</span>");
                out.print("<span class=\"catalog-likes\" id=\"catalog-likes"+answer.getCatalogid()+"\">"+answer.getCatalogliked()+" like</span><br><br>");
                out.print("<span class=\"product-desc\">"+answer.getCatalogdesc()+"</span>");
                out.print("<span class=\"catalog-purchase\">"+answer.getCatalogsold()+" purchase</span><br><br>");
                out.print("<span class=\"edit-catalog\"><a href=\"edit.jsp?id_product="+answer.getCatalogid()
                        + "&access_token="+request.getParameter("access_token")+"\" name=\"product-edit\"><b>EDIT</b></a></span>");
                out.print("<span class=\"delete-catalog\"><a href=\"http://localhost:8080/Client/deleteproduct?id_product="+answer.getCatalogid()
                        + "&access_token="+request.getParameter("access_token")+"\" name=\"product-delete\"><b>DELETE</b></a></span>");
            }   
        });    
        //System.out.println("Show selesai");
        } catch (Exception ex) { 
                out.print("haloException: " + ex); 
            }
    }
    

     private String parseDate(String dateString) throws ParseException {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = formatter.parse(dateString);
                    formatter = new SimpleDateFormat("E, dd MM yyyy HH:mm");
                    return formatter.format(date);
                }

                private String currency(int price) {
                    StringBuilder strB= new StringBuilder();
                    strB.append(Integer.toString(price));
                    int count = 0;
                    for (int i = strB.length(); i > 0; i--) {
                        if (count==3) {
                            strB.insert(i, '.');
                            count=0;
                        }
                        count++;
                    }
                    String res = strB.toString();
                    return res;
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
            Logger.getLogger(showproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException_Exception ex) {
            System.out.println("class not found");
            Logger.getLogger(showproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private java.util.List<marketplace.Marketplace> myproduct(java.lang.String id) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplace.MyproductWS port = service.getMyproductWSPort();
        return port.myproduct(id);
    }

    


   
}
