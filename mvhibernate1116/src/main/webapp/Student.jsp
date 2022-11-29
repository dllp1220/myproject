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
      <th>sid</th>
      <th>sname</th>
      <th>age</th>      
      </tr>
        <c:forEach  var="current"  items="${Students}" >
        <tr>
          <td><c:out value="${current.sid}" /></td>
          <td><c:out value="${current.sname}" /></td>
          <td><c:out value="${current.age}" /></td>
      </tr>
      </c:forEach>
    </table>

</body>
</html>
