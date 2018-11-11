

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
	<br> Your order:
	<br>
	<table>
		<tr>
			<td><b>Title</b></td>
			<td><b>Author</b></td>
			<td><b>Quantity</b></td>
		</tr>
		<c:forEach items="${shoppingCart.entries}" var="entry">
			<tr>
				<td><c:out value="${entry.key.title}"></c:out></td>
				<td><c:out value="${entry.key.author}"></c:out></td>
				<td><c:out value="${entry.value}"></c:out></td>
				
			</tr>
		</c:forEach>
	</table>
	
	<a href="seekBooks">Volver</a>
</body>
</html>

