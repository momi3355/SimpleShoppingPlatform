<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="outer-filter-wrap">
	<div class="filter-wrap">
		<label for="search-gender-filter" class="filter-label"></label> <select
			id="search-gender-filter" class="outer-filter">
			<option value="all">성별</option>
			<option value="male">남성</option>
			<option value="female">여성</option>
		</select> <select id="search-price-filter" class="outer-filter">
			<option value="allprice">가격</option>
			<option value="cheap">낮은 가격순</option>
			<option value="expensive">높은 가격순</option>
		</select>
	</div>
</div>

<h2>검색결과</h2>
<c:if test="${empty resultList}">
	<p>검색 결과가 없습니다.</p>
</c:if>

<div class="product-list-grid" id="search-product-list">
	<c:forEach var="product" items="${resultList}">
		<div class="product-card" data-gender="${product.productGender}"
			data-price="${product.price}">
			<a
				href="${pageContext.request.contextPath}/productdetail.do?product_code=${product.productCode}">
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
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const genderFilter = document.getElementById("search-gender-filter");
    const priceFilter = document.getElementById("search-price-filter");
    const cardsWrap = document.getElementById("search-product-list");
    const cards = Array.from(cardsWrap.querySelectorAll(".product-card"));

    function applySearchFilter() {
      const gender = genderFilter.value;
      const priceSort = priceFilter.value;

      let filtered = [...cards];

     // 성별 필터
if (gender !== "all") {
  const engToKor = {
    male: "남성",
    female: "여성"
  };
  filtered = filtered.filter(card => card.dataset.gender === engToKor[gender]);
}

      // 가격 정렬
      filtered.sort((a, b) => {
        const priceA = parseInt(a.dataset.price);
        const priceB = parseInt(b.dataset.price);
        if (priceSort === "cheap") return priceA - priceB;
        if (priceSort === "expensive") return priceB - priceA;
        return 0;
      });

      // 카드 다시 출력
      cardsWrap.innerHTML = "";
      filtered.forEach(card => cardsWrap.appendChild(card));
    }

    genderFilter.addEventListener("change", applySearchFilter);
    priceFilter.addEventListener("change", applySearchFilter);
  });
</script>

