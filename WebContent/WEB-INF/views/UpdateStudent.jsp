<%@page import="model.User"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin sinh viên</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100;0,200;0,300;0,400;1,100;1,200;1,300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/public/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="/public/css/style.css">
<script src="https://kit.fontawesome.com/501b9deca1.js" crossorigin="anonymous"></script>
<script>
	function showPassword() {
	  var x = document.getElementById("matkhau");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>
<style>
	body{
		background-color: #ebebeb;
	}
</style>
</head>
<body>
			<div class="container pt-3">
				<%
					String id = (String)session.getAttribute("id");
					User student = UserDAO.getUserByID(id);
				%>
				<h2 class="text-center text-muted mb-4">Cập nhật thông tin sinh viên</h2>
				<form action="${pageContext.request.contextPath}/HandleUpdateStudent">
				<div class="row">
					<div class="col-6 mx-auto">
						<label class="text-muted">Tên đăng nhập</label>
						<input type="text" value="<%=student.getUsername()%>" id="username" name="username" readonly/>
					</div>
				</div>
				<div class="row">
					<div class="col-6 mx-auto">
						<label class="text-muted">Mật khẩu</label>
						<input type="password" value="<%=student.getPassword()%>" id="password" name="password" required/>
						<span class="text-muted"><i class="fas fa-lock" onclick="showPassword()" style="left:95%"></i></span>
					</div>
				</div>
				<div class="row">
					<div class="col-6 mx-auto">
						<label class="text-muted">Tên</label>
						<input type="text" value="<%=student.getFirstname()%>" id="firstname" name="firstname" required/>
					</div>
				</div>
				<div class="row">
					<div class="col-6 mx-auto">
						<label class="text-muted">Họ</label>
						<input type="text" value="<%=student.getLastname()%>" id="lastname" name="lastname" required/>
					</div>
				</div>
				<div class="row">
					<div class="col-6 mx-auto  text-center">
						<input type="submit" class="btn btn-primary" value="Cập nhật"/>
					</div>
				</div>
				</form>
			</div>
</body>
</html>