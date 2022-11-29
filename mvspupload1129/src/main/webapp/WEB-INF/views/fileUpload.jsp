<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC上傳檔案範例</title>
</head>
<body>
  <form:form method="post" action="savefile"  enctype="multipart/form-data">
      請選擇一個檔案上傳 : 
      <input type="file" name="file" />
        <input type="submit" value="提交上傳" />
    </form:form>
</body>
</html>

