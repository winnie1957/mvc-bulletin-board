<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC 
  "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org" lang="en" class="h-100">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.83.1">
    <title>My Bulletin Board</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <!-- Custom CSS -->
    <!-- <link href="../scss/all.css" rel="stylesheet"> -->
  </head>
  <body>
    
  <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow"></header>

  <main class="container-fluid">
    <!-- 標題 -->
    <div class="pt-3 pb-2 mb-3 border-bottom">
      <div class="bg-light p-5 rounded">
        <h1>Hello World! Welcome to <span class="text-primary">My Bulletin Board</span></h1>
        <p>練習用。</p>
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

	    
     
    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <!-- javascript --><!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- <script src="../js/all.js"></script> -->
	<!-- textarea editor -->
    <script src="https://cdn.tiny.cloud/1/qagffr3pkuv17a8on1afax661irst1hbr4e6tbv888sz91jc/tinymce/7/tinymce.min.js"></script>
    <script type="text/javascript">
    tinymce.init({
    	  selector: 'textarea#recipient-content',
    	  height: 500,
    	  plugins: [
    	    'advlist', 'autolink', 'lists', 'link', 'image', 'charmap', 'preview',
    	    'anchor', 'searchreplace', 'visualblocks', 'code', 'fullscreen',
    	    'insertdatetime', 'media', 'table', 'help', 'wordcount'
    	  ],
    	  toolbar: 'undo redo | blocks | ' +
    	  'bold italic backcolor | alignleft aligncenter ' +
    	  'alignright alignjustify | bullist numlist outdent indent | ' +
    	  'removeformat | help',
    	  content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
    	});
    </script>
    </body>
</html>