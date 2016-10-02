<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 .topcorner{
   position:absolute;
   top:0;
   right:0;
  }
  

    #logoutBtn
    {    
  	   	position:absolute;
   		top:0;
   		right:0;
    } 
    
     #login
    {    
  	   	text-align: center;
    } 
        
</style>

<title>Welcome Agent</title>
</head>
<body text="DarkGreen " bgcolor="Beige">

<c:choose>
<c:when test="${!empty sessionScope.loggedInUser}">
<div id="login">
<h3>Hello ${loggedInUser.userId} !!</h3>
<h4><a href="agentAdvert.htm">Post an Advertisement</a></h4>
<h4><a href="agentInbox.htm?user=${loggedInUser.userId}">Inbox</a></h4>
</div>


<div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a>
</div>
</c:when>
    <c:otherwise>
    Please Login again to continue <a href="login.htm">Click here</a>
    </c:otherwise>
    </c:choose>

</body>
</html>