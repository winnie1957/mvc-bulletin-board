<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org" lang="en" class="h-100">
  <head>
	<%@ include file="layout/meta.jsp" %>
    <title>My Bulletin Board</title>
	<%@ include file="layout/link.jsp" %>
  </head>
  <body class="container">
  
  	<main class="row from-signin justify-content-center align-items-center">
    
	<form action="<c:url value='/auth/register'/>" method="post" modelAttribute="user" class="col-lg-8">
	  <h1 class="mb-3 fw-normal">Sign Up</h1>
	  <div class="form-floating my-3">
	  	<input type="text" class="form-control" name="username" id="inputUsername" placeholder="username" required>
	    <label for="inputUsername">username</label>
	  </div>
	  <div class="form-floating my-3">
	  	<input type="password" class="form-control" name="password" id="inputPassword" placeholder="password" required>
	    <label for="inputPassword">password</label>
	  </div>
      <button type="submit" class="btn btn-primary w-100 py-2 my-3">註冊</button>
	  <a href="<c:url value='/auth/login'/>">回到登入</a>
	
	</form>
	
	</main>
	<%@ include file="layout/script.jsp" %>
	</body>
</html>