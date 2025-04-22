<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/leave.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/leave.js"></script>

<div class="leave-title">탈퇴 시 유의사항</div>
<div class="leave-container">

  <div class="leave-warning">
    <ul>
      <li>아이디는 탈퇴 후 재사용 및 복구가 불가능합니다.</li><br>
      <li>회원 정보 및 서비스 이용 내역은 모두 삭제됩니다.</li><br>
      <li>작성하신 게시물은 삭제되지 않으며, 탈퇴 후 수정/삭제가 불가능합니다.</li><br>
      <li>탈퇴와 동시에 로그인 및 쇼핑 서비스 이용이 중단됩니다.</li><br><br><br>
    </ul>
  </div>

  <div class="leave-agree">
    <label><input type="checkbox" id="agreeChk"> 유의사항을 모두 확인하였으며, 이에 동의합니다.</label>
  </div>

  <div class="leave-buttons">
    <button type="button" onclick="location.href='myPage.do'">그만두기</button>
    <button type="button" id="agreeNextBtn" disabled>다음</button>
  </div>
</div>
