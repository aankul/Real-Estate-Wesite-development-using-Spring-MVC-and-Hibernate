<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add User Form</title>
    <style>
        #positionCenter
    {    
  	text-align: center;
    }  
    
    </style>
    
    
</head>

<body text="DarkGreen " bgcolor="Beige">

<h2>Register a New User</h2>



<div id="positionCenter">
<form:form action="signup.htm" commandName="user" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="userId" size="30" /> <font color="red"><form:errors path="userId"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
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
    <td>zip code:</td>
    <td><form:input path="zip" size="30" /> <font color="red"><form:errors path="zip"/></font></td>
</tr>


 <tr>
    <td>Phone number:</td>
    <td><form:input path="phone" size="30" /> <font color="red"><form:errors path="phone"/></font></td>
</tr>


 <tr>
    <td>email:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
</tr>

 <tr>
    <td>Date of birth [yyyy-MM-dd]:</td>
    <td><form:input path="dob" size="30" /> <font color="red"><form:errors path="dob"/></font></td>
</tr>


 <tr>
    <td>User Type:</td>
	<td><form:select path="userType"><font color="red"><form:errors path="userType"/></font>
	<form:option value="A">Agent</form:option>
	<form:option value="B">Buyer</form:option>
	</form:select></td>
 </tr>

<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>
</div>
</body>
</html>