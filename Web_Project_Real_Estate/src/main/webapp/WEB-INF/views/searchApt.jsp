<%@page import="com.neu.project.DAO.FeatureDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
//get the Feature list
		FeatureDAO featureDAO = new FeatureDAO();
		java.util.List featureList = featureDAO.list();
		pageContext.setAttribute("features",featureList);
%>

  



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
<form action="search.htm" method="post">
  Search:<br>
  <input type="text" name="searchText"><br><br>  
  <input type="radio" name="filterBy" value="city" checked>city
  <input type="radio" name="filterBy" value="zip"> Zip Code
  BHK:
  <select name="BHK">
  <option value="1">1 BHK</option>
  <option value="2">2 BHK</option>
  <option value="3">3 BHK</option>
  <option value="4">4 BHK</option>
  <option value="5">4+ BHK</option>
  </select>
  <br><br>
  RENT :
  <select name="Rent">
  <option value="0">0-1000</option>
  <option value="1000">1000-2000</option>
  <option value="2000">2000-3000</option>
  <option value="3000">3000-4000</option>
  <option value="4000">4000+</option>
  </select>
  <br><br>
  AREA :
  <select name="Area">
  <option value="0">0-500</option>
  <option value="500">500-1000</option>
  <option value="1000">1000-1500</option>
  <option value="1500">1500-2000</option>
  <option value="2000">2000+</option>
  </select>
  <br><br> 
  
  FEATURES :
  <br> 
  <c:forEach var="i" items = "${features}">
    <input type="checkbox" name="feat" value="${i.featureDesc}">${i.featureDesc}<br>
  </c:forEach>    

  <br><br> 	
  <input type="submit" value="Search">
</form>
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