<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/address.css">
<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script>
  let json = JSON.parse(`${datas}`);
</script>
<div class="address-container">
    <div class="order-form">
        <form action="addAddress.do" method="POST">
            <section class="address">
                <h2>배송지 정보 수정</h2>
                <label>
                    배송지 선택
                    <select name="saved-addresses">
                        
                    </select>
                </label>
                
                <label>받는 사람 <input type="text" name="name" required /></label>
                <label>연락처 <input type="tel" name="phone" required /></label>
                <label>우편번호 <input type="text" name="zipcode" /></label>
                <label>주소 <input type="text" name="address" placeholder="도로명 주소" required /></label>
                <label>배송 메시지 <input type="text" name="message" placeholder="문 앞에 놓아주세요 등" /></label>
                <button type="submit" id="add-btn" class="address-btn">배송지 추가하기</button>
                <button type="button" id="remove-btn" class="address-btn">배송지 삭제하기</button>
            </section>
            
            <!-- 주문 상품 -->
            <section class="order">
                
            </section>
        </form>
    </div>
</div>
<script src="js/address.js"></script>