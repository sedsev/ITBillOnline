<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>connection</title>
</head>
<body>
      <c:if test="${!empty form.resultat }"><p><c:out value="${form.resultat }"/></p></c:if> 
  	<form method="post" action="connection">
   		<p>
       		<label for="login">login:</label>
       		<input type="text" id="login"/>
   		</p>

    	<p>
 			<label for="pass">MOT DE PASSE:</label>
 			<input type="password" id="pass"/>
   		</p>
   			<input type="submit" value="envoyer">
   </form>
</body>
</html>