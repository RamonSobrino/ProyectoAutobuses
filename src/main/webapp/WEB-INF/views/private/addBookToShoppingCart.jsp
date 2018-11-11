

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Amazin</title>
</head>
<body>
<title>Amazin</title>
</head>
<body>
	<h1 style="text-align: center;"><spring:message code="title"/></h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="welcome"/></h2>
	<br />
	Select book and quantity:
	<form:form modelAttribute="order">
		<form:select itemValue="id" itemLabel="title"  path="book.id" items="${bookList}"/>
		<form:select path="number" items="${numbers}"/>
		<input type="submit"/>
	</form:form>
	<p style="color: red;">
		<c:out value="${message}"/>
	</p>
	
</body>
</html>

