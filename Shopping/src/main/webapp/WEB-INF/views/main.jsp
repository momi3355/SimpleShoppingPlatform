<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
	<div class="header-inner">
		<!-- 검색창 -->
		<div class="search-box">
			<input type="text" placeholder="검색어를 입력하세요" id="searchInput" class="search-input" />
			<button class="search-button" aria-label="검색버튼">
				<svg width="20" height="20" fill="none" stroke="#ccc" stroke-width="1.5" viewBox="0 0 24 24">
					<path d="M21 21l-4.35-4.35M16 10.5A5.5 5.5 0 1 1 10.5 5a5.5 5.5 0 0 1 5.5 5.5z" />
				</svg>
			</button>
		</div>
	</div>
</header>
<main id="main-container">
	<!-- 탭 메뉴 (PC 전용) -->
	<nav class="tab-nav">
		<ul class="tab-list">
			<li class="tab-item active" data-tab="new">메인</li>
			<li class="tab-item" data-tab="outerwear">아우터</li>
			<li class="tab-item" data-tab="top">상의</li>
			<li class="tab-item" data-tab="bottom">하의</li>
			<li class="tab-item" data-tab="shoes">신발</li>
			<li class="tab-item" data-tab="accessories">패션소품</li>
		</ul>
	</nav>
	<!-- 탭 컨텐츠 -->
	<section class="tab-content">
		<div class="tab-panel active" id="tab-new">
			<!-- 메인 컨텐츠 -->
			<div class="main-banner swiper mySwiper">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/641046cc581b4fd99550cd18d88ee04b.jpg"
							alt="배너1">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/01/09/4e1c2bf9afaa437283b98dc35a14c522.jpg"
							alt="배너2">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/d00960226c054991b6c92f699194f2d3.jpg"
							alt="배너3">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/c9d52983547a4c60a5d25f4773269a3c.jpg"
							alt="배너4">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/641046cc581b4fd99550cd18d88ee04b.jpg"
							alt="배너1">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/01/09/4e1c2bf9afaa437283b98dc35a14c522.jpg"
							alt="배너2">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/d00960226c054991b6c92f699194f2d3.jpg"
							alt="배너3">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/c9d52983547a4c60a5d25f4773269a3c.jpg"
							alt="배너4">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/641046cc581b4fd99550cd18d88ee04b.jpg"
							alt="배너1">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/01/09/4e1c2bf9afaa437283b98dc35a14c522.jpg"
							alt="배너2">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/d00960226c054991b6c92f699194f2d3.jpg"
							alt="배너3">
					</div>
					<div class="swiper-slide">
						<img src="https://image.msscdn.net/display/images/2025/04/11/c9d52983547a4c60a5d25f4773269a3c.jpg"
							alt="배너4">
					</div>
				</div>

				<!-- 좌우 버튼 -->
				<!-- Swiper 슬라이더 내부에 추가 -->
				<div class="swiper-button-custom">
					<!-- 이전 버튼 -->
					<button type="button" class="swiper-custom-prev" aria-label="이전 배너 보기">
						<svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 40 40" fill="none">
							<circle cx="20" cy="20" r="19.5" fill="white" stroke="#E0E0E0"></circle>
							<path d="M22.5 27L15.7121 20.2119C15.595 20.0948 15.595 19.9048 15.7121 19.7877L22.5 13" stroke="black"
								stroke-width="1.5"></path>
						</svg>
					</button>

					<!-- 다음 버튼 -->
					<button type="button" class="swiper-custom-next" aria-label="다음 배너 보기">
						<svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 40 40" fill="none">
							<circle cx="20" cy="20" r="19.5" fill="white" stroke="#E0E0E0"></circle>
							<path d="M17.5 27L24.2879 20.2119C24.405 20.0948 24.405 19.9048 24.2879 19.7877L17.5 13" stroke="black"
								stroke-width="1.5"></path>
						</svg>
					</button>
				</div>
			</div>
			<!-- 오늘의 타임세일 섹션 (PC 전용) -->
			<section class="timesale-section">
				<header class="section-header">
					<h3>오늘의 신상품!</h3>
				</header>
				<div class="product-list-grid">
					<c:forEach var="product" items="${productList}">
						<div class="product-card">
							<a href="/product/detail?product_code=${product.productCode}">
								<div class="product-image">
									<img src="${product.imageUrlFir}" alt="${product.imageDescription}" />
								</div>
								<div class="product-info">
									<p class="brand">${product.productCategory}</p>
									<p class="name">${product.productName}</p>
									<p class="price">
										<c:if test="${product.originalPrice > product.price}">
											<span class="discount">${product.discountRate}%</span>
										</c:if>
										${product.price}원
									</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</section>
			<!-- 인기상품! -->
			<section class="popular-section">
				<header class="section-header">
					<h3>인기상품</h3>
				</header>
				<div class="product-list-grid">
					<c:forEach var="product" items="${popularList}" varStatus="status">
						<div class="product-card">
							<span class="ranking-badge">${status.index + 1}</span>
							<a href="/product/detail?product_code=${product.productCode}">
								<div class="product-image">
									<img src="${product.imageUrlFir}" alt="${product.imageDescription}">
								</div>
								<div class="product-info">
									<p class="brand">${product.productCategory}</p>
									<p class="name">${product.productName}</p>
									<p class="price">
										<c:if test="${product.originalPrice > product.price}">
											<span class="discount">${product.discountRate}%</span>
										</c:if>
										${product.price}원
									</p>
								</div>
							</a>
							<div class="live-info">
								<span>${product.salesCount}명이 구매</span>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</div>
		<div class="tab-panel" id="tab-outerwear">
			<div class="product-list-grid">
				<c:forEach var="product" items="${outerList}">
					<div class="product-card">
						<a href="/product/detail?product_code=${product.productCode}">
							<div class="product-image">
								<img src="${product.imageUrlFir}" alt="${product.imageDescription}" />
							</div>
							<div class="product-info">
								<p class="brand">${product.productCategory}</p>
								<p class="name">${product.productName}</p>
								<p class="price">${product.price}원</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="tab-panel" id="tab-top">
			<!-- 상의상품 컨텐츠 -->
			<p>상의 영역입니다.</p>
		</div>
		<div class="tab-panel" id="tab-bottom">
			<!-- 하의상품 컨텐츠 -->
			<p>하의 영역입니다.</p>
		</div>
		<div class="tab-panel" id="tab-shoes">
			<!-- 하의상품 컨텐츠 -->
			<p>신발 영역입니다.</p>
		</div>
		<div class="tab-panel" id="tab-accessories">
			<!-- 패션소품 컨텐츠 -->
			<p>패션소품 영역입니다.</p>
		</div>
	</section>
</main>