<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>왜않사</title>

    <!-- 스타일 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/project.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/searchbar.css" />

    <script>
      window.contextPath = '${pageContext.request.contextPath}';
    </script>
    <script src="${pageContext.request.contextPath}/js/main.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/searchbar.js" defer></script>
    <script src="${pageContext.request.contextPath}/js/searchOverlay.js" defer></script>
</head>
<body>
  <div id="container">
    <tiles:insertAttribute name="menu"/>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="searchOverlay"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>
  </div>
</body>
</html>
