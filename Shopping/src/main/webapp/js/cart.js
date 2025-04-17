/**
 * cart
 */

//console.log(userCode);
fetch("cartJson.do?ucode=" + userCode)
  .then(result => result.json())
  .then(result => loadItem(result))
  .catch(err => console.error(err));

function loadItem(json) {
  let totalPrice = 0;
  json.forEach((item, idx) => {
    //console.log(item.IMAGE_URL_FIR);
    let target = document.querySelector(".cart-target");
    if (idx == 0) {
      target.innerHTML = /* html */
      `<input type="hidden" id="total_count" name="total_count" value="${json.length}">`;
    }
    
    let html = /* html */
    `<tr>
      <input type="hidden" id="pro_code_${idx}" name="pro_code_${idx}" value="${item.PRODUCT_CODE}"> 
      <td class="cart-code">${idx + 1}</td>
      <td class="cart-name"><img class="cart-image" src="images/${item.IMAGE_URL_FIR}">${item.PRODUCT_NAME}</td>
      <td class="cart-option">${item.PRODUCT_OPTION}</td>
      <td class="cart-price">${item.PRICE.toLocaleString('ko-KR')}</td>
      <td class="cart-quantity">
        <input type="number" name="quantity_${idx}" id="quantity_${idx}" value="${item.QUANTITY}">
      </td>
      <td class="cart-total-price">${(item.PRICE * item.QUANTITY).toLocaleString('ko-KR')}</td>
      <td class="cart-btn">
        <input type="button" href="javascript:void(0)" class="abutton" onclick="removeItem(event);" value="삭제">
      </td>
    </tr>`;
    target.innerHTML += html;

    totalPrice += item.PRICE * item.QUANTITY;
    let total = document.querySelector(".cart-table tfoot");
    total.innerHTML = /* html */
    `<tr class="total-price">
      <td colspan="7"><b>최종결제금액</b> <span>${totalPrice.toLocaleString('ko-KR')} 원</span></td>
    </tr>`;

  });
}

function removeItem(event) {
  let tr = event.target.parentElement.parentElement;


  tr.remove(); //나중에 수정 만들고 새로고침 필요.
}