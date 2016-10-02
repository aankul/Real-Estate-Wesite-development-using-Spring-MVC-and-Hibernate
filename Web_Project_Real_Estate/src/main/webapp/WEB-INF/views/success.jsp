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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
    #positionCenter
    {    
  	text-align: center;
    }
    
    #logoutBtn
    {    
  	   	position:absolute;
   		top:0;
   		right:0;
    } 
       
</style>
</head>
<body text="DarkGreen " bgcolor="Beige">
<div id="positionCenter">
<h1>Features added successfully !</h1>
</div>

<div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a>
</div>  


</body>
</html>