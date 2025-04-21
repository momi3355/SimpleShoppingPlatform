<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/leave.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/leave.js"></script>


<div class="leave-title">
	${loginVO.userName}님, 왜않사를 떠나시려는 이유를 알려주세요
</div>
<div class="leave-container">

	<select id="reasonSelect">
		<option value="">선택해주세요</option>
		<option>구매할 만한 상품이 없어요.</option>
		<option>상품 가격이 비싸요.</option>
		<option>배송이 느려요.</option>
		<option>교환 / 반품 / 환불이 불편해요.</option>
		<option>회원 / 쇼핑 혜택이 부족해요.</option>
		<option>쇼핑 기능이 어려워요.</option>
		<option>광고 / 알림이 너무 많아요.</option>
		<option>개인정보 보호가 우려돼요.</option>
		<option>다른 계정이 있어요.</option>
		<option>기타</option>
	</select>

	<div class="leave-buttons">
		<button type="button" onclick="location.href='mypage.do'">그만두기</button>
		<button type="button" id="reasonNextBtn" disabled>다음</button>
	</div>
</div>
