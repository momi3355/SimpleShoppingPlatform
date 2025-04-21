<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myInfo.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/myInfo.js"></script>

<!-- 제목 -->
<div class="myInfo-title">내정보 변경</div>

<div class="myInfo-container">
  <form id="myInfoForm">
    
    <div class="form-group">
      <label for="userId">아이디</label>
      <input type="text" id="userId" name="userId" value="${user.userId}" readonly>
    </div>

    <div class="form-group">
      <label for="userName">이름</label>
      <input type="text" id="userName" name="userName" value="${user.userName}" readonly>
    </div>

    <div class="form-group">
      <label for="password">현재 비밀번호<span class="message" id="pwMessage"></span></label>
      <input type="password" id="password" name="password">
      
    </div>

    <div class="form-group">
      <label for="email">이메일<span class="message" id="emailMessage"></span></label>
      <input type="text" id="email" name="email" value="${user.email}">
      
    </div>

    <div class="form-group">
      <label for="phone">전화번호<span class="message" id="phoneMessage"></span></label>
      <input type="text" id="phone" name="phone" value="${user.phone}">
      
    </div>

    <button type="button" id="saveBtn" disabled>수정 완료</button>
  </form>
</div>
