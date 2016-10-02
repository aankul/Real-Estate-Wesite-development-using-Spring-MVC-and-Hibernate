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
       <table border="1" cellpadding="5" cellspacing="5">
           <tr>
               
               <td><b>From</b></td>
               <td><b>Message</b></td>
               <td><b>Date</b></td>
               <td><b>Reply</b></td>
           </tr>
           <c:forEach var="msg" items="${requestScope.MessageList}">
               <tr>
                   <td>${msg.user}</td>
                   <td>${msg.message}</td>
                   <td>${msg.messageDate}</td>
                   <td><a href="MessageAgent.htm?user=${msg.user}" >Reply</a></td>                 
               </tr>
           </c:forEach>
       </table>
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