<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href = "css/style.css">
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>

<h3><c:out value="${ person.firstName }"/> <c:out value="${ person.lastName }"/></h3>

<p>
License Number:<c:out value="${ person.license.number }" />
</p>
<p>
State:<c:out value="${ person.license.state }" />
</p>
<p>
Exp. date:<c:out value="${ person.license.expiration_date }" />
</p>

</body>
</html>