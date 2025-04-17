/**
 * order
 */


let inputlist = document.querySelectorAll('input');
inputlist.forEach((item) => {
  item.addEventListener("input", (event) => {
    document.querySelector('.address select').value = "0";
  });
});

let combo = document.querySelector('.address select');
json.deli_datas.forEach((item, idx) => {
  combo.innerHTML += /* html */
  `<option value="${item.deliveryCode}">${item.address}</option>`;
  if (idx == 0)
    getaddress(item.deliveryCode);
});
combo.innerHTML += /* html */
`<option value="0">새로운 배송지</option>`;
combo.addEventListener("change", (e) => {
  let value = e.target.value;
  if (value != 0)
    getaddress(value);
  else {
    inputlist.forEach(item => {
      item.value = "";
    });
  }
});


let orderItem = document.querySelector('.order');
orderItem.innerHTML = /* html */
`<h2>주문 상품 ${json.datas.length} 개</h2>`;

let total = 0;
json.datas.forEach((item, idx) => {
  let html = /* html */
  `<div class="summary">
    <img class="pro-image" src="images/${item.pro_img}">
    <p><b>${item.pro_name}</b></p>
    <p>${item.option} / ${item.quantity}</p>
    <p>${Number(item.price).toLocaleString('ko-KR')}원</p>
  </div>`;
  total += Number(item.price);

  orderItem.innerHTML += html;
});


function getaddress(deli_code) {
  fetch(`addressJson.do?dcode=${deli_code}`)
    .then(result => result.json())
    .then(result => {
      inputlist[0].value = result.USER_NAME;
      inputlist[1].value = result.PHONE;
      inputlist[2].value = result.POST;
      inputlist[3].value = result.ADDRESS;
      inputlist[4].value = result.REQUEST;
    })
}
