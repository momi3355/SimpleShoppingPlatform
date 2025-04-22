fetch(`orderListJson.do`)
  .then(result => result.json())
  .then(result => {
    const json = result.reduce((acc, item) => {
      const date = item.orderDate;
      if (!acc[date]) {
        acc[date] = [];
      }
      acc[date].push(item);
      return acc;
    }, {});
    addOrderList(json);
  }).catch(err => console.error(err));

function addOrderList(json) {
  let orderList = document.querySelector('.order-list-container');
  
  for (const date in json) {
    if (json.hasOwnProperty(date)) {
      //console.log('날짜:', date);
      orderList.innerHTML += /* html */`<p class="order-date">${date}</p>`;
      const products = json[date];
      products.forEach(product => {
        //console.log(product);
        orderList.innerHTML += /* html */
        `<div class="summary">
          <img class="pro-image" src="${product.imageUrlFir}">
          <p><b>${product.productName}</b></p>
          <p>${product.quantity}개</p>
          <p><b>${product.totalPrice.toLocaleString('ko-KR')}원</b></p>
        </div>
        <div class="order-btn">
          <button type="button" onclick="review(${product.productCode})">후기작성</button>
        </div>`;
      });
    }
  }
}

function review(pcode) {
  window.location.href = `reviewForm.do?productCode=${pcode}`;
}