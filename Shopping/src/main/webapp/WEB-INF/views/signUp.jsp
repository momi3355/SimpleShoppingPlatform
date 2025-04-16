<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">

<div class="signup-title">회원가입</div>

<div class="signup-container">
  <form action="signup.do" method="post">

    <!-- 아이디 -->
    <c:if test="${not empty idMessage}">
      <p class="message ${idMessageClass}">${idMessage}</p>
    </c:if>
    <div class="form-group">
      <label for="userId">아이디</label>
      <input type="text" id="userId" name="userId" required>
    </div>

    <!-- 비밀번호 -->
    <c:if test="${not empty pwMessage}">
      <p class="message ${pwMessageClass}">${pwMessage}</p>
    </c:if>
    <div class="form-group">
      <label for="password">비밀번호</label>
      <input type="password" id="password" name="password" required>
    </div>

    <!-- 비밀번호 확인 -->
    <div class="form-group">
      <label for="passwordCheck">비밀번호 확인</label>
      <input type="password" id="passwordCheck" name="passwordCheck" required>
    </div>

    <!-- 이름 -->
    <div class="form-group">
      <label for="userName">이름</label>
      <input type="text" id="userName" name="userName" required>
    </div>

    <!-- 휴대폰번호 -->
    <div class="form-group">
      <label for="phone">휴대폰 번호</label>
      <input type="text" id="phone" name="phone" pattern="\\d{10,11}" required 
             title="10자리 또는 11자리 숫자만 입력 가능합니다.">
    </div>

    <!-- 이메일 -->
    <c:if test="${not empty emailMessage}">
      <p class="message ${emailMessageClass}">${emailMessage}</p>
    </c:if>
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" id="email" name="email" required>
    </div>

    <!-- 설명 메시지 -->
    <p class="sub-text">아이디 또는 비밀번호 분실 시 본인인증 정보로 활용됩니다.</p>

    <!-- 제출 버튼 -->
    <button type="submit" class="signup-btn">가입하기</button>

  </form>
</div>