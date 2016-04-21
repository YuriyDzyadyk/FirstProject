<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<section id="content">
		<div class="wrapper pad1">
			<article
				style="display: block; float: left; padding-left: 37px; width: 287px"
				class="col1">
				<div class="box1">
					<h2 class="top">Contact Us</h2>
					<div class="pad">
						<div class="wrapper pad_bot1">
							<p class="cols pad_bot2">
								<strong>Country:<br> City:<br> Address:<br>
									Email:
								</strong>
							</p>
							<p class="color1 pad_bot2">
								UA<br> Lviv<br> Lviv st. 54<br> <a href="#">Mail@mail.com</a>
							</p>
						</div>
					</div>
					<h2>Info</h2>
					<div class="pad pad_bot1">
						<p class="pad_bot2">Please don't forgot to specify the return
							address</p>
					</div>
				</div>
			</article>
			<article
				style="display: block; float: left; padding-left: 42px; width: 550px"
				class="col2">
				<h3 class="pad_top1">Contact Form</h3>
				<c:url value="/contacts/send/" var="SendUrl" />
				<form id="ContactForm" action="${SendUrl}" method="POST">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div>
						<div style="min-height: 25px" class="wrapper">
							<span style="float: left">Email:</span> <input type="text"
								class="input" name="email">
						</div>
						<div style="min-height: 25px" class="wrapper">
							<span style="float: left">Subject:</span> <input type="text"
								class="input" name="content">
						</div>
						<div
							style="min-height: 470px; padding-bottom: 6px; width: 100%; overflow: hidden"
							class="textarea_box">
							<span width:65px;
	 style="float: left">Message:</span>
							<textarea
								style="overflow: auto; width: 99%; background: #fff; border: 1px solid #e5e5e5; font: 12px Arial, Helvetica, sans-serif; color: #7f7f7f; float: left; padding: 2px 7px; height: 457px; margin: 0; float: left"
								cols="1" rows="1" name="path"></textarea>
						</div>
						<input
							style="margin-left: 10px; float: right; border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; background: 0 0px repeat-x #1d77e9; display: inline-block; font-size: 13px; color: #fff; text-decoration: none; line-height: 28px; height: 30px; padding: 0 19px; position: relative; outline: none; cursor: pointer"
							type="submit" value="Send" />
						<!--     <a  href="#" class="button1"><strong>Clear</strong></a> </div> -->
				</form>
			</article>
		</div>
	</section>














	<%-- 
<p>${String}</p> 

<table>

<c:forEach items="${Colors}" var="Clr"> <!-- листаємо клас кольори, та даємо йому значення Clr -->
   <tr>
   <!-- виводиться id і колір класу кольори  -->
   <td>${Clr.id}</td> 
   <td>${Clr.color}</td>
   </tr>
    
   
</c:forEach>






</table> --%>
</body>
</html>