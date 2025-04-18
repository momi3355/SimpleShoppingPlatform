<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>검색 결과</h2>

<c:if test="${empty resultList}">
	<p>검색 결과가 없습니다.</p>
</c:if>

<div class="product-list-grid">
	<c:forEach var="product" items="${resultList}">
		<div class="product-card">
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