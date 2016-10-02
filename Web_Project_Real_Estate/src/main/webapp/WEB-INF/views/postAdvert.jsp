<%@page import="com.neu.project.DAO.FeatureDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
//get the Feature list
		FeatureDAO featureDAO = new FeatureDAO();
		java.util.List featureList = featureDAO.list();
		pageContext.setAttribute("features",featureList);
%>



<html>
    <head>
        <title>Add Advert Form</title>
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
        <h2>Posting a New Advert</h2>

        <form:form action="postAdvert.htm" commandName="property" method="post">

            <table>

                <tr>
                    <td>apt:</td>
                    <td><form:input path="apt" size="30" /> <font color="red"><form:errors path="apt"/></font></td>
                </tr>

                <tr>
                    <td>Street:</td>
                    <td><form:input path="street" size="30" /> <font color="red"><form:errors path="street"/></font></td>
                </tr>

                <tr>
                    <td>city:</td>
                    <td><form:input path="city" size="30" /> <font color="red"><form:errors path="city"/></font></td>
                </tr>

                <tr>
                    <td>State:</td>
                    <td><form:input path="state" size="30" /> <font color="red"><form:errors path="state"/></font></td>
                </tr>

                <tr>
                    <td>Zip:</td>
                    <td><form:input path="zip" size="30" /> <font color="red"><form:errors path="zip"/></font></td>
                </tr>

                <tr>
                    <td>Area:</td>
                    <td><form:input path="area" size="30" /> <font color="red"><form:errors path="area"/></font></td>
                </tr>

                <tr>
                    <td>BHK:</td>
                    <td><form:input path="bhk" size="30" /> <font color="red"><form:errors path="bhk"/></font></td>
                </tr>
                
                <tr>
                    <td>Rent</td>
                    <td><form:input path="rent" size="30" /> <font color="red"><form:errors path="rent"/></font></td>
                </tr>
<!--               
                <tr>
                    <td>Photo name:</td>
                    <td><form:input path="photoName" size="30" /> <font color="red"><form:errors path="photoName"/></font></td>
                </tr>
                
                <tr>
                    <td>Upload image: (Max size 5MB)</td>
                    <td><form:input type="file" path="image" size="30" /> <font color="red"><form:errors path="image"/></font></td>
                </tr>
  -->                 
                <tr>
                   <td>Features:</td>
                    <td>
                        <form:checkboxes items="${features}" path="feature_name" /><br>
                    </td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Post Advert" /></td>
                </tr>
                 
            </table>
        </form:form>
 </div>
 
        
<div id="logoutBtn">
Hi ${loggedInUser.userId} |
<a href="logout.htm">Logout</a><br>
</div>

</c:when>
    <c:otherwise>
    Please Login again to continue <a href="login.htm">Click here</a>
    </c:otherwise>
    </c:choose>

    </body>
</html>