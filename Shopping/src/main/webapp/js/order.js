/**
 * order
 */

let orderItem = document.querySelector('.order');
orderItem.innerHTML = /* html */
`<h2>주문 상품 ${json.length} 개</h2>`;

json.datas.forEach((item, idx) => {
  let html = /* html */
  `<div class="summary">
    <p>상품명: </p>
    <p>수량: 2</p>
    <p>가격: 39,800원</p>
  </div>`
});