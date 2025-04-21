<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/changePw.css">
<link rel="stylesheet" href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/resetPw.js"></script>

<div class="changePw-title">비밀번호 재설정</div>

<div class="changePw-container">
  <form action="changePw.do" method="post" id="resetPwForm">
    <input type="hidden" name="userCode" value="${param.userCode}">

    <!-- 새 비밀번호 -->
    <div class="form-group">
      <label for="newPw">새 비밀번호</label>
      <div class="input-wrapper">
        <input type="password" id="newPw" name="newPw" placeholder="영문 + 숫자 8자 이상">
        <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('newPw', this)"></i>
      </div>
    </div>

    <!-- 비밀번호 확인 -->
    <div class="form-group">
      <label for="confirmPw">비밀번호 확인</label>
      <div class="input-wrapper">
        <input type="password" id="confirmPw">
        <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('confirmPw', this)"></i>
      </div>
    </div>

    <div id="resetPwMessage" class="error-message"></div>
    <button type="submit" class="pw-btn" id="submitBtn" disabled>변경 완료</button>
  </form>
</div>
