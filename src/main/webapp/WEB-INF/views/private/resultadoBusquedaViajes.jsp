<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amazin</title>
</head>
<body>
	<h1 style="text-align: center;"><spring:message code="title"/></h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="welcome"/></h2>
	<br /><form:form action="buscarViaje" commandName="busquedaViajeRequest" >	
		<spring:hasBindErrors name="busquedaViajeRequest">
			<section id="errors">
			 	<c:set var="validationErrors" value="true" />
				<p><spring:message code="buscarViaje.mensajeErrorCabecera"/></p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
					
				</ul>
			</section>
    	</spring:hasBindErrors>
    	

		<p>
			<form:label path="origen"><spring:message code="buscarViaje.form.origen"/></form:label>
			<form:input path="origen" value="${busquedaViajeRequest.origen}"/>
			<form:label path="origen"><spring:message code="buscarViaje.form.destino"/></form:label>
			<form:input path="destino" value="${busquedaViajeRequest.destino}"/>
			
		</p>
		<p>
			<form:label path="fechaIda"><spring:message code="buscarViaje.form.fechaIda"/></form:label>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${busquedaViajeRequest.fechaIda}" var="parsedFechaIda" />
			<form:input path="fechaIda" value="${busquedaViajeRequest}" />
			
			<form:label path="fechaVuelta"><spring:message code="buscarViaje.form.fechaVuelta"/></form:label>
			<fmt:formatDate pattern="dd-MM-yyyy" value="${busquedaViajeRequest.fechaVuelta}" var="parsedFechaVuelta" />
			<form:input  path="fechaVuelta" value="${busquedaViajeRequest}" />
		</p>
		<p>
			<form:label path="plazas"><spring:message code="buscarViaje.form.plazas"/></form:label>
			<form:input  path="plazas" value="${busquedaViajeRequest.plazas}"/>
		</p>
		
		<fieldset>
				<spring:message code="buscarViaje.form.idaVuelta" var="radioButtonIdaVuelta"/>
            	<form:checkbox path="idaYVuelta" />
        </fieldset>
        
		<spring:message code="buscarViaje.form.submit" var="submitText"/>
		<input name="submit" type="submit" value="${submitText}" />
	</form:form>
	
	
	
	
	<c:if test="${!validationErrors}">
		<form:form action="processForm" method="post" commandName="billete">
			<c:choose>
				<c:when test="${not empty viajesIdaList}" >
					<h3><spring:message code="buscarViaje.h3.viajesIda"/></h3>
			
					<table class="table table-bordered table-condense">
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
										<td><form:radiobutton path="viajeId"  value="${viaje.viajeId}" name="viajeId" checked="checked" /></td>
										<c:set var="selectFirstOne" value="false"/>
									</c:when>
									<c:otherwise>
										<td><form:radiobutton path="viajeId"  value="${viaje.viajeId}" name="viajeId" /></td>
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
	
			<c:if test="${param.tipo eq 'vuelta'}">
				<form:input path="tipo" type="hidden" value="vuelta"/>
				<c:choose>
					<c:when test="${not empty viajesVueltaList }" >
						<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
								
							<table class="table table-bordered table-condense">
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
											<td><form:radiobutton path="billeteVueltaId"  value="${viaje.viajeId}" name="billeteVueltaId" checked="checked"/></td>
											<c:set var="selectFirstOne" value="false"/>
										</c:when>
										<c:otherwise>
											<td><form:radiobutton path="billeteVueltaId"  value="${viaje.viajeId}" name="billeteVueltaId"/></td>
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
						<h3><spring:message code="buscarViaje.h3.viajesVuelta"/></h3>
						<p><c:out value="${mensajeViajesVuelta}"/></p>
					</c:otherwise>
				</c:choose>
			</c:if>
		
		</form:form>
	</c:if>

</body>
</html>