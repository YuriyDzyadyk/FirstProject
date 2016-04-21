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
	<!-- /contacts значення по якому йде звязок з контроллером ; contUrl це те що звязує html href i JSP contact, появиться у пошуковій стрічці   
 <c:url value="/contacts" var="contUrl"/><a href="${contUrl}">First Link</a>
 -->
	<h2>Choose car and date</h2>
	<p>for properly work javascript is needed :(</p>
	<!-- / значення по якому йде звязок з контроллером ; url це те що звязує html href i JSP contact, появиться у пошуковій стрічці   -->
	<c:url value="/" var="url" />
	<form action="${url}?${_csrf.parameterName}=${_csrf.token}"
		method="post">
		<!--  
 <input type="text" name="MyInput"> type="text" - для внесення
  <input type="submit" value="Ok">  type="submit" - для затвердження -->

		<table>
			<tr>
				<td>model</td>
				<td>type of transport</td>
				<td>motor deport</td>
				<td>capacity (t)</td>
				<td>count of seats</td>
				<!-- -->
			</tr>
			<tr>
				<!-- type="text" - для внесення -->
				<td><select name="model">
						<!--name=" ***" підвязаний до <option value= *** - і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse model</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення, selected="selected"-виводить дефолкне значення як повідомлення  -->
						<c:forEach items="${models}" var="mdl">
							<!-- items="${models}" - звязне слово для моделі у контроллері  -->
							<option value="${mdl.id}">${mdl.carModel}</option>
						</c:forEach>
				</select></td>
				<td><select name="type">
						<!--name=" ***" підвязаний до <option value= *** - і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse type</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення , selected="selected"-виводить дефолкне значення як повідомлення-->
						<c:forEach items="${types}" var="tp">
							<option value="${tp.id}">${tp.transpType}</option>
						</c:forEach>
				</select></td>
				<td><select name="deport">
						<!--name=" ***" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse deport</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення, selected="selected"-виводить дефолкне значення як повідомлення  -->
						<c:forEach items="${deports}" var="dprt">
							<option value="${dprt.id}">${dprt.motordeport}</option>
						</c:forEach>
				</select></td>
				<td><select name="carPropertis">
						<!--name=" ***" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse capacity</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення, selected="selected"-виводить дефолкне значення як повідомлення  -->
						<c:forEach items="${cars}" var="crs">
							<option value="${crs.id}">${crs.loadCapisity}</option>
						</c:forEach>
				</select></td>
				<td><select name="carPropertis">
						<!--name=" ***" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse seats count</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення, selected="selected"-виводить дефолкне значення як повідомлення  -->
						<c:forEach items="${cars}" var="crs">
							<option value="${crs.id}">${crs.seatsCount}</option>
						</c:forEach>
				</select></td>
				<!-- -->
			</tr>
			<tr>
				<td>output year</td>
				<td>color</td>
				<!-- <td>date</td>
   <td>from city</td>
   <td>to city</td> -->
			</tr>
			<tr>
				<td><select name="CarPropertis">
						<!--name=" ***" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse car year</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення  -->
						<c:forEach items="${cars}" var="crs">
							<option value="${crs.id}">${crs.outputYear}</option>
						</c:forEach>
				</select></td>
				<td><select name="color">
						<!--name=" ***" підвязаний до <option value= *** -- і у jsp підтягує значення яке вказане у value=  -->
						<option selected="selected" value="0">Chouse color</option>
						<!--  disabled="disabled" --не дає вибирати дефолтне значення  -->
						<c:forEach items="${colors}" var="color">
							<option value="${color.id}">${color.color}</option>
						</c:forEach>
				</select></td>
				<td><input type="text" name="mydate"></td>
				<td><input type="text" name="from"></td>
				<!-- -->
				<td><input type="text" name="to"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<!-- type="submit" - для затвердження -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Ok"></td>
			</tr>


		</table>



	</form>

</body>
</html>