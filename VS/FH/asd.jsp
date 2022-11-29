<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h2>Product Information</h2>
<form:form>
   <table>
    <tr>
        <td><form:label path="product_ID">ID：</form:label></td>
        <td><form:input path="product_ID" /></td>
    </tr>
    <tr>
        <td><form:label path="product_catagory">種類：</form:label></td>
        <td><form:input path="product_catagory" /></td>
    </tr>
    <tr>
        <td><form:label path="product_Name">名字：</form:label></td>
        <td><form:input path="product_Name" /></td>
    </tr>
        <tr>
        <td><form:label path="product_price">價錢：</form:label></td>
        <td><form:input path="product_price" /></td>
    </tr>
        <tr>
        <td><form:label path="imagePath">路徑：</form:label></td>
        <td><form:input path="imagePath"/></td>
    </tr>
        <tr>
        <td><form:label path="product_describe">敘述：</form:label></td>
        <td><form:input path="product_describe" /></td>
    </tr>
    <tr>
        <td colspan="2">
                </td>
    </tr>
</table>  
            <input type="submit" id="submit" value="新增產品"/>
             <input type="button" id="button" value="查詢產品"/>
             <input type="button" id="button1" value="修改產品"/>
             <input type="button" id="button2" value="刪除產品"/>
<div id="div1"></div>
</form:form>
<script>
   function rs(data){
	
     $("#div1").html(data);
   }
   function send(evt){
	   evt.preventDefault();
	   var id=parseInt($("#product_ID").val());
	   var ca=$("#product_catagory").val();
	   var n=$("#product_Name").val();
	   var p=$("#product_price").val();
	   var i=$("#imagePath").val();
	   var d=$("#product_describe").val();
       $.post("product/insert",{"product_ID":id,"product_catagory":ca,"product_Name":n,"product_price":p,"imagePath":i,"product_describe":d},rs);
	   return false;
   }
   function send1()
   {
	   $.post("product/read",rs);
   }
   function send2(evt)
   {
	   evt.preventDefault();
	   var id=parseInt($("#product_ID").val());
	   var ca=$("#product_catagory").val();
	   var n=$("#product_Name").val();
	   var p=$("#product_price").val();
	   var i=$("#imagePath").val();
	   var d=$("#product_describe").val();
       $.post("product/update",{"product_ID":id,"product_catagory":ca,"product_Name":n,"product_price":p,"imagePath":i,"product_describe":d},ds);
	   return false;
   }
   function ds(data){
		alert('修改成功')
	     $("#div1").html(data);
	   }
   function send3(evt)
   {
	   evt.preventDefault();
	   var id=parseInt($("#product_ID").val());
	   var ca=$("#product_catagory").val();
	   var n=$("#product_Name").val();
	   var p=$("#product_price").val();
	   var i=$("#imagePath").val();
	   var d=$("#product_describe").val();
       $.post("product/delete",{"product_ID":id,"product_catagory":ca,"product_Name":n,"product_price":p,"imagePath":i,"product_describe":d},ws);
	   return false;
   }
   function ws(data){
	   alert('刪除成功')
	     $("#div1").html(data);
	   }
   function start(){
	   $("form").submit(send);
	   $("#button").click(send1);
	   $("#button1").click(send2);
	   $("#button2").click(send3);
   }
   $(document).ready(start);
</script>
</body>
</body>
</html>