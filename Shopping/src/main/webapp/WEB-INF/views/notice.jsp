<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/notice.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>const contextPath = "${pageContext.request.contextPath}";</script>
<script src="${pageContext.request.contextPath}/js/notice.js"></script>

<div class="notice-header">
  <button onclick="history.back()" class="back-btn">◀</button>
  <span class="notice-title">공지사항</span>
  <a href="${pageContext.request.contextPath}/myPage.do" class="home-btn" title="홈으로">
  <img src="https://img.icons8.com/?size=100&id=i6fZC6wuprSu&format=png&color=000000"
       alt="홈" class="home-icon">
</a>
</div>

<div class="notice-wrapper">
  <ul class="notice-list" id="notice_list">
    <c:forEach var="notice" items="${noticeList}">
      <li id="no_${notice.boardCode}" class="notice-item">
        <div class="notice-summary">
          <a href="#no_${notice.boardCode}" class="notice-title-link" onclick="toggleNotice(${notice.boardCode}, this);">
            <span class="notice-title-text"><b>${notice.boardTitle}</b></span><br>
            <span class="notice-date">${notice.boardDate}</span>
          </a>
          <a href="#no_${notice.boardCode}" class="notice-toggle-btn" onclick="toggleNotice(${notice.boardCode}, this);">▼</a>
        </div>
        <div class="notice-detail" style="display: none;"></div>
      </li>
    </c:forEach>
  </ul>
</div>
