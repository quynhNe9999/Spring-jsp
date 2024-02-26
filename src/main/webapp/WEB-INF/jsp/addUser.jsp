<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">--%>
<title>Insert title here</title>
</head>
<body>
<div class="container">

   	    <jsp:include page="welcome.jsp"/>


	<div class="container mt-3">

		<h1>Add User Form</h1>
		<form action="insertUser" method="post">
			<table class="table table-striped table-bordered">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="username">UserName</label> <input type="text"
							class="form-control" id="username" name="username"
							placeholder="Enter UserName">
					</div>
				</div>
			</div>
			

						<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="password">password</label> <input type="text"
							class="form-control" id="password" name="password"
							placeholder="Enter password">
					</div>
				</div>
			</div>
					<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="passwordConfirm">passwordConfirm</label> <input type="text"
							class="form-control" id="passwordConfirm" name="passwordConfirm"
							placeholder="Enter passwordConfirm">
					</div>
				</div>
			</div>
					<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="roles">roles</label> <input type="text"
							class="form-control" id="roles" name="roles"
							placeholder="Enter roles">
					</div>
				</div>
			</div>
			
						<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="email">email</label> <input type="text"
							class="form-control" id="email" name="email"
							placeholder="Enter email">
					</div>
				</div>
			</div>
			
			
						<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="address">address</label> <input type="text"
							class="form-control" id="address" name="address"
							placeholder="Enter address">
					</div>
				</div>
			</div>
			</table>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</div>
</body>

</html>