<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!-- template 파일. -->
<!DOCTYPE html>
<html lang="ko">
    <head>
    	<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>왜않사</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/project.css">
   	</head>
   	 <body>
  		<div id="container">
			<tiles:insertAttribute name="menu"/>
    		<tiles:insertAttribute name="body"/>
			<tiles:insertAttribute name="footer"/>
		</div>
    </body>
    <script src="js/main.js"></script>
</html>