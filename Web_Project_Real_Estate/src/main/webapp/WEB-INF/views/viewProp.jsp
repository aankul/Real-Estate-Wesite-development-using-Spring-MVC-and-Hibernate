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
       <table border="1" cellpadding="5" cellspacing="5">
           <tr>
               
               <td><b>Apt</b></td>
               <td><b>Street</b></td>
               <td><b>city</b></td>
               <td><b>state</b></td>
               <td><b>zip</b></td>
               <td><b>area</b></td>
               <td><b>rent</b></td>
               <td><b>Save Property</b></td>       
               <td><b>Message Agent</b></td>
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
              	   <td><a href="Addtocart.htm?prop=${prop.propertyId}" onclick="clickAndDisable(this)" >Add to Interested</a></td>
              	   <td><a href="MessageAgent.htm?user=${prop.seller}" >Contact Agent</a></td>                  
               </tr>
           </c:forEach>
       </table>
</div>       
       
<!--       
       <table border="1" cellpadding="5" cellspacing="5">
             <tr>
                 <c:forEach begin="1" end="${noOfPages}" var="i">
                     	<c:choose>
                         	 <c:when test="${currentPage eq i}">
                            	 <td>${i}</td>
                          	</c:when>
                     	<c:otherwise>
                              <td><a href="searcha.htm?page=${i}">${i}</a></td>
                     	</c:otherwise>
                   	</c:choose>
                  </c:forEach>
             </tr>
        </table>
        
        
          <c:if test="${currentPage lt noOfPages}">
              <td><a href="searcha.htm?page=${currentPage + 1}">Next</a></td>
          </c:if>
       -->
       
<script> 
   function clickAndDisable(link) {
     link.onclick = function(event) {
    	 alert("Property added to List");
        event.preventDefault();
     }
   }   
</script>       
       
   <div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a>
</div>    
       
       
   </body>
</html>