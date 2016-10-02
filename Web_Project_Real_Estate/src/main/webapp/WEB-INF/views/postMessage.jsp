<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
          
</style>

</head>
<body text="DarkGreen " bgcolor="Beige">

<div id="positionCenter">
 <form action="MessageAgent.htm" method="post">
 To: <br>
 <input type="text" name="userTo" value="${requestScope.userTo}" readonly="readonly">
 <br>
 <br>
 Message: <br>
 <textarea rows="6" cols="40"  name="messageBox"></textarea>
 <br>
 <input type="submit" value="Search">
 </form>
 </div>
 
 
<div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a>
</div>

</c:when>
    <c:otherwise>
    Please Login again to continue <a href="login.htm"></a>
    </c:otherwise>
    </c:choose>
 
</body>
</html>