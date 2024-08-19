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
        <h1>Welcome to <span class="text-primary">My Bulletin Board</span></h1>
        <p>練習用。</p>
      </div>
    </div>

    <div class="row">
      <!-- 側邊清單 -->
      <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-flex flex-column align-items-stretch flex-shrink-0 bg-body-tertiary">
        <div class="list-group list-group-flush border-bottom scrollarea">
          <a href="#" class="list-group-item list-group-item-action active py-3 lh-sm" aria-current="true">公告管理</a>
          <a href="#" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">123</a>
          <a href="#" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">123</a>
        </div>
      </nav>
      <!-- 內容 -->
      <div class="col-md">
        <!-- 上方按鈕 -->
       	<div class="">
	        <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#createModal" data-bs-whatever="@create">新增</button>
			<a href="//announcement" class="btn btn-secondary" >新增(jsp)</a>
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
                <button type="button" class="btn btn-outline-secondary" data-id="${item.id}" data-bs-toggle="modal" data-bs-target="#editModal" data-bs-whatever="@edit">修改</button>
                <button type="button" class="btn btn-outline-secondary" data-id="${item.id}" data-bs-toggle="modal" data-bs-target="#deteleModel">刪除</button>
              </td>
            </tr>
	        </c:forEach>
          </tbody>
        </table>
        
		<!-- 頁數 -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link">Previous</a></li>
		    <li class="page-item disabled"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item"><a class="page-link" href="#">Next</a></li>
		  </ul>
		</nav>
      </div>

    </div>
    
    <!-- 新增按鈕跳窗 Modal -->
    <div class="modal fade" id="createModal" tabindex="-1" aria-labelledby="createModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="createModalLabel">Announcement</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form method="POST" action="/bulletin-board/admin/announcement" id="createModel" name="createModel">
              <div class="mb-3">
                <label for="recipient-publish-by" class="col-form-label">公告者:</label>
                <input type="text" class="form-control" id="recipient-publish-by" path="publishBy" disabled />
              </div>
              <div class="mb-3">
                <label for="recipient-title" class="col-form-label">標題:</label>
                <input type="text" class="form-control" id="recipient-title" path="title" />
              </div>
              <div class="mb-3">
                <label for="recipient-publish-date" class="col-form-label">發布日期:</label>
                <input type="date" class="form-control" id="recipient-publish-date" path="publishDate" />
              </div>
              <div class="mb-3">
                <label for="recipient-closed-date" class="col-form-label">截止日期:</label>
                <input type="date" class="form-control" id="recipient-closed-date" path="closedDate" />
              </div>
              <div class="mb-3">
			    <label for="recipient-file" class="col-form-label">上傳檔案:</label>
			    <input type="file" class="form-control" id="recipient-file" />
			  </div>
              <div class="mb-3">
                <label for="recipient-content" class="col-form-label">內容:</label>
                <textarea class="form-control" id="recipient-content" path="content"></textarea>
              </div>
              
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Submit</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 修改按鈕跳窗 Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="editModalLabel">Announcement #</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form method="PUT" action="/announcement" name="editModel">
              <div class="mb-3">
                <label for="recipient-publish-by" class="col-form-label">公告者:</label>
                <input type="text" class="form-control" id="recipient-publish-by" disabled>
              </div>
              <div class="mb-3">
                <label for="recipient-title" class="col-form-label">標題:</label>
                <input type="text" class="form-control" id="recipient-title">
              </div>
              <div class="mb-3">
                <label for="recipient-publish-date" class="col-form-label">發布日期:</label>
                <input type="date" class="form-control" id="recipient-publish-date">
              </div>
              <div class="mb-3">
                <label for="recipient-closed-date" class="col-form-label">截止日期:</label>
                <input type="date" class="form-control" id="recipient-closed-date">
              </div>
              <div class="mb-3">
			    <label for="recipient-file" class="col-form-label">上傳檔案:</label>
			    <input type="file" class="form-control" id="recipient-file">
			  </div>
              <div class="mb-3">
                <label for="recipient-content" class="col-form-label">內容:</label>
                <textarea class="form-control" id="recipient-content"></textarea>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Submit</button>
          </div>
        </div>
      </div>
    </div>
        
    <!-- 刪除按鈕跳窗 Modal -->
    <div class="modal fade modal-dialog modal-dialog-centered" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            ...
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Understood</button>
          </div>
        </div>
      </div>
    </div>
  </main>


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <!-- javascript --><!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- <script src="../js/all.js"></script> -->
  
	<script>
// 	$(function(){
// 	  $("#createModal").submit(function(e){
// 	    e.preventDefault(); // 停止觸發submit
// 	    console.log("createModal");
// 	    var formData = new FormData($("#createModal")[0]); // 使用FormData包裝form表單來傳輸資料
// 	    $.ajax({
// 	      type: "POST",
// 	      url: "/admin/announcement",
// 	      data:formData,
// 	      cache:false, // 不需要cache
// 	      processData: false, // jQuery預設會把data轉為query String, 所以要停用
// 	      contentType: false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
// 	      dataType: 'text',
// 	      success: function (data){
// 	        console.log(data);
// 	      }      
// 	    });
// 	  });
// 	});
	</script>
  </body>
</html>