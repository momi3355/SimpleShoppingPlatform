<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>리뷰 리스트</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #fafafa;
      margin: 20px;
    }
    .review-list {
      max-width: 600px;
      margin: 0 auto;
    }
    .review {
      background: #fff;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 16px;
      margin-bottom: 20px;
    }
    .review-header {
      display: flex;
      align-items: center;
      margin-bottom: 10px;
    }
    .avatar {
      width: 36px;
      height: 36px;
      border-radius: 50%;
      background-color: #ccc;
      margin-right: 10px;
    }
    .user-info {
      font-size: 14px;
    }
    .user-info strong {
      display: block;
      font-weight: bold;
    }
    .stars {
      color: gold;
      font-size: 16px;
      margin: 4px 0;
    }
    .meta {
      font-size: 13px;
      color: #666;
      margin-bottom: 8px;
    }
    .content {
      font-size: 14px;
      line-height: 1.6;
    }
    .actions {
      margin-top: 12px;
      font-size: 13px;
      color: #888;
      display: flex;
      gap: 12px;
    }
    .actions span {
      cursor: pointer;
    }
  </style>
</head>
<body>
  <div class="review-list">

    <!-- 리뷰 아이템 -->
    <div class="review">
      <div class="review-header">
        <div class="avatar"></div>
        <div class="user-info">
          <strong>영영00000</strong>
          <div>24.09.04</div>
        </div>
      </div>
      <div class="stars">★★★★★</div>
      <div class="meta">남성 · 170cm · 78kg · XL 구매</div>
      <div class="content">
        생각보다 더 예쁩니다! 사이즈표 참고해서 산건 했지만 조금 크네요ㅎㅎ..<br>
        그래도 안에 셔츠나 티를 입고 입을 수 있는 핏이 나와서 좋습니다 :)
      </div>
      <div class="actions">
        <span>💬 0</span>
        <span>♡ 0</span>
      </div>
    </div>

    <!-- 여기 밑으로 리뷰 반복해서 추가 -->

  </div>
</body>
</html>

