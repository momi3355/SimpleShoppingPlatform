/**
 * order
 */

let orderItem = document.querySelector('.order');
orderItem.innerHTML = /* html */
`<h2>주문 상품 ${json.length} 개</h2>`;

json.datas.forEach((item, idx) => {
  let html = /* html */
  `<div class="summary">
    <p><b>${item.pro_name}</b></p>
    <p>${item.option} / ${item.quantity}</p>
    <p>${item.price.toLocaleString('ko-KR')}원</p>
  </div>`

  orderItem.innerHTML += html;
});