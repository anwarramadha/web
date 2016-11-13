/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static marketplace.addPurchase.connectDB;

/**
 *
 * @author adesu
 */
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50,
                 location="") 

public class addProduct extends HttpServlet {

   

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
            String appPath = request.getServletContext().getRealPath("");
        String SAVE_DIR ="images/";
         String savePath = appPath +File.separator + SAVE_DIR;
          String s = parse(savePath);
          System.out.println("appPath = " + appPath);
//        System.out.println("file separato" + File.separator);
//        System.out.println("SAVE_DIR = "+SAVE_DIR);
//         
//        // creates the save directory if it does not exists
        
        File fileSaveDir = new File(s);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        File uploads = new File(s);
        for (Part filePart : request.getParts()) {
            String fileName = extractFileName(filePart);
            File file = new File(uploads, fileName);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
        }
            /* TODO output your page here. You may use following sample code. */
            System.out.println("masuk addproduct");
            String[] inp = new String[10];
            inp[0] = request.getParameter("namaproduk");
            inp[1] = request.getParameter("harga");
            inp[2] = request.getParameter("deskripsi");
            inp[3] = "0"; //cataloglike
            inp[4] = parseDateNow();//"2016-11-04 00:00:00"; //catlog time stamp
            inp[5] = "0"; //catalog sold
            inp[6] = request.getParameter("foto");
            System.out.println("foto = " + inp[6]);
            inp[7] = request.getParameter("id_user");
            inp[8] = request.getParameter("user_fullname");
            inp[9] = request.getParameter("uname");
        try{
            PreparedStatement presql = connectDB().prepareStatement("INSERT INTO catalog (catalogname,catalogprice,catalogdesc"
            + ",catalogliked,catalogtimestamp,catalogsold,catalogphoto,userid,userfullname,uname_seller)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            for(int i=0;i<10;i++){
                presql.setString(i+1,inp[i]);
                System.out.println(inp[i]);
            }
            int x = presql.executeUpdate();
            System.out.println(x);
            connectDB().close();
            System.out.println("Query success pass");
            
        }catch(ClassNotFoundException | SQLException e){
            Object ex = null;
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exception" + e);
        }
        
        
        
        response.sendRedirect("http://localhost:8080/Client/product.jsp?access_token=" + request.getParameter("access_token"));
    }
    
    private String parseDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
                    //cal.add(Calendar.MINUTE, 20);
        String date = dateFormat.format(cal.getTime());
        return date;
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
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    String parse(String path){
        StringBuffer sb = new StringBuffer(path);
        sb.delete(path.length()-29,path.length());
        System.out.println(sb);
        return sb.toString();
    }
}
