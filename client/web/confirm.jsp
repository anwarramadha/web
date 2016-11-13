<%-- 
    Document   : purchase
    Created on : Nov 4, 2016, 10:50:19 AM
    Author     : Mujahid Suriah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            try {
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
                        } 
                    } catch (Exception ex) { 
                        out.print("Exception: " + ex); 
                    }
                }
                else {
                    Cookie cookie = new Cookie("loginExpires", "Sesi login anda sudah habis");
                    response.addCookie(cookie);
                    response.sendRedirect("http://localhost:8080/Client/login.jsp");
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
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
	<br>
	<div class="title">
		<h2>Please confirm your purchase</h2>
		<hr>
	</div><br>
	<div class="catalog-list">
            <%
                String username="";
                String fullname="";
                String address="";
                String postal="";
                String phone="";
                String catalogname="";
                String price="";
                String productid="";
                String userid="";
                String photo="";
                String uname_seller="";
                int orgPrice=0;
                int catalogid = Integer.parseInt(request.getParameter("id_product"));
                try {
                    
                    users.UsersWS_Service serviceuser = new users.UsersWS_Service();
                    users.UsersWS port1 = serviceuser.getUsersWSPort();
                    
                    java.util.List<users.Users> result1 = port1.getUserData(token);
                    marketplace.SpecificCatalogWS_Service service = new marketplace.SpecificCatalogWS_Service();
                    marketplace.SpecificCatalogWS port = service.getSpecificCatalogWSPort();
                    System.out.print(catalogid);
                    java.util.List<marketplace.Marketplace> result = port.getSpecificCatalog(catalogid);
                    for(users.Users userdata : result1) { 
                        username = userdata.getUsername();
                        fullname = userdata.getFullname();
                        address = userdata.getAddress();
                        postal = userdata.getPostal();
                        phone = userdata.getPhone();
                    ;}
                    
                    for(marketplace.Marketplace market : result) {
                        catalogname = market.getCatalogname();
                        productid = Integer.toString(market.getCatalogid());
                        uname_seller = market.getUnameSeller();
                        userid = market.getUserid();
                        photo = market.getCatalogphoto();
                        StringBuilder strB= new StringBuilder();
                        strB.append(Integer.toString(market.getCatalogprice()));
                        orgPrice = market.getCatalogprice();
                        int count = 0;
                        for (int i = strB.length(); i > 0; i--) {
                            if (count==3) {
                                strB.insert(i, '.');
                                count=0;
                            }
                            count++;
                        }
                        price = strB.toString();
                    }
                        } catch (Exception ex) {
                            out.print("exception");
                        }
            %>
        <form name="purchase" method="POST" action="http://localhost:8082/WebService/addPurchase" onsubmit="return confirmed()">
            <input type="hidden" value="<%out.print(productid);%>" id="product-id" name="product-id">
            <input type="hidden" id="access_token" name="access_token" value="<%out.print(token);%>">
            <input type="hidden" value="<%out.print(userid);%>" id="product-id_user" name="product-id_user">
            <span id="buy-data"><span>Product	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%out.print(catalogname);%></span><br>
            <input type="hidden" name="catalogname" id="catalogname" value="<%out.print(catalogname);%>"></input>
            <span>Price		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: IDR </span>
            <span><%out.print(price);%></span><br>
            <input type="hidden" id="price" name="price" value="<%out.print(orgPrice);%>">
            <span>Quantity &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: 
            <input type="text" name="quantity" style="width:10%;" class="quantity-input" id="quantity" value="1" placeholder="" oninput="calculateTotal()"> pcs </span><br>
            <span>Total Price &nbsp;&nbsp;&nbsp;&nbsp;: IDR </span><span  id="calculate-total-price"><%out.print(price);%></span></br>
            <input type="hidden" id="total" name="total" value="<%out.print(orgPrice);%>">
            <span>Delivery to	&nbsp;&nbsp;&nbsp;: </span></span><br><br>

            <div class="errormessage" id="inputnamelog"></div>
            <label>Consignee</label>
            <input type="text" name="consigne" id="consigne" class="form-control"value="<%out.print(fullname);%>"><br><br>
            <input type="hidden" name="username" value="<%out.print(username);%>"></input>
            <div class="errormessage" id="inputaddresslog"></div>
            <label>Full Address</label>
            <input type="text" name="address" id="address" class="form-control" value="<%out.print(address);%>"><br><br>

            <div class="errormessage" id="inputpostlog"></div>
            <label>Postal code</label>
            <input type="text" name="postal" id="postal" class="form-control" value="<%out.print(postal);%>"><br><br>

            <div class="errormessage" id="inputphonelog"></div>
            <label>Phone number</label>
            <input type="text" name="phone" id="phone" class="form-control" value="<%out.print(phone);%>"><br><br>

            <div class="errormessage" id="err-credit-card"></div>
            <label>12 digits credit card number</label>
            <input type="text" name="credit-card" id="credit-card" class="form-control" value=""><br><br>

            <div class="errormessage" id="err-verf-num"></div>
            <label>3 digits card verification value</label>
            <input type="text" name="verf" id="verf" class="form-control"><br><br>
            <input type="hidden" name="catalogphoto" value="<%out.print(photo);%>">
            <input type="hidden" name="unameseller" value="<%out.print(uname_seller);%>">
            <input class="btn" type="button" onclick="cancel()" value="CANCEL">
            <input class= "btn" type="submit" value="CONFIRM">
            <br><br><br>
        </form>
	</div>
	<script type="text/javascript" src="js/catalog.js"></script>
        <script>
            function cancel() {
                window.location = 'http://localhost:8080/Client/catalog.jsp';
            }
        </script>
	<script type="text/javascript" src="js/init.js"></script>
</body>
</HTML>
