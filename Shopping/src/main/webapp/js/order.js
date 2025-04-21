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

let firstName = "";
let total = 0;
//console.log(json);
json.datas.forEach((item, idx) => {
  let html = /* html */
  `<div class="summary">
    <img class="pro-image" src="${item.pro_img}">
    <p><b>${item.pro_name}</b></p>
    <p>${item.option} / ${item.quantity}</p>
    <p>${Number(item.price).toLocaleString('ko-KR')}원</p>
  </div>`;
  total += Number(item.price) * Number(item.quantity);
  if (idx == 0) {
    firstName = item.pro_name;
    if (json.datas.length - 1 != 0)
      firstName += " 외 "+ (json.datas.length - 1) + "개";
  }

  orderItem.innerHTML += html;
});

let input = document.querySelector('.payment-box input');
input.value = `${total}`;

let payment = document.querySelectorAll('.payment');
payment.forEach((item) => {
  item.innerHTML = /* html */`${total.toLocaleString('ko-KR')}원`;
});


function getaddress(deli_code) {
  fetch(`addressJson.do?dcode=${deli_code}`)
    .then(result => result.json())
    .then(result => {
      inputlist[1].value = result.USER_NAME;
      inputlist[2].value = result.PHONE;
      inputlist[3].value = result.POST;
      inputlist[4].value = result.ADDRESS;
      inputlist[5].value = result.REQUEST;
    });
}

async function payment_click() {
  let combo = document.querySelector('.address select').value;
  if (combo == '0') {
    alert("추가 하거나 데이터를 입력하세요.");
    return;
  }
  
  const result = await fetch(`configReader.do`);
  const config = await result.json();
  //console.log(json);
  if (config.retCode != "200") //500, 404
    return alert("API키를 찾을 수 없습니다. 관리자에게 문의 하세요.");

  const response = await PortOne.requestPayment({
    // Store ID 설정
    storeId: config.datas.storeId,
    channelKey: config.datas.channelKey,
    // 채널 키 설정
    paymentId: "paymentId_" + new Date().getTime(),
    orderName: firstName,
    totalAmount: 100,
    currency: "CURRENCY_KRW",
    payMethod: "CARD",
  });

  // if (response.code !== undefined) {
  //   return alert("결제를 취소 했습니다.");
  // }

  let pro_items = [];
  //console.log(json);
  json.datas.forEach((item, idx) => {
    pro_items.push({
      "code": item.pro_code,
      "quantity": item.quantity,
      "price": item.price
    });
  });
  // console.log({
  //   "deli_code": document.querySelector('.address select').value,
  //   "productData": pro_items
  // });

  alert("성공!");
  //성공을 처리하기 위한 페이지를 호출
  const notified = await fetch(`paymentSuccess.do`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ //객체를 문자로 변환
      "deli_code": document.querySelector('.address select').value,
      "product_name": firstName,
      "payment": total,
      "productData": pro_items
    }),
  }).then((result) => {
    return result.json();
  }).then((result) => {
    //console.log(result.datas);
    window.location.href = "paymentSuccess.do?orderCode="+result.datas.order_code+"&deliveryCode="+result.datas.delivery_code
      + "&payment="+result.datas.payment;
  }).catch((err) => console.error(err));
}
