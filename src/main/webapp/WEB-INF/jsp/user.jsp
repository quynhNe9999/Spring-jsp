<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>


	<div class="container">

		<jsp:include page="welcome.jsp" />

		<h1>Add User</h1>
		<a href="addUser" class="btn btn-primary"> Add User </a>
		<div class="row">
			<br>
			<div>
				<!-- tìm kiếm -->
				<form>
					<tr>
						<td>Search: <input name="keyword" type="text" /></td>
						<td><input type="submit" value=" Search" /></td>
					</tr>
				</form>
			</div>

			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>UserName</th>
						<!-- 	<th>Password</th>-->
						<!-- <th>PasswordConfirm</th> -->
						<th>Email</th>
						<th>Roles</th>
						<th>Address</th>
						<th>Funtion</th>
					</tr>

				</thead>

				<tbody>
					<%-- 					<c:out value="${users.content}" />
 --%>
					<c:forEach var="user" items="${users.content}">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<!--  	<td>${user.password}</td>-->
							<%--  	<td>${user.passwordConfirm}</td> --%>
							<td>${user.email}</td>
							<td>${user.roles}</td>

							<td>${user.address}</td>

							<td><a href="editUser/${user.id}" class="btn btn-warning">
									Edit </a> <a href="deleteUser/${user.id}" class="btn btn-danger">
									Delete </a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<!-- Display Pagination Controls -->
			<div>
				<span>Page ${users.number + 1} of ${users.totalPages}</span> <span>Total
					Users: ${users.totalElements}</span>
				<ul>
					<!-- Display Previous Page link if applicable -->
					<c:if test="${not users.first}">
						<li><a
							href="<c:url value='/user'>
                               <c:param name='page' value='${users.number - 1}'/>
                               <c:param name='size' value='${users.size}'/>
                               <c:param name='keyword' value='${param.keyword}'/>
                           </c:url>">Previous</a>
						</li>
					</c:if>

					<!-- Display Page numbers -->
					<c:forEach var="i" begin="0" end="${users.totalPages - 1}">
						<li><a
							href="<c:url value='/user'>
                               <c:param name='page' value='${i}'/>
                               <c:param name='size' value='${users.size}'/>
                               <c:param name='keyword' value='${param.keyword}'/>
                           </c:url>">${i + 1}</a>
						</li>
					</c:forEach>

					<!-- Display Next Page link if applicable -->
					<c:if test="${not users.last}">
						<li><a
							href="<c:url value='/user'>
                               <c:param name='page' value='${users.number + 1}'/>
                               <c:param name='size' value='${users.size}'/>
                               <c:param name='keyword' value='${param.keyword}'/>
                           </c:url>">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>

</html>