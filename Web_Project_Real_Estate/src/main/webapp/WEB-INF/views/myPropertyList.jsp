<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<c:choose>
<c:when test="${!empty sessionScope.loggedInUser}">
   
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

<div id="positionCenter">
       <table border="1" cellpadding="5" cellspacing="5">
           <tr>
               
               <td><b>Apt</b></td>
               <td><b>Street</b></td>
               <td><b>city</b></td>
               <td><b>state</b></td>
               <td><b>zip</b></td>
               <td><b>area</b></td>
               <td><b>rent</b></td>
           </tr>
           <c:forEach var="prop" items="${propList}">
               <tr>
                   <td>${prop.apt}</td>
                   <td>${prop.street}</td>
                   <td>${prop.city}</td>
                   <td>${prop.state}</td>
                   <td>${prop.zip}</td>
                   <td>${prop.area}</td>
                   <td>${prop.rent}</td>              
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