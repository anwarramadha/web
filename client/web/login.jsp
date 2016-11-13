<%-- 
    Document   : login.jsp
    Created on : Oct 30, 2016, 2:13:45 PM
    Author     : Mujahid Suriah
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		Sale Project
	</title>
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat"></link>
        
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css"></link>
	<link type="text/css" rel="stylesheet" href="css/style.css"></link>
</head>
<body>
	<h1><img src="images/sale.png"></img></h1>
	<br>
		<div class="login">
                    <h2>Please login</h2>
                    <hr>
                    <p style="color:red">${errorMessage}<b></b></p>
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
                                else if (cookie.getName().equals("loginExpires")) {
                                    out.println("<div class='alert alert-danger catalog-list' id='success'><strong>"+cookie.getValue()+"</strong></div>");
                                    cookie.setValue("");
                                    cookie.setMaxAge(0);
                                    response.addCookie(cookie);
                                }
                            }
                        }
                        if (request.getParameterMap().containsKey("valid")) {
                            String valid = request.getParameter("valid");
                            if (valid.equals("false")) {
                                out.println("<div class='alert alert-danger catalog-list' id='success'><strong>Username atau password tidak cocok</strong></div>");
                            }
                        }
                    %>
                            <form name="login" onsubmit="return validateLogin()" method="POST" action="http://localhost:8081/IdentityService/login">
                                    <div class="error" id="login-err"></div>
                                    <div id="inputunamelog"></div>
                                    <label>Email or Username</label>
                                    <input class="form-control" type="text" id="username" name="username"></input>
                                    <div id="inputpasslog"></div>
                                    <label>Password</label>
                                    <input class="form-control" type="password" name="password" id="password"></input><br><br>
                                    <input class= "btn" type="submit" value="LOGIN">
                                    <br>
                            </form>
                            <br>
                            <h4>Don't have an account yet? Register <a href="http://localhost:8080/Client/register.jsp">here</a></h4>
                    </div>
		
	<script type="text/javascript" src="js/validation.js"></script>
        
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
<body>

</body>
</html>