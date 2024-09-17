<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
<!-- javascript --><!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- <script src="../js/all.js"></script> -->


<!-- snippets -->
<script type="text/javascript">
const exampleModal = document.getElementById('exampleModal')
if (exampleModal) {
    exampleModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an Ajax request here
        // and then do the updating in a callback.

        // Update the modal's content.
        const modalTitle = exampleModal.querySelector('.modal-title')
        const modalBodyInput = exampleModal.querySelector('.modal-body input')

        modalTitle.textContent = `New message to ${recipient}`
        modalBodyInput.value = recipient
    })
}
</script>

<!-- 列表的刪除按鈕跳窗 delete-button -->
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
    var deleteLinks = document.querySelectorAll('.delete-link');
    deleteLinks.forEach(function(link) {
        link.addEventListener('click', function(e) {
            e.preventDefault(); // 阻止默認的鏈接行為
            
            var action = this.getAttribute('data-action');
            var url = this.getAttribute('href');
            
            if (action === 'delete') {
                if (confirm('確定要刪除嗎？')) {
                    // 發送 DELETE 請求
                    fetch(url, {
                        method: 'DELETE',
                        headers: {
                            'Content-Type': 'application/json',
                            // 如果需要，添加 CSRF token
                            // 'X-CSRF-TOKEN': 'your-csrf-token-here'
                        },
                    })
                    .then(response => {
                            location.reload(); // 刷新頁面或更新 UI
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('發生錯誤');
                    });
                }
            }
        });
    });
});
</script>

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