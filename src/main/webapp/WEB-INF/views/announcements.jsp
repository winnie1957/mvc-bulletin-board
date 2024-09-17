<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Hello, <b>${user.username}</b> ! Welcome to <span class="text-primary">My Bulletin Board</span></h1>
        <p>公告管理-列表</p>
      </div>
    </div>
    
    <div class="row">
      <!-- 側邊清單 -->
      <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-flex flex-column align-items-stretch flex-shrink-0 bg-body-tertiary">
        <div class="list-group list-group-flush border-bottom scrollarea">
          <a href="<c:url value='/announcement/'/>" class="list-group-item list-group-item-action active py-3 lh-sm" aria-current="true">公告管理</a>
    	  <a href="<c:url value='/'/>" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">返回主頁</a>
          <a href="<c:url value='/auth/logout'/>" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">登出</a>
        </div>
      </nav>
      <!-- 內容 -->
      <div class="col-md">
        <!-- 上方按鈕 -->
       	<div class="">
<!-- 	        <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#createModal" data-bs-whatever="@create">新增</button> -->
    		<a href="<c:url value='/announcement/edit/0'/>" class="btn btn-secondary">新增公告</a>
       	</div>
        <!-- <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@fat">Open modal for @fat</button> -->
        <!-- <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button> -->
        <!-- 列表 -->
        <table class="table table-hover">        
          <thead>
            <tr>
              <th scope="col" class="col-1">#</th>
              <th scope="col">標題</th>
              <th scope="col" class="col-2">發佈日期</th>
              <th scope="col" class="col-2">截止日期</th>
              <th scope="col" class="col-2">動作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${announcements}">
            <tr>
              <th scope="row">${item.id}</th>
              <td>${item.title}</td>
              <td>${item.publishDate}</td>
              <td>${item.closedDate}</td>
              <td class="btn-group" role="group">
<%--                 <button type="button" class="btn btn-outline-secondary" data-id="${item.id}" data-bs-toggle="modal" data-bs-target="#editModal" data-bs-whatever="@edit">修改</button> --%>
<%--                 <button type="button" class="btn btn-outline-secondary" data-id="${item.id}" data-bs-toggle="modal" data-bs-target="#deteleModel">刪除</button> --%>
	            <a href="<c:url value='/announcement/edit/${item.id}'/>" class="btn btn-outline-secondary" >編輯</a>
	            <a href="<c:url value='/announcement/delete/${item.id}'/>" data-action="delete" class="delete-link btn btn-outline-secondary" >刪除</a>
              </td>
            </tr>
	        </c:forEach>
          </tbody>
        </table>
      </div>
    </div>        
        
    
	<%@ include file="layout/script.jsp" %>
    </body>
</html>