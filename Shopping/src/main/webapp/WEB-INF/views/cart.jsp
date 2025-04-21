<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/cart.css">
<script>
  let userCode = `${user_code}`;
</script>
<script src="js/cart.js"></script>
<div class="cart-container">
  <h2>ORDER / PAYMENT</h2>
  <hr>
  <div class="step-container">
    <div class="step-box" style="background: rgb(26, 27, 31); color: #fff"><span>장바구니</span></div>
    <span>▶</span>
    <div class="step-box"><span>주문서작성</span></div>
    <span>▶</span>
    <div class="step-box"><span>주문완료</span></div>
  </div>
  <hr>
  <div class="table-container">
    <p class="cart-title"><span>My cart</span> 장바구니</p>
    <form action="orderForm.do" method="post">
      <input type="hidden" id="user_code" name="user_code"  value="${user_code}">
      <table class="cart-table">
        <thead>
          <tr>
            <th class="cart-code">번호</th>
            <th class="cart-name">상품명</th>
            <th class="cart-option">옵션</th>
            <th class="cart-price">판매가</th>
            <th class="cart-quantity">수량</th>
            <th class="cart-total-price">주문금액</th>
            <th class="cart-btn">주문관리</th>
          </tr>
        </thead>
        <tbody class="cart-target">
          
        </tbody>
        <tfoot>
          
        </tfoot>
      </table>
      <div class="btn-container">
        <input type="button" class="btn-remove" value="전체 삭제하기">
        <input type="submit" class="btn-submit" value="결제하기">
      </div>
    </form>
  </div>
</div>
  