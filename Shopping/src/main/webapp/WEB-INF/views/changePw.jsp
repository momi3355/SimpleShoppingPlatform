<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/changePw.css">
<link rel="stylesheet" href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/changePw.js"></script>

<div class="changePw-title">비밀번호 변경</div>

<div class="changePw-container">
  
<!-- 현재 비밀번호 확인 -->
<div id="pw-check">
  <div class="form-group">
    <label for="currentPw">현재 비밀번호</label>
    <div class="input-wrapper">
      <input type="password" id="currentPw">
      <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('currentPw', this)"></i>
    </div>
  </div>
  <div id="checkPwError" class="error-message"></div>
  <button type="button" class="pw-btn" onclick="checkCurrentPw()">확인</button>
</div>

<!-- 새 비밀번호 입력 -->
<div id="pw-reset" style="display: none;">
  <div class="form-group">
    <label for="newPw">새 비밀번호</label>
    <div class="input-wrapper">
      <input type="password" id="newPw" placeholder="영문 + 숫자 8자 이상">
      <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('newPw', this)"></i>
    </div>
  </div>

  <div class="form-group">
    <label for="confirmPw">비밀번호 확인</label>
    <div class="input-wrapper">
      <input type="password" id="confirmPw">
      <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('confirmPw', this)"></i>
    </div>
  </div>

  <div id="newPwMessage" class="error-message"></div>
  <button type="button" class="pw-btn" id="changePwBtn" disabled onclick="submitNewPassword()">변경 완료</button>
</div>



</div>
    