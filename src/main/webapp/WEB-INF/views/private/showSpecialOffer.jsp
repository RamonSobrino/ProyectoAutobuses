

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
	<h2 style="text-align: center;">Welcome to the smallest virtual shop in
		the world!</h2>
	<br>
	<br> Out special offer today is..
	<br />
	<c:forEach items="${books}" var="book">
		<c:out value="${book.title }" />
		and you can have it for just 
		<b><c:out value="${book.price }" /></b>
		<br/>
	</c:forEach>
	<br />
</body>

</html>
