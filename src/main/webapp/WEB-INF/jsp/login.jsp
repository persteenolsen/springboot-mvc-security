
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
	<title>A Java Spring Boot MVC JSP JPA example</title>
	
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
	<style>
		.header-text {Color: Green; font-family: Verdana, sans-serif; font-size: 14pt}
		.body-content{margin-left: 10pt; margin-right: 10pt; font-family: Verdana, sans-serif}
	</style>

</head>
<body>

	
   <jsp:include page="header_menu.jsp" />
	
	
	<div class="container">


      <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
 
      <form name='login' action="/login" method='POST'>
          <table>
              <tr>
                  <td>Username:</td>
                  <td><input type='text' name='username' value=''></td>
              </tr>
              <tr>
                  <td>Password:</td>
                  <td><input type='password' name='password' /></td>
              </tr>
              <tr>
                  <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
              </tr>
          </table>

          
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

      </form>

</body>
</html>