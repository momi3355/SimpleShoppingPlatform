<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>


	<c:forEach var="review" items = "${reviewList }">
              <div class="review">
                <div class="review-header">
                  <div class="info">
                    <div class="nickname">${review.userName }</div>
                      <div class="writedate">${review.writeDate }</div>
                  </div>
                </div>
              <div class="rating">
              <span class="stars">★★★★★</span>
              <span class="score">${review.rating }</span>
              </div>
              <div class="content">${review.content }</div>
          </div>
          </c:forEach>
      
