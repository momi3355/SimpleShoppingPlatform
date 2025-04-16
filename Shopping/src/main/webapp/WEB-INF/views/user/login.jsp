<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="css/loginform.css">
  <div class="login-container">
    <h2>로그인</h2>
    <form action="/login" method="POST">
      <div class="form-group">
        <label for="user_id">아이디</label>
        <input type="text" id="user_id" name="user_id" required>
      </div>
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-check">
        <input type="checkbox" id="auto_login" name="auto_login">
        <label for="auto_login">자동 로그인</label>
      </div>
      <button type="submit" class="login-btn">로그인</button>
    </form>
    <div class="login-links">
      <a href="/find-id">아이디 찾기</a> |
      <a href="/find-password">비밀번호 찾기</a> |
      <a href="/signup">회원가입</a>
    </div>
    <div class="social-login">
      <button class="kakao">카카오톡으로 로그인</button>
    </div>
  </div>