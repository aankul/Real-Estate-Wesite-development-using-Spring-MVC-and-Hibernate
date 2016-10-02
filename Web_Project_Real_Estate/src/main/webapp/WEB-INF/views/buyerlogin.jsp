
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME</title>
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
<h2>hello ${loggedInUser.userId}</h2>
<h4><a href="search.htm">Look for an Apt</a></h4>
<h4><a href="buyerInbox.htm?user=${loggedInUser.userId}">Inbox</a></h4>
<h4><a href="buyersCart.htm?user=${loggedInUser.personId}">My List</a></h4>
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