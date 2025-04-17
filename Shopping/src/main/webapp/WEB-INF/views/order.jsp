<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/order.css">
<script>
  let json = JSON.parse(`${datas}`);
</script>
<div class="order-container">
  <h2>ORDER / PAYMENT</h2>
  <hr>
  <div class="step-container">
    <div class="step-box"><span>장바구니</span></div>
    <span>▶</span>
    <div class="step-box" style="background: rgb(26, 27, 31); color: #fff"><span>주문서작성</span></div>
    <span>▶</span>
    <div class="step-box"><span>주문완료</span></div>
  </div>
  <hr>
  <p class="paymet-title"><span>Payment</span> 주문서작성</p>
  <div class="paymet-container">
    <div class="order-form">
      <!-- 배송지 정보 -->
      <section class="address">
        <h2>배송지 정보</h2>
        <label>
          배송지 선택
          <select name="saved-addresses">

          </select>
        </label>

        <label>받는 사람 <input type="text" name="receiver-name" required /></label>
        <label>연락처 <input type="tel" name="receiver-phone" required /></label>
        <label>우편번호 <input type="text" name="zipcode" /></label>
        <label>주소 <input type="text" name="address" placeholder="도로명 주소" required /></label>
        <label>배송 메시지 <input type="text" name="message" placeholder="문 앞에 놓아주세요 등" /></label>
        <button type="button" class="add-address-btn">배송지 추가하기</button>
      </section>

      <!-- 주문 상품 -->
      <section class="order">

      </section>
    </div>

    <!-- 사이드 결제 영역 -->
    <div class="payment-box">
      <h2>결제 금액</h2>
      <div class="total-price">
        <p>총 상품 금액: <strong>39,800원</strong></p>
        <p>배송비: <strong>무료</strong></p>
        <hr />
        <p>최종 결제 금액: <strong>39,800원</strong></p>
      </div>
      <button class="pay-btn">결제하기</button>
    </div>
  </div>
</div>
<script src="js/order.js"></script>