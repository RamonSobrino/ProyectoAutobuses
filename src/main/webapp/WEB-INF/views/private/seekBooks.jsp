

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
	<br> Our Catalog:
	<br>
	<table>
		<tr>
			<td><b>Title</b></td>
			<td><b>Author</b></td>
			<td><b>Description</b></td>
			<td><b>Price</b></td>
		</tr>
		<c:forEach items="${booklist}" var="book">
			<tr>
				<td><c:out value="${book.title}"></c:out></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.description}"></c:out></td>
				<td><c:out value="${book.price}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<a href="newBook">Add new books to the catalog</a> <br/>
	<a href="shoppingCart">Add books to the shopping cart</a>
</body>
</html>

