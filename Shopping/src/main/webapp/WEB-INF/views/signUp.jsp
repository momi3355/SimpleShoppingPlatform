<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/signup.js"></script>

<div class="signup-title">회원가입</div>
<div class="signup-container">
  <form action="signUp.do" method="post" id="signupForm">

    <!-- 아이디 -->
    <div class="form-group">
      <div class="label-row">
        <label for="userId">아이디</label>
        <div id="idMessage" class="message"></div>
      </div>
      <input type="text" name="userId" id="userId" placeholder="영문, 숫자 5-12자">
    </div>

    <!-- 비밀번호 -->
    <div class="form-group">
      <div class="label-row">
        <label for="password">비밀번호</label>
        <div id="passwordMessage" class="message"></div>
      </div>
      <input type="password" name="password" id="password" placeholder="영문, 숫자 조합 최소 8자">
    </div>

    <!-- 비밀번호 확인 -->
    <div class="form-group">
      <div class="label-row">
        <label for="passwordCheck">비밀번호 확인</label>
        <div id="pwMessage" class="message"></div>
      </div>
      <input type="password" id="passwordCheck">
    </div>

    <!-- 이름 -->
    <div class="form-group">
      <div class="label-row">
        <label for="userName">이름</label>
        <div id="nameMessage" class="message"></div>
      </div>
      <input type="text" name="userName" id="userName">
    </div>

    <!-- 전화번호 -->
    <div class="form-group">
      <div class="label-row">
        <label for="phone">휴대폰 번호</label>
        <div id="phoneMessage" class="message"></div>
      </div>
      <input type="text" name="phone" id="phone" maxlength="11">
    </div>

    <!-- 이메일 -->
    <div class="form-group">
      <div class="label-row">
        <label for="email">이메일</label>
        <div id="emailMessage" class="message"></div>
      </div>
      <input type="text" name="email" id="email" placeholder="이메일을 입력해주세요">
    </div>

    <div class="sub-text">아이디 또는 비밀번호 분실 시 본인 확인용으로 사용됩니다.</div>
    <button type="submit" class="signup-btn">회원가입</button>
  </form>
</div>
