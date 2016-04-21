<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<%@ include file="../layout/taglib.jsp"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">



<title><tiles:getAsString name="title" /></title>
</head>
<body>
    <div style="height:88px;" class="row-1">
     	<div style="    color: #454545; line-height: 1em; font-family: Tahoma, Arial, helvetica, sans-serif; display: block; float: right; padding:34px 34px 0 0;" class="fright">
        <ul style=" line-height: 1em;   color: #454545; font-size: 0.75em; display: block; margin: 0; padding: 0; list-style: none;">
          <li style=" font-family: Tahoma, Arial, helvetica, sans-serif; line-height: 1em; color: #454545;font-size: 100%; list-style: none; display: list-item; text-align: -webkit-match-parent; float: left;    padding-left: 23px; margin: 0;    padding: 0;">
          <c:url value="/" var="indexUrl"/> <a style="margin-left: 5px; float: right;border-radius:5px; -moz-border-radius:5px; -webkit-border-radius:5px;background: 0 0px repeat-x #1d77e9;display: inline-block;font-size: 13px; color: #fff; text-decoration: none;line-height: 28px; height: 30px; padding: 0 19px; position: relative;    outline: none;cursor: pointer"
           href="${indexUrl}"><span>home</span></a></li>
          <li style=" font-family: Tahoma, Arial, helvetica, sans-serif; line-height: 1em; color: #454545;font-size: 100%; list-style: none; display: list-item; text-align: -webkit-match-parent; float: left;    padding-left: 23px; margin: 0;    padding: 0;">
          <c:url value="/contacts" var="contUrl"/> <a style="margin-left: 5px; float: right;border-radius:5px; -moz-border-radius:5px; -webkit-border-radius:5px;background: 0 0px repeat-x #1d77e9;display: inline-block;font-size: 13px; color: #fff; text-decoration: none;line-height: 28px; height: 30px; padding: 0 19px; position: relative;    outline: none;cursor: pointer"
          href="${contUrl}"><span>contacts</span></a></li>
          
        </ul>
      </div>
    </div>
    <div style="line-height: 1em; color: #454545; display: block; margin: 0;   padding: 0; margin-bottom: -3px;" class="row-2">
      <div class="left">
        <ul  style="list-style: none; overflow: hidden;">
          <li style=" background: #77DC7F; padding: 4px 2px 0 0; float: left;  text-transform: uppercase;   font-size: 16px;   line-height: 1.2em;">
          <c:url value="/" var="indexUrl"/><a style=" text-transform: uppercase;    font-size: 16px;    line-height: 1.2em; margin: 0; outline: none; text-decoration: none;    color: #fff;    width: 186px;    text-align: center;    display: block;   padding: 14px 0 0 0;   cursor: pointer; "href="${indexUrl}"><span>home</span></a></a></li>
          <li style=" background: #77DC7F; padding: 4px 2px 0 0; float: left;  text-transform: uppercase;   font-size: 16px;   line-height: 1.2em;">
          <c:url value="/sitemap" var="sitemapUrl"/><a style=" text-transform: uppercase;    font-size: 16px;    line-height: 1.2em; margin: 0; outline: none; text-decoration: none;    color: #fff;    width: 186px;    text-align: center;    display: block;   padding: 14px 0 0 0;   cursor: pointer;" href="${sitemapUrl}"><span>administrative</span></a></li>
          <li style=" background: #77DC7F; padding: 4px 2px 0 0; float: left;  text-transform: uppercase;   font-size: 16px;   line-height: 1.2em;">
          <c:url value="/contacts" var="contUrl"/> <a style=" text-transform: uppercase;    font-size: 16px;    line-height: 1.2em; margin: 0; outline: none; text-decoration: none;    color: #fff;    width: 186px;    text-align: center;    display: block;   padding: 14px 0 0 0;   cursor: pointer;" href="${contUrl}"><span>contacts</span></a></li>
          <li style=" background: #77DC7F; padding: 4px 2px 0 0; float: left;  text-transform: uppercase;   font-size: 16px;   line-height: 1.2em;">
          <c:url value="/about" var="aboutUrl"/><a style=" text-transform: uppercase;    font-size: 16px;    line-height: 1.2em; margin: 0; outline: none; text-decoration: none;    color: #fff;    width: 186px;    text-align: center;    display: block;   padding: 14px 0 0 0;   cursor: pointer;" href="${aboutUrl}"><span>about us</span></a></li>
          <li style=" background: #77DC7F; padding: 4px 2px 0 0; float: left;  text-transform: uppercase;   font-size: 16px;   line-height: 1.2em;">
          <c:url value="/services" var="servicesUrl"/> <a style=" text-transform: uppercase;    font-size: 16px;    line-height: 1.2em; margin: 0; outline: none; text-decoration: none;    color: #fff;    width: 186px;    text-align: center;    display: block;   padding: 14px 0 0 0;   cursor: pointer;" href="${servicesUrl}"><span>services and prices</span></a></li>
          </ul>
      </div>
    </div>
    <div style="font-size: 1.75em; display: block; margin: 0;    padding: 0; height: 276px; overflow: hidden; background: #454545 repeat-x left top;" class="row-3">
      <div style="padding: 35px 0 0 50px; margin: 0; position: relative;    z-index: 2;" class="inside">
        <h2 style=" font-family: Tahoma, Arial, helvetica, sans-serif;  color: #44AF23;   display: block;  -webkit-margin-before: 0.83em;    -webkit-margin-after: 0.83em;    -webkit-margin-start: 0px;    -webkit-margin-end: 0px;    font-weight: bold;margin: 0;  padding: 0; font-size: 40px; line-height: 1.2em;  margin-bottom: 10px;">Speed is the Source <b>of Emotions</b></h2>
        <p style=" font-family: Tahoma, Arial, helvetica, sans-serif;  color:#FFFFFF; font-size: 0.75em;">Sed ut perspiciatis unde omnis iste natus error sit volutem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis.</p>
      </div>
    </div>


	<!-- Основной контент страницы -->
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>

	<div class="footer">

		<!-- футер страницы -->
		<tiles:insertAttribute name="footer" />

	</div>
</body>
</html>