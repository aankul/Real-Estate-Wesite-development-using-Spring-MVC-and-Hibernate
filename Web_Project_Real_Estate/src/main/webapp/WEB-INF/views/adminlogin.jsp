<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


<c:choose>
<c:when test="${!empty sessionScope.loggedInUser}">
<div id="positionCenter">
<h1>Hello Admin</h1>
<a href="addFeatures.htm">Add features</a>
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