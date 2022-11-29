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
<table border="1" width="70%">
      <tr>    
      <th>Employee No</th>
      <th>First Name</th>
      <th>Extension</th>
      <th>Email</th>    
      </tr>
        <c:forEach  var="current"  items="${employees}" >
        <tr>
          <td><c:out value="${current.employeeNumber}" /></td>
          <td><c:out value="${current.firstName}" /></td>
          <td><c:out value="${current.extension}" /></td>
          <td><c:out value="${current.email}" /></td>          
        </tr>
      </c:forEach>
    </table>

</body>
</html>
