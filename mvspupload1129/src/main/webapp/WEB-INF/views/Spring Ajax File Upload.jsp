<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Spring ajax MVC上傳檔案範例</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

 <form id="myForm">
	<input type="file" name="myfileUpload" id="myfileUpload" />
	<button type="submit">上傳檔案</button>
</form>
<div id="msg"></div>
<script>
$(document).ready(function(){
	$("#myForm").submit(function(e) {
		e.preventDefault(); // 停止觸發submit
		console.log("upload");
		var formData = new FormData($("#myForm")[0]); 
         // 使用FormData包裝form表單來傳輸資料
		$.ajax({
			type : "POST",
			url : "ajaxsave",
			data : formData,
			cache : false, // 不需要cache
			processData : false,
            // jQuery預設會把data轉為query String, 所以要停用
			contentType : false, 
// jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
			//dataType: 'text',
			success : function(data) {
				$("#msg").html(data);
			},
			error : function(data) {
				alert(data.exception);
			}
		});
	});
});
</script>
</body>
</html>
