/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import marketplace.AddproductWS_Service;

/**
 *
 * @author adesu
 */
@WebServlet(urlPatterns = {"/addProduct"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50) 
public class addProduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/WebService/addproductWS.wsdl")
    private AddproductWS_Service service;

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
        response.setContentType("text/html;charset=UTF-8");
         
        String[] inp = new String[10];
            /* TODO output your page here. You may use following sample code. */
            System.out.println("masuk addproduct");
            inp[0] = request.getParameter("namaproduk");
            System.out.println(inp[0]);
            inp[1] = request.getParameter("harga");
            inp[2] = request.getParameter("deskripsi");
            inp[3] = "0"; //cataloglike
            inp[4] = parseDateNow();//"2016-11-04 00:00:00"; //catlog time stamp
            inp[5] = "0"; //catalog sold
            //System.out.println("foto = " + inp[6]);
            inp[7] = request.getParameter("id_user");
            inp[8] = request.getParameter("user_fullname");
            inp[9] = request.getParameter("uname");
            
            String appPath = request.getServletContext().getRealPath("");
        String SAVE_DIR ="images/";
         String savePath = appPath +File.separator + SAVE_DIR;
          //String s = parse(savePath);
          System.out.println("appPath = " + savePath);
//         
//        // creates the save directory if it does not exists
        
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        File uploads = new File(savePath);
        Part filePart = request.getPart("foto"); 
            String fileName = extractFileName(filePart);
            inp[6] = fileName;
            File file = new File(uploads, fileName);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
        
           
            String query = "INSERT INTO catalog (catalogname,catalogprice,catalogdesc"
            + ",catalogliked,catalogtimestamp,catalogsold,catalogphoto,userid,userfullname,uname_seller)"
            + " VALUES(";
            for(int i=0;i<10;i++){
                if(i==0 || i==2 || i==3 || i==4 || i==6 || i==8 || i==9){
                    query = query + "'" + inp[i] + "'";
                }else 
                query = query + inp[i];
                if(i!=9){
                    query +=",";
                }else{
                    query = query + ");";
                }
            }
            System.out.println(query);
            add(query);
            response.sendRedirect("http://localhost:8080/Client/product.jsp?access_token=" + request.getParameter("access_token"));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
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
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
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
        sb.delete(path.length()-21,path.length());
        System.out.println(sb);
        return sb.toString();
    }

    private String add(java.lang.String query) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplace.AddproductWS port = service.getAddproductWSPort();
        return port.add(query);
    }
}
