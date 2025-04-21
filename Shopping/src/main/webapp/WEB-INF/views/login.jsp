<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- login.jsp -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script> const contextPath = "${pageContext.request.contextPath}";</script>
<script src="${pageContext.request.contextPath}/js/kakao-config.js"></script>
<script src="${pageContext.request.contextPath}/js/kakaoLogin.js"></script>


<div class="login-title">로그인/회원가입</div>

<div class="login-container">
  <form action="login.do" method="post" id="loginForm">


    <div class="form-group">
      <div class="label-row">
        <label for="id">아이디</label>
        <span id="idError" class="error-message"></span>
      </div>
      <input type="text" id="id" name="id">
    </div>

    <!-- 비밀번호 입력 -->
<div class="form-group">
  <div class="label-row">
    <label for="pw">비밀번호</label>
    <span id="pwError" class="error-message"></span>
  </div>
  <div class="input-wrapper">
    <input type="password" id="pw" name="pw">
    <i class="fi fi-rr-eye toggle-eye" onclick="togglePassword('pw', this)"></i>
  </div>
</div>

<!-- 에러 메시지 영역 -->
    <c:if test="${not empty message}">
      <div class="login-error">${message}</div>
    </c:if>

    <button type="submit" class="login-btn">로그인</button>

  </form>

  <div class="login-links">
    <a href="#" onclick="openFindModal('id'); return false;">아이디 찾기</a> 
    | <a href="#" onclick="openFindModal('pw'); return false;">비밀번호 찾기</a> 
    | <span class="tooltip-wrapper">
      <a href="signUpForm.do" class="signup-link">회원가입</a>
      <span class="tooltip-text">가입하고 무료배송 혜택을 받아보세요!</span>
    </span>
  </div>

  <!-- 카카오 로그인 버튼 -->
  <div class="social-login">
	<button type="button" onclick="kakaoLogin()" style="border: none; background: none; padding: 0;">
  	  <img src="${pageContext.request.contextPath}/img/kakao_login_large_wide.png" alt="카카오 로그인" style="width: 307px; height: 46px;" >
	</button>
  </div>

</div>

<!-- 팝업 -->
<div id="findModal" class="modal-overlay" style="display: none;">
  <div class="modal-content">
    <span class="close" onclick="closeFindModal()">&times;</span>
    
    <div class="tab-menu">
      <a href="#" class="tab active" onclick="showTab('id'); return false;">아이디 찾기</a>
      <a href="#" class="tab" onclick="showTab('pw'); return false;">비밀번호 찾기</a>
    </div>
	<!-- 아이디찾기 -->
   <div class="tab-content" id="tab-id">
      <div class="form-group">
        <label>이름</label>
        <input type="text" id="findName">
      </div>
      <div class="form-group">
        <label>전화번호</label>
        <input type="text" id="findPhone" maxlength="11">
      </div>
      <div class="form-group">
        <label>이메일</label>
        <input type="text" id="findEmail">
      </div>
      <button type="button" class="popup-btn" onclick="submitFindId()">아이디 찾기</button>
      <div id="findIdResult" class="result-message"></div>
    </div>
	<!-- 비번찾기 -->
    <div class="tab-content" id="tab-pw" style="display: none;">
      <div class="form-group">
        <label>아이디</label>
        <input type="text" id="pwFindId">
      </div>
      <div class="form-group">
        <label>이름</label>
        <input type="text" id="pwFindName">
      </div>
      <div class="form-group">
        <label>전화번호</label>
        <input type="text" id="pwFindPhone" maxlength="11">
      </div>
      <div class="form-group">
        <label>이메일</label>
        <input type="text" id="pwFindEmail">
      </div>
      <button type="button" class="popup-btn" onclick="submitFindPw()">비밀번호 찾기</button>
      <div id="findPwResult" class="result-message"></div>
    </div>
  </div>
</div>