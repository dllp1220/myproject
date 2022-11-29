<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<body>
	<!-- Button to Open the Modal -->
	<button id="button1" type="button" class="btn btn-primary"
		data-toggle="modal" data-target="#myModal">Reservation</button>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Reservation Heading</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					用餐日期 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" id="theDate" '/> 
					<br/>
					<br/>
					請選擇用餐時段<select id="time">
						<option disabled="請選擇用餐時段">請選擇用餐時段</option>
						<option value="1" data-testid="11:00">11:00</option>
						<option value="2" data-testid="12:00">12:00</option>
						<option value="3" data-testid="13:00">13:00</option>
						<option value="4" data-testid="17:00">17:00</option>
						<option value="5" data-testid="18:00">18:00</option>
						<option value="6" data-testid="19:00">19:00</option>
						<option value="7" data-testid="20:00">20:00</option>
				</select>
				<br/>
				<br/>
					用餐人數&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="people">
						<option disabled="請選擇用餐人數">請選擇用餐人數</option>
						<option value="1" data-testid="1位大人">1位大人</option>
						<option value="2" data-testid="2位大人">2位大人</option>
						<option value="3" data-testid="3位大人">3位大人</option>
						<option value="4" data-testid="4位大人">4位大人</option>
						<option value="5" data-testid="5位大人">5位大人</option>
						<option value="6" data-testid="6位大人">6位大人</option>
				</select>				
				<br/>
				<br/>
				請輸入訂位者姓名<input type="text" id="name"/>
					<br/>
				<br/>
				請輸入訂位者電話<input type="text" id="name"/>
					<br/>
				<br/>
				請輸入訂位者信箱<input type="text" id="name"/>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Send</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function show() {
			var now = new Date();
			var yy = now.getFullYear();
			var dd = now.getDate() + 1 < 10 ? "0" + (now.getDate() + 1) : now
					.getDate() + 1;
			var mm = now.getMonth() + 1 < 10 ? "0" + (now.getMonth() + 1)
					: (now.getMonth() + 1);
			var today = yy + "-" + mm + "-" + dd;
			$("#theDate").attr("min", today);
		}
		function send() {
			$("#button1").click(show);
		}
		$(document).ready(send);
	</script>
</body>
</html>