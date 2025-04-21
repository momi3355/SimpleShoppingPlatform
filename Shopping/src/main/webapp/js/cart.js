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
      <td class="cart-name"><img class="cart-image" src="${item.IMAGE_URL_FIR}">${item.PRODUCT_NAME}</td>
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
  
  document.querySelectorAll('input[type="number"]').forEach((e) => {
	e.addEventListener('change', function(event) {
		let trTag = event.target.parentElement.parentElement;
		let pcode = trTag.querySelector('input').value;
		let price = Number(trTag.querySelector('.cart-price').innerHTML.replace(/\D/g,''));
		let quantity = Number(event.target.value);
		fetch(`cartUpdate.do?product_code=${pcode}&quantity=${quantity}`)
	      .then(result => result.json());
		//console.log(price, quantity);
		trTag.querySelector('.cart-total-price').innerHTML = (price * quantity).toLocaleString('ko-KR');
		
		let totalPrice = 0;
		document.querySelectorAll('tbody>tr').forEach((item) => {
			let itemPrice = Number(item.querySelector('.cart-price').innerHTML.replace(/\D/g,''));
			let itemQuantity = Number(item.querySelector('.cart-quantity > input').value);
			totalPrice += itemPrice * itemQuantity;
		});
		
		//변경할때 데이터베이스 반영
		let total = document.querySelector(".cart-table tfoot");
		    total.innerHTML = /* html */
		    `<tr class="total-price">
		      <td colspan="7"><b>최종결제금액</b> <span>${totalPrice.toLocaleString('ko-KR')} 원</span></td>
		    </tr>`;
	});
  });
}

function removeItem(event) {
  let tr = event.target.parentElement.parentElement;
  let pcode = tr.querySelector('input').value;
  fetch(`cartRemove.do?product_code=${pcode}`)
    .then(result => result.json())
	.then(result => {
		if (result.retCode == '200') {
			alert("삭제되었습니다.");
		}
	});
  tr.remove(); //나중에 수정 만들고 새로고침 필요.
  let totalPrice = 0;
  document.querySelectorAll('tbody>tr').forEach((item) => {
	let itemPrice = Number(item.querySelector('.cart-price').innerHTML.replace(/\D/g,''));
	let itemQuantity = Number(item.querySelector('.cart-quantity > input').value);
	totalPrice += itemPrice * itemQuantity;
  });
  //변경할때 데이터베이스 반영
  let total = document.querySelector(".cart-table tfoot");
  total.innerHTML = /* html */
  `<tr class="total-price">
    <td colspan="7"><b>최종결제금액</b> <span>${totalPrice.toLocaleString('ko-KR')} 원</span></td>
  </tr>`;
}