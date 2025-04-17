<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- login.jsp -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

	<div class="login-title">로그인/회원가입</div>

<div class="login-container">
	<form action="login.do" method="post">
		<c:if test="${not empty message}">
  		  <div style="color: green; font-size: 14px; margin-bottom: 10px;">
     		   ${message}
   		 </div>
		</c:if>
		<!-- 아이디 입력 창 위에 에러 메시지 표시 -->
		<c:if test="${message eq '아이디 또는 비밀번호를 확인하세요.'}">
			<p style="color: red; font-size: 13px; margin: 0 0 5px 0;">
				${message}</p>
		</c:if>

		<div class="form-group">
			<label for="user_id">아이디</label> <input type="text" id="id" name="id"
				required>
		</div>

		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password" id="pw"
				name="pw" required>
		</div>

		<button type="submit" class="login-btn">로그인</button>
		<div class="form-check">
			<input type="checkbox" id="auto_login" name="auto_login"> <label
				for="auto_login">아이디저장</label>
		</div>
	</form>

	<div class="login-links">
		<a href="/find-id">아이디 찾기</a> | <a href="/find-password">비밀번호 찾기</a> |
		<a href="signUpForm.do">회원가입</a>
	</div>

	<div class="social-login">
		<button class="kakao">카카오톡 로그인</button>
	</div>

</div>