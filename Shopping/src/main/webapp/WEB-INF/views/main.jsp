<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main id="main-container">
	<!--  검색창  -->
	<div id="container">
		<div id="searchOverlay" class="search-overlay">
			<div class="overlay-background"></div>
			<div class="overlay-content">
				<header class="search-header">
					<div class="search-input-box">
						<input type="text" id="searchKeyword" placeholder="검색어를 입력하세요" />
						<button id="confirmSearchBtn" class="search-button" aria-label="검색">
							<svg width="100%" height="100%" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path
									d="M12 12L16.5 16.5M13.5 8.5C13.5 11.2614 11.2614 13.5 8.5 13.5C5.73858 13.5 3.5 11.2614 3.5 8.5C3.5 5.73858 5.73858 3.5 8.5 3.5C11.2614 3.5 13.5 5.73858 13.5 8.5Z"
									stroke="gray" stroke-width="1.4" />
							</svg>
						</button>
						<button id="closeButton" class="close-button" aria-label="닫기">
							<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 20" fill="none">
								<path d="M5 5L15 15M5 15L15 5" stroke-width="1.4" stroke="gray" stroke-miterlimit="10" />
							</svg>
						</button>
					</div>
				</header>

				<div class="search-content">
					<!-- 🔍 최근 검색어 -->
					<section class="recent-searches">
						<header class="header">
							<span class="title">최근 검색어</span>
							<button class="clear-all" id="deleteAllRecent">모두삭제</button>
						</header>
						<ul id="recentList"></ul>
					</section>

					<!-- 🔥 인기 검색어 -->
					<article class="popular-keywords">
						<header class="popular-header">
							<span class="title">인기 검색어</span>
							<div class="meta-info">
								<svg class="icon-refresh" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
									<path
										d="M11.5 2L14.2879 4.78787C14.405 4.90503 14.405 5.09497 14.2879 5.21213L11.5 8M14.002 5H10C6.688 5 4 7.688 4 11C4 14.312 6.688 17 10 17C13.312 17 16 14.312 16 11V9.5"
										stroke="black" stroke-width="1.4" />
								</svg>
							</div>
						</header>
						<ol class="keyword-list">
							<li>
								<button>
									<span class="rank-number">1</span>
									<span class="keyword">아우터</span>
									<span class="rank-icon up"></span>
								</button>
							</li>
						</ol>
					</article>
				</div>
			</div>
		</div>
	</div>
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
							<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
							<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
			<div class="filter-wrap">
				<label for="outerwear-filter" class="filter-label"></label>
				<select id="outerwear-gender-filter" class="outer-filter">
					<option value="all">성별</option>
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
				<select id="outerwear-price-filter" class="outer-filter">
					<option value="allprice">가격</option>
					<option value="cheap">낮은 가격순</option>
					<option value="expensive">높은 가격순</option>
				</select>
			</div>
			<div class="product-list-grid">
				<c:forEach var="product" items="${outerList}">
					<div class="product-card" data-gender="${product.productGender}" data-price="${product.price}">
						<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
		</div>
		<div class="tab-panel" id="tab-top">
			<div class="filter-wrap">
				<label for="top-filter" class="filter-label"></label>
				<select id="top-gender-filter" class="outer-filter">
					<option value="all">성별</option>
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
				<select id="top-price-filter" class="outer-filter">
					<option value="allprice">가격</option>
					<option value="cheap">낮은 가격순</option>
					<option value="expensive">높은 가격순</option>
				</select>
			</div>
			<div class="product-list-grid">
				<c:forEach var="product" items="${topList}">
					<div class="product-card" data-gender="${product.productGender}" data-price="${product.price}">
						<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
		</div>
		<div class="tab-panel" id="tab-bottom">
			<div class="filter-wrap">
				<label for="bottom-filter" class="filter-label"></label>
				<select id="bottom-gender-filter" class="outer-filter">
					<option value="all">성별</option>
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
				<select id="bottom-price-filter" class="outer-filter">
					<option value="allprice">가격</option>
					<option value="cheap">낮은 가격순</option>
					<option value="expensive">높은 가격순</option>
				</select>
			</div>
			<div class="product-list-grid">
				<c:forEach var="product" items="${bottomList}">
					<div class="product-card" data-gender="${product.productGender}" data-price="${product.price}">
						<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
		</div>
		<div class="tab-panel" id="tab-shoes">
			<div class="filter-wrap">
				<label for="shoes-filter" class="filter-label"></label>
				<select id="shoes-gender-filter" class="outer-filter">
					<option value="all">성별</option>
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
				<select id="shoes-price-filter" class="outer-filter">
					<option value="allprice">가격</option>
					<option value="cheap">낮은 가격순</option>
					<option value="expensive">높은 가격순</option>
				</select>
			</div>
			<div class="product-list-grid">
				<c:forEach var="product" items="${shoesList}">
					<div class="product-card" data-gender="${product.productGender}" data-price="${product.price}">
						<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">ㄴ
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
		</div>
		<div class="tab-panel" id="tab-accessories">
			<div class="filter-wrap">
				<label for="accessories-filter" class="filter-label"></label>
				<select id="accessories-gender-filter" class="outer-filter">
					<option value="all">성별</option>
					<option value="male">남성</option>
					<option value="female">여성</option>
				</select>
				<select id="accessories-price-filter" class="outer-filter">
					<option value="allprice">가격</option>
					<option value="cheap">낮은 가격순</option>
					<option value="expensive">높은 가격순</option>
				</select>
			</div>

			<div class="product-list-grid">
				<c:forEach var="product" items="${accessoriesList}">
					<div class="product-card" data-gender="${product.productGender}" data-price="${product.price}">
						<a href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
		</div>
	</section>
</main>