<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<%-- 		<%="welcome to jsp"%>
 --%>

		<h1>Add Sinh vien Form</h1>
		<a href="/addSinhVien" class="btn btn-primary"> Add Sinh Vien </a> <br>
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
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Image</th>
					<th>Funtion</th>
				</tr>

			</thead>

			<tbody>
				<%--<c:out value="${data.content}" /> --%>

				<c:forEach var="sinhVien" items="${data.content}">
					<tr>
						<td>${sinhVien.id}</td>
						<td>${sinhVien.name}</td>
						<td>${sinhVien.email}</td>
						<td>${sinhVien.address}</td>
						<td><c:if test="${not empty sinhVien.image}">
							<img src="<c:url value='/view/${sinhVien.id}'/>" width="50"
								height="50">
						</c:if></td>
						<%-- <td>${sinhVien.image}</td> --%>


						<td><a href="/editSinhVien/${sinhVien.id}"
							class="btn btn-warning"> Edit </a> <a
							href="/deleteSinhVien/${sinhVien.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Display Pagination Controls -->
		<div>

			<ul>
				<!-- Display Previous Page link if applicable -->
				<c:if test="${not data.first}">
					<li><a
						href="<c:url value='/view'>
                        <c:param name='page' value='${data.number - 1}'/>
                        <c:param name='size' value='${data.size}'/>
                        <c:param name='keyword' value='${param.keyword}'/>
                    </c:url>">Previous</a>
					</li>
				</c:if>

				<!-- Display Page numbers -->
				<c:forEach var="i" begin="0" end="${data.totalPages - 1}">
					<li><a
						href="<c:url value='/view'>
                        <c:param name='page' value='${i}'/>
                        <c:param name='size' value='${data.size}'/>
                        <c:param name='keyword' value='${param.keyword}'/>
                    </c:url>">${i + 1}</a>
					</li>
				</c:forEach>

				<!-- Display Next Page link if applicable -->
				<c:if test="${not data.last}">
					<li><a
						href="<c:url value='/view'>
                        <c:param name='page' value='${data.number + 1}'/>
                        <c:param name='size' value='${data.size}'/>
                        <c:param name='keyword' value='${param.keyword}'/>
                    </c:url>">Next</a>
					</li>
				</c:if>

				<span>Page ${data.number + 1} of ${data.totalPages}</span>
				<span>Total SinhVien: ${data.totalElements}</span>
			</ul>
		</div>

	</div>
</body>

</html>