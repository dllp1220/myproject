<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>提交的產品資訊如下 - </h2>
   <table>
    <tr>
        <td>id：</td>
        <td>${product_ID}</td>
    </tr>
    <tr>
        <td>catagory：</td>
        <td>${product_catagory}</td>
    </tr>
    <tr>
        <td>product_Name：</td>
        <td>${product_Name}</td>
    </tr>
        <tr>
        <td>product_price：</td>
        <td>${product_price}</td>
    </tr>
        <tr>
        <td>imagePath：</td>
        <td>${imagePath}</td>
    </tr>
        <tr>
        <td>product_describe：</td>
        <td>${product_describe}</td>
    </tr>
</table>
</body>
</html>