<%-- 
    Document   : route
    Created on : Oct 31, 2016, 7:47:36 AM
    Author     : Mujahid Suriah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String action = request.getParameter("action");
    if (action.equals("login")) {
        String success = request.getParameter("success");
        if (success.equals("1")) {
            String uid = request.getParameter("uid");
            String name = request.getParameter("name");
            session.setAttribute("userid", uid);
            response.sendRedirect("http://localhost:8080/Client/route.jsp?action=login&success=0&uid="+uid+"&name="+name);
        }
        else {
            response.sendRedirect("http://localhost:8080/Client/route.jsp?action=login&success=0");
        }
    }
%>
