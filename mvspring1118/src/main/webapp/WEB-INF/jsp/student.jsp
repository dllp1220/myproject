<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表單處理</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<body>

<h2>Student Information</h2>
<form:form>
   <table>
    <tr>
        <td><form:label path="sname">名字：</form:label></td>
        <td><form:input path="sname" /></td>
    </tr>
    <tr>
        <td><form:label path="age">年齡：</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td><form:label path="sid">編號：</form:label></td>
        <td><form:input path="sid" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表單"/>
        </td>
    </tr>
</table>  
</form:form>
<div id="display"></div>
<script>
   function rs(data){
     $("#display").html(data);
   }
   function send(evt){
	   evt.preventDefault();
	   var id=parseInt($("#sid").val());
	   var n=$("#sname").val();
	   var v=parseInt($("#age").val());
       $.post("addStudent",{"sid":id,"sname":n,"age":v},rs);
	   return false;
   }
   function start(){
	   $("form").submit(send);
   }
   $(document).ready(start);
</script>
</body>
</html>

 
