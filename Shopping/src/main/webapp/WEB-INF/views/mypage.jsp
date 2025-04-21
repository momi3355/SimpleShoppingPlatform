<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage.css">

<div class="mypage-container">

	<!-- 헤더 영역 -->
	<div class="mypage-header">
		<div class="header-top">
			<h2>마이</h2>
			<a href="main.do" class="home-btn" title="홈으로"> <img
				src="https://img.icons8.com/?size=100&id=i6fZC6wuprSu&format=png&color=000000"
				alt="홈" class="home-icon">
			</a>
		</div>
		<div class="user-info">
			어서오세요, <strong>${userName}</strong>님
		</div>
	</div>

	<!-- 메뉴 영역 -->
	<ul class="mypage-menu">
		<li><a href="orderList.do">주문 내역 <span class="arrow">›</span></a></li>
		<li><a href="cart.do">장바구니 <span class="arrow">›</span></a></li>
		<li><a href="myInfo.do">내정보 변경 <span class="arrow">›</span></a></li>
		<li><a href="passwordForm.do">비밀번호 변경 <span class="arrow">›</span></a></li>
		<li><a href="address.do">배송지 관리 <span class="arrow">›</span></a></li>
		<li><a href="leaveReason.do">회원 탈퇴 <span class="arrow">›</span></a></li>
		<li><a href="support.do">고객센터 <span class="arrow">›</span></a></li>
		<li><a href="notice.do">공지사항 <span class="arrow">›</span></a></li>
	</ul>
</div>
<div class="logout"><a href="logout.do">로그아웃</a></div>

