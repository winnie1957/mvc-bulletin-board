<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org" lang="en" class="h-100">
  <head>
	<%@ include file="layout/meta.jsp" %>
    <title>My Bulletin Board</title>
	<%@ include file="layout/link.jsp" %>
  </head>
  <body>
    
  <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow"></header>

  <main class="container-fluid">
    <!-- 標題 -->
    <div class="pt-3 pb-2 mb-3 border-bottom">
      <div class="bg-light p-5 rounded">
<!--         <h1>Hello, <sec:authorize access="isAuthenticated()"><sec:authentication principal="name"/></sec:authorize><sec:authorize access="!isAuthenticated()">World</sec:authorize>! Welcome to <span class="text-primary">My Bulletin Board</span></h1> -->
        <h1>Hello, <b>${user.username}</b> ! Welcome to <span class="text-primary">My Bulletin Board</span></h1>
        <p>This is the homepage!</p>
      </div>
    </div>
    
    <div class="row">
      <!-- 側邊清單 -->
      <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-flex flex-column align-items-stretch flex-shrink-0 bg-body-tertiary">
        <div class="list-group list-group-flush border-bottom scrollarea">
          <a href="/bulletin-board/announcement/" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">公告管理</a>      
          <a href="<c:url value='/auth/logout'/>" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">登出</a>
        </div>
      </nav>
      <!-- 內容 -->
      <div class="col-md">
      
      </div>
    </div>
	
	<%@ include file="layout/script.jsp" %>
    </body>
</html>