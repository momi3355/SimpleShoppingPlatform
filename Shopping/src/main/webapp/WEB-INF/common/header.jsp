<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/searchbar.css">
<header class="header">
	<div class="header-inner">
		<!-- 검색창 -->
		<div class="search-box">
			<button type="button" id="openSearchBtn" class="search-bar-button">
				<span class="search-placeholder">검색어를 입력하세요</span>
				<svg width="20" height="20" fill="none" stroke="#ccc" stroke-width="1.5" viewBox="0 0 24 24">
					<path d="M21 21l-4.35-4.35M16 10.5A5.5 5.5 0 1 1 10.5 5a5.5 5.5 0 0 1 5.5 5.5z" />
				</svg>
			</button>
		</div>
	</div>
</header>
<script src="js/searchbar.js" defer></script>