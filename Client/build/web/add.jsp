<%-- 
    Document   : addProduct
    Created on : Nov 4, 2016, 3:48:02 PM
    Author     : adesr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
		Sale Project
	</title>
	<link type="text/css" rel="stylesheet" href="css/style.css"></link>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
    </head>
    <body>
        <h1><img src="images/sale.png"></img></h1><br>
        <%
            java.lang.String token = request.getParameter("access_token");
            System.out.print(token);
            try {
                //java.util.List<users.Users> result;
                users.UsersWS_Service service = new users.UsersWS_Service();
                users.UsersWS port = service.getUsersWSPort();
                if (port.isTokenValid(token)) {
                    java.util.List<users.Users> result = port.getUserData(token);
                    try { int i = 1; java.util.List<users.Users> res = result;
                        for (users.Users user : res) { 
                            out.print("<div class='user-logged'><span class='"+
                                    "user-logged'>Hi, "+user.getFullname()+"!<br>"+
                                            "<a class='user' href='http://localhost:8081/IdentityService/logout'>"+
                                            "<b>logout</b></a></span></div>"); 
                            //java.lang.String id;
                           // id = user.getUserid();
                           

                        } 
                    } catch (Exception ex) { 
                        out.print("Exception: " + ex); 
                    }

                    //out.print("<input type='hidden' id='access_token' name='access_token' value='"+token+"'></input>");
                                    }
                else {
                    Cookie cookie = new Cookie("loginExpires", "Sesi login anda sudah habis");
                    response.addCookie(cookie);
                    response.sendRedirect("http://localhost:8080/Client/login.jsp");
                }
            } catch (Exception ex) {
                out.print("Exception: " + ex);
            }
        %>
            <div id="userdata" class="user-logged"></div>
	
        <ul id="menu">
            <table>
                <col width="20%" />
                <col width="20%" />
                <col width="20%" />
                <col width="20%" />
                <col width="20%" />
                <thead>
                    <%
                java.lang.String token1 = request.getParameter("access_token");
                out.print("<th id='1'><a href='http://localhost:8080/Client/catalog.jsp?access_token="+token1+"'><span id='span1'>Catalog</span></a></th>");
                out.print("<th id='2'><a href='http://localhost:8080/Client/product.jsp?access_token="+token1+"'><span id='span2'>Your Products</span></a></th>");
                out.print("<th id='3'><a href='http://localhost:8080/Client/add.jsp?access_token="+token1+"'><span id='span3'>Add Product</span></a></th>");
                out.print("<th id='4'><a href='http://localhost:8080/Client/sales.jsp?access_token="+token1+"'><span id='span4'>Sales</span></a></th>");
                out.print("<th id='5'><a href='http://localhost:8080/Client/purchases.jsp?access_token="+token1+"'><span id='span5'>Purchases</span></a></th>");
                %>
                </thead>
            </table>
        </ul>
        <br>
	<div class="title">
		<h2>Please add your product here</h2>
		<hr>
	</div>
	<br>
        <div class="catalog-list">
            <form name="addproduct" onsubmit="return validateAdd()" method="POST" action="addProduct" enctype="multipart/form-data">
                <div class="errormessage" id="error-productname"></div>
                <%
                    java.lang.String token2 = request.getParameter("access_token");
                    users.UsersWS_Service service = new users.UsersWS_Service();
                    users.UsersWS port = service.getUsersWSPort();
                    if (port.isTokenValid(token)) {
                        java.util.List<users.Users> result1 = port.getUserData(token);
                
                        try { 
                            int i = 1; 
                            java.util.List<users.Users> res1 = result1;
                            for (users.Users user : res1) { 
                                out.print("<input type=\"hidden\" name=\"id_user\" id=\"id_user\" value=\"" +user.getUserid()+"\">");
                                out.print("<input type=\"hidden\" name=\"user_fullname\" id=\"user_fullname\" value=\"" +user.getFullname()+"\">");
                                out.print("<input type=\"hidden\" id=\"access_token\" name=\"access_token\" value=\""+ token2 +"\">");
                                 out.print("<input type=\"hidden\" id=\"uname\" name=\"uname\" value=\""+ user.getUsername() +"\">");
                            } 
                        } catch (Exception ex) { 
                            out.print("Exception: " + ex); 
                        }
                    }
                %>
                <label>Name</label>
                <input type="text" name="namaproduk" id="namaproduk" value=""><br><br>

                <div class="errormessage" id="error-desc"></div>
                <label>Description (max 200 chars)</label><br>
                
                <textarea name="deskripsi" maxlength="200" cols="109" rows="10" id="deskripsi"></textarea><br><br>

                <div class="errormessage" id="error-price"> </div>
                <label>Price (IDR)</label>
                <input type="text" name="harga" id="harga" value=""><br><br>

                <div class="errormessage" id="image"> </div>
                <label>Photo</label><br>
                <input type="file" name="foto" id="foto" value=""><br><br>

                <input type="reset" class="btn" value="CANCEL">
                <input type="submit" class="btn" value="ADD">
            </form>
            <div id="product-list" class="product-list">
            </div>
            <input type="hidden" value="3" id="id_page"></input>
            
            <script type="text/javascript" src="js/init.js"></script>            
            <script type="text/javascript" src="js/validation.js"></script>
           </div>
    </body>
</html>
