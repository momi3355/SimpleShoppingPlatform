<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <div class="pwchange-container">
  <h2>비밀번호 변경</h2>

  <!-- 비밀번호 확인 -->
  <div id="pw-check">
    <input type="password" id="currentPassword" placeholder="현재 비밀번호">
    <div class="message" id="checkMessage"></div>
    <button id="checkBtn">확인</button>
  </div>

  <!-- 새 비밀번호 입력 -->
  <div id="pw-reset" style="display: none;">
    <input type="password" id="newPassword" placeholder="새 비밀번호">
    <input type="password" id="confirmPassword" placeholder="새 비밀번호 확인">
    <div class="message" id="matchMessage"></div>
    <button id="completeBtn" disabled>완료</button>
  </div>
</div>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/changePw.css">
<script src="${pageContext.request.contextPath}/js/changePw.js"></script>

