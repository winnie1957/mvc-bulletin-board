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
        <p>公告管理-編輯</p>
      </div>
    </div>
    <h2 class="text-center">${announcement.id == null ? 'Create' : 'Edit'} a announcement!</h2>
    
    <form method="POST" action="<c:url value='/announcement/save'/>" method="post" modelAttribute="announcement" class="container">
	  <input type="hidden" name="id" value="${announcement.id}"/>
      <div class="mb-3 row">
        <label for="recipient-publish-by" class="col-sm-2 col-form-label">公告者:</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="recipient-publish-by" name="publishBy" value="${announcement.publishBy}" disabled />
        </div>
      </div>
      <div class="mb-3 row">
        <label for="recipient-title" class="col-sm-2 col-form-label">標題:</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="recipient-title" name="title" value="${announcement.title}" />
        </div>
      </div>
      <div class="mb-3 row">
        <label for="recipient-publish-date" class="col-sm-2 col-form-label">發布日期:</label>
        <div class="col-sm-10">
          <input type="date" class="form-control" id="recipient-publish-date" name="publishDate" value="${announcement.publishDate}" />
        </div>
      </div>
      <div class="mb-3 row">
        <label for="recipient-closed-date" class="col-sm-2 col-form-label">截止日期:</label>
        <div class="col-sm-10">
          <input type="date" class="form-control" id="recipient-closed-date" name="closedDate" value="${announcement.closedDate}" />
        </div>
      </div>
      <div class="mb-3 row">
	    <label for="recipient-file" class="col-sm-2 col-form-label">上傳檔案:</label>
	    <div class="col-sm-10">
          <input type="file" class="form-control" id="recipient-file" />
        </div>
	  </div>
      <div class="mb-3">
      	<label for="recipient-content" class="col-form-label">內容:</label>
        <textarea class="form-control" id="recipient-content" name="content">${announcement.content}</textarea>
      </div>
      <div class="text-center">
        <button class="btn btn-primary text" type="submit">儲存</button>
	    <a href="<c:url value='/announcement/'/>" class="btn btn-secondary text">返回公告管理</a>
      </div>
    </form>

	    
     
	<%@ include file="layout/script.jsp" %>
    </body>
</html>