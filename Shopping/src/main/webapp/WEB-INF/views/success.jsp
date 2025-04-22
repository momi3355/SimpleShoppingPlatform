<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  .order-container {
      max-width: 800px;
      margin: 20px auto;
      margin-top: 80px;
      padding: 30px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  h1 {
      color: #28a745;
      text-align: center;
      margin-bottom: 30px;
  }

  .order-info {
      margin-bottom: 20px;
      padding: 15px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #f9f9f9;
  }

  .order-info p {
      margin: 5px 0;
  }

  .order-details {
      margin-bottom: 20px;
  }

  .order-details table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 10px;
  }

  .order-details th, .order-details td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
  }

  .order-details th {
      background-color: #f2f2f2;
  }

  .thank-you {
      text-align: center;
      font-size: 1.2em;
      color: #555;
      margin-top: 30px;
  }

  .back-to-shop {
      text-align: center;
      margin-top: 20px;
  }

  .back-to-shop a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #007bff;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
  }
</style>
<script>
  let json = JSON.parse(`${datas}`);
</script>
<div class="order-container">
  <h1>주문이 완료되었습니다!</h1>
  <div class="order-info">

  </div>
  
  <div class="order-details">
    <h2>주문 상세 정보</h2>
    <table>
      <thead>
        <tr>
          <th>상품명</th>
          <th>수량</th>
          <th>가격</th>
        </tr>
      </thead>
      <tbody>
        
      </tbody>
    </table>
  </div>

  <div class="thank-you">
    <p>저희 쇼핑몰을 이용해주셔서 감사합니다.</p>
    <p>빠른 시일 내에 배송해 드리겠습니다.</p>
  </div>

  <div class="back-to-shop">
    <a href="main.do">쇼핑 계속하기</a>
  </div>

</div>
<script src="js/success.js"></script>