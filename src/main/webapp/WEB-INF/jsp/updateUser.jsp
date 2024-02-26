<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">--%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<jsp:include page="welcome.jsp" />


		<h1>Edit User Form</h1>
		<form action="updateUser" method="POST" modelAttribute="user">
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="id">Id</label> <input type="text" value="${user.id}"
									class="form-control" id="id" name="id">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="username">UserName</label> <input
									class="form-control" id="username" name="username"
									placeholder="Enter username"> ${user.username } </input>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="password">Password</label> <input
									class="form-control" id="password" name="password"
									placeholder="Enter Password"> ${user.password } </input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="passwordConfirm">passwordConfirm</label> <input
									class="form-control" id="passwordConfirm" name="passwordConfirm"
									placeholder="Enter passwordConfirm"> ${user.passwordConfirm } </input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="roles">roles</label> <input
									class="form-control" id="roles" name="roles"
									placeholder="Enter Roles"> ${user.roles } </input>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="email">email</label> <input class="form-control"
									id="email" name="email" placeholder="Enter email">
								${user.email } </input>
							</div>
						</div>
					</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="address">address</label> <input class="form-control"
							id="address" name="address" placeholder="Enter address">
						${user.address } </input>
					</div>
					</div>
					</div>
				</thead>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>

		</form>
	</div>
</body>

</html>