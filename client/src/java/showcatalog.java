/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import marketplace.ClassNotFoundException_Exception;
import marketplace.Marketplace;
import marketplace.MarketplaceWS_Service;
import users.UsersWS_Service;

/**
 *
 * @author Mujahid Suriah
 */
@WebServlet(urlPatterns = {"/showcatalog"})
public class showcatalog extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/IdentityService/usersWS.wsdl")
    private UsersWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/WebService/marketplaceWS.wsdl")
    private MarketplaceWS_Service service;
    private String keyword="";
    private String  by = "";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String uid="";
    String access_token="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        keyword = request.getParameter("name");
        by = request.getParameter("filter");
        response.setContentType("text/html;charset=UTF-8");
        access_token = request.getParameter("access_token");
        Cookie cookie = new Cookie("login", access_token);
        response.addCookie(cookie);
        try { int i = 1; java.util.List<users.Users> result = getUserData(access_token);
            for (users.Users res : result) {
                uid = res.getUserid();
            } 
        } catch (Exception ex) { 
            out.print("Exception: " + ex); 
        }
        final ArrayList<String> like = like();
        for(String str : like) System.out.print(str);
        try (PrintWriter out = response.getWriter()) {
            try { int i = 1; java.util.List<Marketplace> result = getCatalog(keyword, by);
            result.forEach(new Consumer<Marketplace>() {
                @Override
                public void accept(Marketplace answer) {
                    String color = "rgb(74, 134 ,232)";
                    char liked = 'n';
                    String set_like = "LIKE";
                    if (like.contains(Integer.toString(answer.getCatalogid()))) {
                        color = "rgb(152, 0, 0)";
                        liked = 'y';
                        set_like = "LIKED";
                    } else {
                    }
                    String date = null;
                    try {
                        date = parseDate(answer.getCatalogtimestamp());
                    } catch (ParseException ex) {
                        out.print("ini yang e");
                        Logger.getLogger(showcatalog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    out.print("<br><br><form role=\"form\" action=\"\" enctype=\"multipart/form-data\"><span class=\"market\"><b>"+answer.getUserfullname()+"</b></span>\n" +
                            "		<br>\n" +
                            "		<span class=\"date-added\">added this on "+date);
                    out.print("<hr class=\"catalog-hr\">\n" +
"                               <br>\n" +
"                               <img class=\"catalog-img\" src=\"images/"+answer.getCatalogphoto()+"\"></img>");
                    out.print("<span class=\"product-name\"><b>"+answer.getCatalogname()+"</b></span><br><br>");
                    out.print("<span class=\"product-cost\">IDR "+currency(answer.getCatalogprice())+"</span>");
                    out.print("<span class=\"catalog-likes\" id=\"catalog-likes"+answer.getCatalogid()+"\">"+answer.getCatalogliked()+" like</span><br><br>");
                    out.print("<span class=\"product-desc\">"+answer.getCatalogdesc()+"</span>");
                    out.print("<span class=\"catalog-purchase\">"+answer.getCatalogsold()+" purchase</span><br><br>");
                    out.print("<span class=\"buy-catalog\"><a href=\"confirm.jsp?id_product="+answer.getCatalogid()
                            + "&access_token="+access_token+"\" name=\"buy\"><b>BUY</b></a></span>");
                    out.print("<span class=\"like-catalog\"><a href=\"javascript:void(0)\" onclick=\"liked(this.name)\" name=\"click-like"+answer.getCatalogid()+"-"+liked+"\"\n" +
"                       id=\"click-like"+answer.getCatalogid()+"-a\" style=\"color:"+color+";\" href=\"\"><b>"+set_like+"</b></a></span><br><br><br><hr>");
                    out.print("<input id=\"click-like"+answer.getCatalogid()+"-"+liked+"\" type=\"hidden\" value=\""+answer.getCatalogid()+"\"></form>");
                    out.print("<input id='like"+answer.getCatalogid()+"' value='"+answer.getCatalogliked()+"' type='hidden'>");
                }   
                
            }); 
            } catch (Exception ex) { 
                out.print("haloException: " + ex); 
            }
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
    
    private ArrayList<String> like() {
        String suka="";
        try { int i = 1; java.util.List<users.Users> result = getUserData(access_token);
            for (users.Users res : result) {
                suka = res.getLikes();
            } 
        } catch (users.ClassNotFoundException_Exception ex) { 
            System.out.print("exception");
            out.print("Exception: " + ex); 
        }
        ArrayList<String> liked = new ArrayList<>();
        if (suka.length() > 1) {
            int finddotcomma = 0;
            int nextdotcomma = suka.indexOf(";", finddotcomma + 1);
            System.out.print(nextdotcomma);
            liked.add(suka.substring(finddotcomma+1, nextdotcomma-finddotcomma));
            finddotcomma = nextdotcomma;
            while (finddotcomma < suka.length()) {
                System.out.print("next "+nextdotcomma+" curr "+finddotcomma);
                if (finddotcomma+1<suka.length()) {
                    nextdotcomma = suka.indexOf(";", finddotcomma+1);
                liked.add(suka.substring(finddotcomma+1, nextdotcomma));
                finddotcomma = nextdotcomma;
                }
                else break;
            }
        }
        return liked;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    

    private java.util.List<users.Users> getUserData(java.lang.String token) throws users.ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        users.UsersWS port = service_1.getUsersWSPort();
        return port.getUserData(token);
    }

    private java.util.List<marketplace.Marketplace> getCatalog(java.lang.String keyword, java.lang.String by) throws ClassNotFoundException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplace.MarketplaceWS port = service.getMarketplaceWSPort();
        return port.getCatalog(keyword, by);
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
}
