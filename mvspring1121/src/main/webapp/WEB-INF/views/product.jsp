<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tables</title>
</head>
<body>
<table border="1" width="80%">
      <tr>    
      <th>Product Code</th>
      <th>Product Name</th>
      <th>Description</th>
      <th>Buy Price</th>
      <th>Quantity</th>
    
      </tr>
        <c:forEach  var="current"  items="${products}" >
        <tr>
          <td><c:out value="${current.productCode}" /></td>
          <td><c:out value="${current.productName}" /></td>
          <td><c:out value="${current.description}" /></td>
          <td><c:out value="${current.buyPrice}" /></td>
          <td><c:out value="${current.quantityInStock}" /></td>             
        </tr>
      </c:forEach>
    </table>

</body>
</html> 
