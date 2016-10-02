<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login</title>
    <style type="text/css">
    #table
    {    
  	text-align: center;
    }  
    h2
    {    
  	text-align: center;
    }      
    </style>
</head>




<body text="DarkGreen " bgcolor="Beige">


<h2>Login Page</h2>


${loginError}

<div id="table">
	<form:form action="login.htm" commandName="user"  method="post" onsubmit="">
<fieldset>
<table>	
	<tr>
    	<td>User Name:</td>
    	<td><form:input path="userId" size="30" class="form-control"/> <font color="red"><form:errors path="userId"/></font></td>
	</tr>
	<tr>
    	<td>Password:</td>
    	<td><form:password path="password" size="30" class="form-control"/> <font color="red"><form:errors path="password"/></font></td>
	</tr>
	
	<tr>
    	<td>&nbsp;</td>
    	<td><form:checkbox path="rememberMe" value="1"/>Remember me?</td>
	</tr>	

	<tr>
    	<td colspan="2"><a href="signup.htm">Create an account</a></td>
	</tr>


	<tr>
    	<td colspan="2"><input type="submit" value="Login" /></td>
	</tr>	
</table>
</fieldset>
</form:form>
</div>

</body>
</html>