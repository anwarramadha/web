<%-- 
    Document   : register.jsp
    Created on : Oct 30, 2016, 2:13:45 PM
    Author     : Mujahid Suriah
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		Sale Project
	</title>
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat"></link>
	<link type="text/css" rel="stylesheet" href="css/style.css"></link>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
</head>
<body>
    <%
            Cookie[] cookies = request.getCookies();
            String access_token="";
            if (cookies!=null) {
                for(Cookie cookie : cookies) {
                    System.out.println(cookie.getName());
                    if (cookie.getName().equalsIgnoreCase("login")) {
                        access_token = cookie.getValue();
                        try {
                            users.UsersWS_Service service = new users.UsersWS_Service();
                            users.UsersWS port = service.getUsersWSPort();
                            java.lang.Boolean result = port.isTokenValid(access_token);
                            if (result)
                                response.sendRedirect("http://localhost:8080/Client/catalog.jsp?access_token="+access_token);
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                    }
                }
            }
        %>
	<h1><img src="images/sale.png"></img></h1>
        <div class="login">
            <h2>Please register</h2>
            <hr><br>
            <%
                if (request.getParameterMap().containsKey("valid")) {
                    String valid = request.getParameter("valid");
                    if (valid.equals("false")) {
                        out.println("<div class='alert alert-danger catalog-list' id='success'><strong>Username atau password sudah terdaftar</strong></div>");
                    }
                }
            %>
            <form name="register" onsubmit="return validateForm()" method="POST" action="http://localhost:8081/IdentityService/register">
                <div class="error" id="register-err"></div>

                <div class="errormessage" id="inputnamelog"></div>
                <label>Full Name</label>
                <input type="text" name="name" id="name" class="form-control" value=""><br><br>

                <div class="errormessage" id="inputunamelog"></div>
                <label>Username</label>
                <input type="text" name="username" id="username1" class="form-control"value=""><br><br>

                <div class="errormessage" id="inputemaillog"></div>
                <label>Email</label>
                <input type="text" name="email" id="email" class="form-control" value=""><br><br>

                <div class="errormessage" id="inputpass"></div>
                <label>Password</label>
                <input type="password" name="password" id="password1" class="form-control" value=""><br><br>

                <div class="errormessage" id="inputpasslog"></div>
                <label>Confirm Password</label>
                <input type="password" name="confirm-password" id="confirm-password" class="form-control" value=""><br><br>

                <div class="errormessage" id="inputaddresslog"></div>
                <label>Full Address</label>
                <input type="text" name="address" id="address" class="form-control" value=""><br><br>

                <div class="errormessage" id="inputpostlog"></div>
                <label>Postal Code</label>
                <input type="text" name="postal" id="postal" class="form-control"><br><br>

                <div class="errormessage" id="inputphonelog"></div>
                <label>Phone Number</label>
                <input type="text" name="phone" id="phone" class="form-control"><br><br>

                <input class= "btn" type="submit" value="REGISTER">
            </form>
            <br>
            <h4>Already registered? Login <a href="http://localhost:8080/Client/login.jsp">here</a></h4>  
        </div>
		
	<script type="text/javascript" src="js/validation.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>