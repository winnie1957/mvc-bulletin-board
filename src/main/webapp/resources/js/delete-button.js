/**
 * 列表的刪除按鈕跳窗
 */
console.log('列表的刪除按鈕跳窗')
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