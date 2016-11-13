<%-- 
    Document   : route.jsp
    Created on : Oct 30, 2016, 2:13:45 PM
    Author     : Mujahid Suriah
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String action = request.getParameter("action");
        String accessToken = request.getParameter("access_token");
        String catalogid = request.getParameter("catalogid");
        try {
            marketplace.SpecificCatalogWS_Service service = new marketplace.SpecificCatalogWS_Service();
            marketplace.SpecificCatalogWS port = service.getSpecificCatalogWSPort();
            java.lang.Integer result = port.addLike(catalogid, action);
            users.UsersWS_Service service1 = new users.UsersWS_Service();
            users.UsersWS port1 = service1.getUsersWSPort();
            java.lang.Integer result1 = port1.addLike(accessToken, catalogid, action);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
%>
