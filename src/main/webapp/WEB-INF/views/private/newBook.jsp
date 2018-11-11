

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Amazin</title>
</head>
<body>
	<h1 style="text-align: center;">AMAZIN.COM</h1>
	<br>
	<h2 style="text-align: center;">Welcome to the smallest virtual
		shop in the world!</h2>
	<br> Introduce the new book's data:
	<form:form modelAttribute="book">
		<form:errors path="" />
		<br />
		Title: <form:input path="title" />
		<form:errors path="title" />
		<br />
		Description: <form:input path="description" />
		<form:errors path="description" />
		<br />
		Author: <form:input path="author" />
		<form:errors path="author" />
		<br />
		Type:
		<form:select itemValue="id" itemLabel="description"  path="family" items="${families}"/>
		<br/>
		Base price: <form:input path="basePrice" />
		<form:errors path="basePrice" />
		<br />
		<input type="submit" />
	</form:form>
	<!-- In case there was any error, we show it -->
	<p style="color: red;">
		<c:out value="${message}" />
	</p>

</body>
</html>

