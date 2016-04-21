<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add car to car fleet</h2>
	<!--
<c:url value="/sitemap" var="carParamsUrl" /> --зєднання форми з контроллером
	<form action="${carParamsUrl}" method="POST"> --простір дії форми
 <input type="text" name="MyInput"> type="text" - для внесення
 <input type="submit" value="Ok">  type="submit" - для затвердженн
 -->
	<c:url value="/sitemap" var="carParamsUrl" />
	<form action="${carParamsUrl}?${_csrf.parameterName}=${_csrf.token}"
		enctype="multipart/form-data" method="POST">
		<!-- enctype="multipart/form-data" - for IMG -->
		<table>
			<tr>
				<td>model</td>
				<td>type of transport</td>
				<td>motor depot</td>
				<td>Capacity (t)</td>
				<td>Count of seats</td>
				<!-- -->
			</tr>
			<tr>
				<!-- type="text" - для внесення  <c:if test="${car eq null}"> </c:if>- якщо car = null    value="0" - те ж саме що і defaultValue="0"-->
				<c:if test="${car eq null}">
					<input type="hidden" name="id" value="0" />
					<td><input type="text" name="carModel" value=""></td>
					<td><input type="text" name="transpType"></td>
					<td><input type="text" name="motordepot"></td>
					<td><input type="text" name="capT"></td>
					<td><input type="text" name="seatsCount"></td>
				</c:if>
				<!-- type="text" - для внесення  <c:if test="${car ne null}"> </c:if>- якщо car != null тоді прописуємо у форми поля як дефолтні-->
				<c:if test="${car ne null}">
					<input type="hidden" name="id" value="${car.id}" />
					<td><input type="text" name="carModel"
						value="${car.carModel.carModel}"></td>
					<td><input type="text" name="transpType"
						value="${car.transpType.transpType}"></td>
					<td><input type="text" name="motordepot"
						value="${car.motordeport.motordeport}"></td>
					<td><input type="text" name="capT" value="${car.loadCapisity}"></td>
					<td><input type="text" name="seatsCount"
						value="${car.seatsCount}"></td>
				</c:if>
			</tr>
			<tr>
				<td>registration number</td>
				<td>output year</td>
				<td>color</td>
				<td></td>
				<!-- -->
			</tr>
			<tr>
				<c:if test="${car eq null}">
					<input type="hidden" name="id" value="0" />
					<td><input type="text" name="regNumber"></td>
					<td><input type="text" name="outputYear"></td>
					<td><input type="text" name="color"></td>
					<td></td>


				</c:if>
				<c:if test="${car ne null}">
					<input type="hidden" name="id" value="${car.id}" />
					<td><input type="text" name="regNumber"
						value="${car.regNumber}"></td>
					<td><input type="text" name="outputYear"
						value="${car.outputYear}"></td>
					<td><input type="text" name="color" value="${car.color.color}"></td>
					<td></td>
				</c:if>
				<!-- -->
			</tr>
			<tr>
				<td><input type="submit" value="Ok"></td>
				<!-- type="submit" - для затвердження -->
			</tr>

		</table>
	</form>

	<%-- <c:url value="/sitemap/not_int" var="not_intUrl" />
 --%>
	<!-- if спрацьовує коли вноситься не числове значення!!! якщо тест param.wrongtype не видасть true виведе все що в if -->
	<c:if test="${param.wrongtype eq true }">
		<div>
			Check entred values
			<!-- посилання назад на сторінку-->
			<c:url value="/sitemap" var="not_intUrl" />
			<a href="${not_intUrl}">beck</a>
		</div>
	</c:if>

	<c:if test="${param.wrongnumber eq true }">
		<div>
			This Reg. Number already exist
			<c:url value="/sitemap" var="already_existUrl" />
			<a href="${already_existUrl}">beck</a>
		</div>
	</c:if>

	<!-- ---- ---- ---- -->
	<c:url value="/sitemap/deleteAll" var="DeleteAllUrl" />
	<form action="${DeleteAllUrl}?${_csrf.parameterName}=${_csrf.token}"
		method="POST">
		<input type="submit" value="Delete All">
		<!-- type="submit" - для затвердження -->
	</form>
	<!-- ---- ---- ---- -->
	<table>
		<c:forEach items="${Cars}" var="Crs">
			<!-- листаємо клас car, та даємо йому значення Crs -->
			<tr>
				<!-- виводиться id і поля класу кар  -->
				<td>${Crs.id}</td>
				<td>${Crs.color.color}</td>
				<td>${Crs.transpType.transpType}</td>
				<td>${Crs.carModel.carModel}</td>
				<td>${Crs.motordeport.motordeport}</td>
				<td>${Crs.loadCapisity}</td>
				<td>${Crs.seatsCount}</td>
				<td>${Crs.regNumber}</td>
				<td>${Crs.outputYear}</td>
				<!-- виводиться звязує зсилку з ID поля  -->
				<td><c:url value="/sitemap/update/${Crs.id}" var="UpdateUrl" /><a
					href="${UpdateUrl}">Update</a></td>
				<td><c:url value="/sitemap/delete/${Crs.id}" var="DeleteUrl" /><a
					href="${DeleteUrl}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>



	<!-- files uploading   перший працює а решта ні-->

	<!-- зробити для машинки у табличці !!!-->
	<c:url value="/sitemap/upload" var="uploadUrl" />
	<c:forEach items="${Cars}" var="Crs">
		<form action="${uploadUrl}?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data" method="POST">
			<p>${Crs.id}</p>
			<input type="hidden" name="id" value="${Crs.id}" /> <input
				type="file" name="file" /> <input type="submit" value="Ok">
		</form>
	</c:forEach>




	<!-- вибрати з випадаючого списку -->
	
	<%-- <c:url value="/sitemap/find" var="FindUrl" />
	<form action="${FindUrl}?${_csrf.parameterName}=${_csrf.token}"
		method="POST">
		<input type="submit" value="Find">
			<!-- type="submit" - для затвердження -->
	</form> --%>
	
	
	<%-- <c:url value="/sitemap/color" var="selectColorUrl" />
	<form action="${selectColorUrl}?${_csrf.parameterName}=${_csrf.token}"
		method="POST">
		<select name="dd">
			<!--name="dd" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
			<option selected="selected" disabled="disabled" value="0">Chouse
				color</option>
			<!--  disabled="disabled" --не дає вибирати дефолтне значення  -->
			<c:forEach items="${colors}" var="color">
				<option value="${color.id}">${color.color}</option>
			</c:forEach>
		</select>
	</form> --%>


</body>
</html>