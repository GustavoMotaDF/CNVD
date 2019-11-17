<%-- 
    Document   : sessao
    Created on : 17/11/2019, 01:14:20
    Author     : Gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   try{
    session.invalidate();
    
    response.sendRedirect("/Cnvd-Cnvd/");
   }catch(Exception e){
       out.print(e);
   }
%>