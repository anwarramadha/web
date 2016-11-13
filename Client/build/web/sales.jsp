<%-- 
    Document   : sales
    Created on : Nov 12, 2016, 11:23:00 AM
    Author     : Atika Firdaus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<head>
	<title>
		Sale Project
	</title>
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat"></link>
	<link type="text/css" rel="stylesheet" href="css/style.css"></link>
</head>
<body>
	<h1><img src="images/sale.png"></img></h1><br>
	<%
		java.lang.String token = request.getParameter("access_token");
        System.out.print(token);
        try {
            users.UsersWS_Service service = new users.UsersWS_Service();
            users.UsersWS port = service.getUsersWSPort();
            if (port.isTokenValid(token)) {
            java.util.List<users.Users> result = port.getUserData(token);
                try {
                	int i = 1;
                	java.util.List<users.Users> res = result;
                    for (users.Users user : res) { 
                    	out.print("<div class='user-logged'><span class='" + "user-logged'>Hi, " + user.getFullname() + "!<br>"
                    	+ "<a class='user' href='http://localhost:8081/IdentityService/logout'>" + "<b>logout</b></a></span></div>"); 
                 	}
                } catch (Exception ex) { 
                    out.print("Exception: " + ex); 
                }
                out.print("<input type='hidden' id='access_token' name='access_token' value='"+token+"'></input>");
            } else {
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
	</ul><br>
	<div class="title">
		<h2>Here are your sales</h2>
		<hr>
	</div>
	<br>
	<div id="sales-list" class="catalog-list"></div>
	<input type="hidden" value="4" id="id_page"></input>
	<script type="text/javascript" src="js/init.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
    	setTimeout(function(){
        	$("#success").remove();
            }, 5000);
    </script>
</body>
</HTML>