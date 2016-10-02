<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("loggedInUser")==null)
      response.sendRedirect("\\WEB-INF\\views\\login.jsp");

  %>


<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>JSP Page</title>
       <style>
       
    #logoutBtn
    {    
  	   	position:absolute;
   		top:0;
   		right:0;
    }
    
    
    #positionCenter
    {    
  	text-align: center;
    } 
    
         
</style>
</head>
<body text="DarkGreen " bgcolor="Beige">

<div id="positionCenter">
<h3>Property has been added to you list!!</h3>
<h4><a href="search.htm">See more properties</a></h4>
</div>

</body>
</html>