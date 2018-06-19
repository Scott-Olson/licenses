<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href = "css/style.css">
<meta charset="UTF-8">
<title>License </title>
</head>
<body>
<h1>New License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">
    <p>
        <form:label path="person">Person:</form:label>
        
        <form:errors path="person"/>
        <form:select path="person">
        	<c:forEach items="${ persons }" var="p">
        		<option value="${p.id}">${p.firstName } ${p.lastName }</option>
        	</c:forEach>
        </form:select>	
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expiration_date">Expiration Date</form:label>
        <form:errors path="expiration_date"/>
        <form:input type="date" path="expiration_date"/>
    </p>
    
    <input type="submit" value="Create"/>
</form:form>

</body>
</html>