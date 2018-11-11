<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title"/></title>
</head>
<body>
	<h1 style="text-align: center;"><spring:message code="title"/></h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="welcome"/></h2>
	<br />
	
	
	<c:if test="${!validationErrors}">
		<form:form modelAttribute="eleccionViajeRequest">
			<c:choose>
				<c:when test="${not empty viajesIdaList}" >
					<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
			
					<table>
						<tr>
							<th></th>
							<th><spring:message code="buscarViaje.resultados.origen"/></th>
							<th><spring:message code="buscarViaje.resultados.destino"/></th>
							<th><spring:message code="buscarViaje.resultados.fechaSalida"/></th>	
							<th><spring:message code="buscarViaje.resultados.plazasTotales"/></th>
							<th><spring:message code="buscarViaje.resultados.plazasQuedan"/></th>
							<th><spring:message code="buscarViaje.resultados.precio"/></th>
						</tr>
						
						<c:set var="selectFirstOne" value="true"/>
						<c:forEach items="${viajesIdaList}" var="viaje">
							<tr>
								<c:choose>
									<c:when test="${selectFirstOne = 'true'}">
										<td><form:radiobutton path="idViajeIda"  value="${viaje.id}" name="viajeId" checked="checked" /></td>
										<c:set var="selectFirstOne" value="false"/>
									</c:when>
									<c:otherwise>
										<td><form:radiobutton path="idViajeIda"  value="${viaje.id}" name="viajeId" /></td>
									</c:otherwise>
								</c:choose>
								
								<td><c:out value="${viaje.origen}"></c:out></td>
								<td><c:out value="${viaje.destino}"></c:out></td>
								<td><fmt:formatDate value="${viaje.f_salida}" pattern="yyyy-MM-dd HH:mm" /></td>
								<td><c:out value="${viaje.plazas_totales}"></c:out></td>
								<td><c:out value="${viaje.plazas_quedan}"></c:out></td>
								<td><c:out value="${viaje.precio}"></c:out></td>	
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty param}">
						<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
						<spring:message code="${mensajeViajesIda}" var="mensajeViajesIdaVar"/>
						<p><c:out value="${mensajeViajesIdaVar}"/></p>
					
					</c:if>
				</c:otherwise>
			</c:choose>
	
		
					<c:when test="${not empty viajesVueltaList }" >
						<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
								
							<table >
							<tr>
								<th></th>
								<th><spring:message code="buscarViaje.resultados.origen"/></th>
								<th><spring:message code="buscarViaje.resultados.destino"/></th>
								<th><spring:message code="buscarViaje.resultados.fechaSalida"/></th>
								<th><spring:message code="buscarViaje.resultados.plazasQuedan"/></th>
								<th><spring:message code="buscarViaje.resultados.plazasTotales"/></th>
								<th><spring:message code="buscarViaje.resultados.precio"/></th>
							</tr>
							
							<c:forEach items="${viajesVueltaList}" var="viaje">
								<tr>
									<c:choose>
										<c:when test="${selectFirstOne = 'true'}">
											<td><form:radiobutton path="idViajeVuelta"  value="${viaje.id}" name="billeteVueltaId" checked="checked"/></td>
											<c:set var="selectFirstOne" value="false"/>
										</c:when>
										<c:otherwise>
											<td><form:radiobutton path="id"  value="${viaje.id}" name="billeteVueltaId"/></td>
										</c:otherwise>
									</c:choose>
									<td><c:out value="${viaje.origen}"></c:out></td>
									<td><c:out value="${viaje.destino}"></c:out></td>
									<td><fmt:formatDate value="${viaje.fechaSalida}" pattern="yyyy-MM-dd HH:mm" /></td>
									<td><c:out value="${viaje.plazasTotales}"></c:out></td>
									<td><c:out value="${viaje.plazasRestantes}"></c:out></td>
									<td><c:out value="${viaje.precio}"></c:out></td>	
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
						<p><c:out value="${mensajeViajesVuelta}"/></p>
					</c:otherwise>
				<input name="submit" type="submit" value="${submitText}" />
		
		</form:form>
			</c:if>

</body>
</html>