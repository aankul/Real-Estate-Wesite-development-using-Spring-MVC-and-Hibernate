<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("loggedInUser")==null)
      response.sendRedirect("\\WEB-INF\\views\\login.jsp");

  %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
<h2>The Advertisement has been posted!!</h2>
<a href="agentAdvert.htm">Add more advertisements</a>
</div>


<div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a>
</div>

</body>
</html>
