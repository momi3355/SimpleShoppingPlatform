
console.log(json);

document.querySelector('.order-info').innerHTML = /* html */
`<p><strong>주문 번호:</strong> #${json.order_code}</p>
<p><strong>주문 날짜:</strong> ${json.order_date}</p>
<p><strong>결제 금액:</strong> ${json.payment.toLocaleString('ko-KR')}원</p>`;

json.items.forEach((e) => {
  document.querySelector('.order-details tbody').innerHTML += /* html */
  `<tr>
    <td>${e.product_name}</td>
    <td>${e.quantity}</td>
    <td>${e.price.toLocaleString('ko-KR')}원</td>
  </tr>`;
});