<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>product_details</title>
  <link rel="stylesheet" href="css/project.css">
  <link rel="stylesheet" href="css/product_details.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
</head>

<body>
  <div id="container">
    <main>
      <div id="all">
        <div id="left">
          <div class="left-inner">
            <div class="product-gallery">
              <div class="gallery-thumbnails">
                <img src="${product.imageUrlFir}" alt="썸네일1" data-index="0" class="active">
                <img src="${product.imageUrlSe}" alt="썸네일2" data-index="1">
                <img src="${product.imageUrlTh}" alt="썸네일3" data-index="2">
              </div>
              <div class="gallery-main">
                <!-- 왼쪽 화살표 -->
                <div class="arrow left mainthumbnail-arrow-left" aria-label="이전 이미지 보기">
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 40 40" fill="none">
                    <circle cx="20" cy="20" r="19.5" fill="white" stroke="#E0E0E0"></circle>
                    <path d="M22.5 27L15.7121 20.2119C15.595 20.0948 15.595 19.9048 15.7121 19.7877L22.5 13"
                      stroke="black" stroke-width="1.5"></path>
                  </svg>
                </div>
                <div class="gallery-image-container">
                  <img img src="${product.imageUrlFir}" alt="${product.imageDescription}" class="active">
                  <img src="${product.imageUrlSe}" alt="대표 이미지2">
                  <img src="${product.imageUrlTh}" alt="대표 이미지3">
                </div>
                <div class="arrow right mainthumbnail-arrow-right" aria-label="다음 이미지 보기">
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 40 40" fill="none">
                    <circle cx="20" cy="20" r="19.5" fill="white" stroke="#E0E0E0"></circle>
                    <path d="M17.5 13L24.2879 19.7881C24.405 19.9052 24.405 20.0952 24.2879 20.2123L17.5 27"
                      stroke="black" stroke-width="1.5"></path>
                  </svg>
                </div>
              </div>
            </div>
            <div class="product-tabs">
              <div class="tab-buttons">
                <button class="tab-btn active" data-tab="info">정보</button>
                <button class="tab-btn" data-tab="size">사이즈</button>
                <button class="tab-btn" data-tab="review">후기<span class="count"></span></button>
                <button class="tab-btn" data-tab="inquiry">문의<span class="count"></span></button>
              </div>
              <div class="tab-content active" id="info">
                <div class="product-info-section">
                  <div class="product-info-images collapsed" id="productInfoImages">
                    <c:forEach var="url" items="${product.infoImageUrls}">
                      <img src="${url}" alt="${product.productName}" />
                    </c:forEach>
                  </div>
                </div>
                <button id="toggleInfoBtn" class="toggle-info-btn">
                  <span>상품 정보 더보기</span>
                  <svg width="20" height="20" viewBox="0 0 20 20" fill="none">
                    <path d="M4 8L10 14L16 8" stroke="black" />
                  </svg>
                </button>
              </div>
            </div>
            <div class="tab-content" id="size">
              <c:choose>
                <c:when test="${not empty product and product.productCategory eq '신발'}">
                  <div class="shoe-size-info">
                    <h2 class="size-title">신발 사이즈 정보</h2>
                    <table class="shoe-size-table">
                      <thead>
                        <tr>
                          <th>한국(mm)</th>
                          <th>일본(cm)</th>
                          <th>미국(남)</th>
                          <th>미국(여)</th>
                          <th>영국</th>
                          <th>유럽</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>220</td><td>22.0</td><td>4</td><td>5</td><td>3</td><td>35</td>
                        </tr>
                        <tr><td>225</td><td>22.5</td><td>4.5</td><td>5.5</td><td>3.5</td><td>35.5</td></tr>
                        <tr><td>230</td><td>23.0</td><td>5</td><td>6</td><td>4</td><td>36</td></tr>
                        <tr><td>235</td><td>23.5</td><td>5.5</td><td>6.5</td><td>4.5</td><td>36.5</td></tr>
                        <tr><td>240</td><td>24.0</td><td>6</td><td>7</td><td>5</td><td>37</td></tr>
                        <tr><td>245</td><td>24.5</td><td>6.5</td><td>7.5</td><td>5.5</td><td>38</td></tr>
                        <tr><td>250</td><td>25.0</td><td>7</td><td>8</td><td>6</td><td>39</td></tr>
                        <tr><td>255</td><td>25.5</td><td>7.5</td><td>8.5</td><td>6.5</td><td>40</td></tr>
                        <tr><td>260</td><td>26.0</td><td>8</td><td>9</td><td>7</td><td>41</td></tr>
                        <tr><td>265</td><td>26.5</td><td>8.5</td><td>9.5</td><td>7.5</td><td>42</td></tr>
                        <tr><td>270</td><td>27.0</td><td>9</td><td>10</td><td>8</td><td>43</td></tr>
                      </tbody>
                    </table>
                    <ul class="size-note">
                      <li>브랜드마다 사이즈 기준이 조금씩 다를 수 있습니다.</li>
                      <li>사이즈 선택 시 참고용으로만 사용하세요.</li>
                    </ul>
                  </div>
                </c:when>
                <c:otherwise>
                  <div class="size-info">
                    <h2 class="title">사이즈 정보</h2>

                    <div class="body-input">
                      <div class="input-group">
                        <input type="text" name="height" placeholder="키" class="input">
                        <span class="unit">cm</span>
                      </div>
                      <div class="input-group">
                        <input type="text" name="weight" placeholder="몸무게" class="input">
                        <span class="unit">kg</span>
                      </div>
                    </div>

                    <div class="recommend">
                      <p class="recommend-title">사이즈 추천</p>
                      <div class="recommend-result">Free - 100% (1명 구매)</div>
                      <p class="recommend-desc">입력한 정보를 바탕으로 추천 사이즈를 알려드립니다.</p>
                    </div>

                    <div class="size-table-wrapper">
                      <table class="size-table">
                        <thead>
                          <tr>
                            <th>한국</th>
                            <th>미국</th>
                            <th>일본</th>
                            <th>영국</th>
                            <th>프랑스</th>
                            <th>이탈리아</th>
                            <th>유럽</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>44(85)</td>
                            <td>2</td>
                            <td>44</td>
                            <td>4-6</td>
                            <td>34</td>
                            <td>80</td>
                            <td>34</td>
                          </tr>
                          <tr>
                            <td>55(90)</td>
                            <td>4</td>
                            <td>55</td>
                            <td>8-10</td>
                            <td>36, 44</td>
                            <td>90</td>
                            <td>36</td>
                          </tr>
                          <tr>
                            <td>66(95)</td>
                            <td>6</td>
                            <td>66</td>
                            <td>10-12</td>
                            <td>38, 48</td>
                            <td>95</td>
                            <td>38</td>
                          </tr>
                          <tr>
                            <td>77(100)</td>
                            <td>8</td>
                            <td>77</td>
                            <td>16-18</td>
                            <td>40, 42</td>
                            <td>100</td>
                            <td>40</td>
                          </tr>
                          <tr>
                            <td>88(105)</td>
                            <td>10</td>
                            <td>88L</td>
                            <td>20-22</td>
                            <td>44, 46, 48</td>
                            <td>105</td>
                            <td>42</td>
                          </tr>
                          <tr>
                            <td>110</td>
                            <td>12</td>
                            <td>-</td>
                            <td>-</td>
                            <td>50, 52, 54</td>
                            <td>110</td>
                            <td>44</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>

                    <ul class="note">
                      <li>인터내셔널 사이즈 표입니다. 참고하시기 바랍니다.</li>
                      <li>브랜드별로 표기 방식이 다를 수 있습니다.</li>
                      <li>유아, 아동, GS 등 연령대별 구분이 있을 수 있습니다.</li>
                    </ul>
                  </div>
                </c:otherwise>
              </c:choose>
            </div>

            <div class="tab-content" id="review">
              <p>후기 내용이 들어갑니다.</p>
            </div>
            <div class="tab-content" id="inquiry">
              <p>문의 내용이 들어갑니다.</p>
            </div>
          </div>
        </div>
        <div id="right">
          <div class="product-info-right">
            <!-- 브랜드 로고 & 이름 -->
            <div class="brand-info">
              <p class="brand">
                <c:if test="${not empty product.productCategory}">${product.productCategory}</c:if>
              </p>
            </div>
            <!-- 카테고리 네비게이션 -->
            <div class="category-nav">
              <a href="#">${product.productCategory}</a>
            </div>
            <!-- 상품명 -->
            <h1 class="product-title">${product.productName}</h1>
            <!-- 후기 -->
            <div class="review-box">
              <span class="rating">★ 5</span>
              <span class="review-count">후기 2개</span>
            </div>
            <!-- 가격 -->
            <div class="price">
              <p class="price">
                <c:if test="${product.originalPrice > product.price}">
                  <span class="discount">${product.discountRate}%</span>
                </c:if>
                ${product.price}원
              </p>
            </div>
            <!-- 사이즈 옵션 -->
            <div class="option-box">
              <select id="size-select" name="productOption">
                <option value="" disabled selected>사이즈 선택</option>
                <c:forEach var="opt" items="${product.productOption.split(',')}">
                  <option value="${fn:trim(opt)}">${fn:trim(opt)}</option>
                </c:forEach>
              </select>
            </div>
            <!-- 버튼 -->
            <div class="action-buttons">
              <button class="btn-cart" onclick="addCart(${product.productCode})">장바구니</button>
              <button class="btn-buy" onclick="buyProduct(${product.productCode})">구매하기</button>
            </div>
            <!-- 카드 혜택 -->
            <div class="payment-benefits">
              <div class="benefits-header">
                <span class="title">결제혜택</span>
              </div>
              <ul class="benefits-list">
                <li>
                  <img src="https://image.msscdn.net/musinsaUI/store/order/finance/28x28/logo-finance-hyundai.png"
                    alt="현대카드">
                  <p><strong>왜안사페이 × 무신사현대카드</strong> 1만 1천원 이상 결제 시 1만원 할인 <span class="tag">첫구매전용</span></p>
                </li>
                <li>
                  <img src="https://image.msscdn.net/musinsaUI/store/order/finance/28x28/logo-finance-kakaopay.png"
                    alt="카카오페이">
                  <p><strong>카카오페이 × 페이머니</strong> 8만원 이상 결제 시 1만원 할인</p>
                </li>
                <li>
                  <img src="https://image.msscdn.net/musinsaUI/store/order/finance/28x28/logo-finance-toss.png"
                    alt="토스페이">
                  <p><strong>토스페이 × 계좌</strong> 10만원 이상 결제 시 1만원 할인</p>
                </li>
              </ul>
            </div>
            <!-- 배송 정보 -->
            <div class="delivery-info">
              <div class="info">
                <p>왜안사 회원은 전 품목 무료배송</p>
                <p>(일부 상품 및 도서 산간 지역 제외)</p>
              </div>
              <div class="info">
                <p>04.19 (토) 도착 예정 · 도착 확률 99%</p>
                <p>결제 3일 이내 출고 · CJ대한통운</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
</body>
<script>
const productCode = "${param.product_code}"
</script>
<script src="js/product_details.js"></script>
<script src="js/productBtn.js"></script>
</html>