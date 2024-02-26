<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Images</title>
<!-- Include any necessary CSS or JS files here -->
</head>
<body>

	<div class="container-fluid" style="max-width: 600px; margin: 0 auto;">
		<h2 class="text-center">List of Images</h2>

		<c:if test="${not empty images}">
			<table class="table table-hover">
				<thead class="thead-light">
					<tr>
						<th scope="col">Image</th>
						<th scope="col">File Name</th>
						<th scope="col">Link</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="image" items="${images}">
						<tr>
							<td><img src="<c:url value='${image.url}'/>"
								alt="${image.name}" height="60px" /></td>
							<td>${image.name}</td>
							<td><a href="<c:url value='${image.url}'/>" target="_blank">Download</a></td>
							<td><a href="<c:url value='/images/delete/'/>${image.name}"
								title="Delete this image"
								class="fa-regular fa-trash-can icon-dark btn-delete"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty images}">
			<div>No files found!</div>
		</c:if>
	</div>

	<!-- Include any necessary JavaScript files here -->

</body>
</html>
