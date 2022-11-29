<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>提交的產品資訊如下 - </h2>
<table border="1" width="70%">

    <tr>
        <th>id：</th><th>catagory：</th><th>product_Name：</th><th>product_price：</th><th>imagePath：</th><th>product_describe：</th>
	</tr><tr>
	   <c:forEach items="${productsList}" var="node">  
        <td>${node.product_ID}</td><td>${node.product_catagory}</td><td>${node.product_Name}</td><td>${node.product_price}</td><td>${node.imagePath}</td><td>${node.product_describe}</td>
    </tr>
       </c:forEach>  
</table>
   <br/>  
</body>
</html>