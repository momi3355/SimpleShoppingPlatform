<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.stars {
	font-size: 16px;
	color: gold;
	letter-spacing: -1px;
}
</style>
<p
	style="background-color: #EBEBEBE6; padding: 14px 18px; color: #495057; font-size: 16px;">
	상품과 관련없는 후기는 예고없이 삭제될 수 있습니다.</p>
<c:forEach var="review" items="${reviewList}">
	<div class="review" data-review-no="${review.reviewCode}">
		<div class="review-header">
			<div class="info" style="display: flex; align-items: center;">
				<!-- 닉네임 -->
				<div style="font-weight: bolder;" class="nickname">${review.userName}</div>

				<!-- 작성일자 -->
				<div class="writedate" style="margin-left: 10px;">${review.writeDate}</div>
			</div>
		</div>
	</div>
	<div class="rating">
		<span class="stars"> <c:forEach begin="1" end="5" var="i">
				<c:choose>
					<c:when test="${i <= review.rating}">★</c:when>
					<c:otherwise>☆</c:otherwise>
				</c:choose>
			</c:forEach>
		</span> <span class="score">${review.rating}</span>
	</div>
	<div style="margin-top: 5px; margin-bottom: 10px;" class="content">${review.content}</div>

	<!-- 본인 리뷰일 경우에만 삭제 버튼 표시 -->
	<c:if test="${review.userCode == sessionScope.userCode}">
		<button type="button" class="delete-btn"
			data-review-no="${review.reviewCode}"
			data-user-code="${sessionScope.userCode}" onclick="removefunc(this)"
			style="background-color: black; color: white; border-radius: 10px; border: none; padding: 6px 12px; cursor: pointer;">
			삭제</button>

		<hr
			style="border: solid 0.2px #e9ecef; margin-top: 20px; margin-bottom: 20px">
	</c:if>
</c:forEach>

<script>
	
</script>
