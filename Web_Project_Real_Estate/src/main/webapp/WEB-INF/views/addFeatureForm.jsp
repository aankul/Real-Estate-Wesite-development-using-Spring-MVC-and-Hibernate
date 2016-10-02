<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   


<html>
<head>

    <title>Add Category Form</title>
    <style>
    #logoutBtn
    {    
  	   	position:absolute;
   		top:0;
   		right:0;
    }
    
    #centerPosition
    {    
  	text-align: center;
    } 
    
         
</style>
    
</head>
<body text="DarkGreen " bgcolor="Beige">

<c:choose>
<c:when test="${!empty sessionScope.loggedInUser}">

<div id="centerPosition">
<h2>Add a New Category</h2>

<form:form name="form" action="addFeatures.htm" commandName="features" method="post">

<table>
<tr>
    <td>Feature :</td>
    <td><form:input path="featureDesc" size="30" /> <font color="red"><form:errors path="featureDesc"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Add Feature" onclick="return IsEmpty();" /></td>
</tr>
</table>

</form:form>
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

<script language="Javascript">
function IsEmpty(){
	  if(document.forms['form'].featureDesc.value == "")
	  {
	    alert("empty");
	    return false;
	  }
	    return true;
	}
</script>



</html>