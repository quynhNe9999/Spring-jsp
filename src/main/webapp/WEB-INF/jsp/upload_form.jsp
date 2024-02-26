<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spring Boot Image Upload example</title>
    <!-- Include any necessary CSS or JS files here -->
</head>
<body>

<div class="container" style="max-width: 500px">
    <h3 class="mb-3">Spring Boot Image Upload example</h3>

    <form id="uploadForm" method="post" action="<c:url value='/images/upload'/>" enctype="multipart/form-data">
        <input id="input-file" type="file" name="file" accept="image/png, image/jpeg" />
        <button class="btn btn-sm btn-outline-success float-right" type="submit">
            Upload
        </button>
    </form>

    <c:if test="${not empty message}">
        <div class="alert alert-secondary alert-dismissible fade show text-center message mt-3" role="alert">
            ${message}
            <button type="button" class="close btn-sm" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>
    </c:if>
</div>

<!-- Include any necessary JavaScript files here -->

</body>
</html>
