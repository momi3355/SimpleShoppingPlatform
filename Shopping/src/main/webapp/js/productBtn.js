
function addCart(code) {
  const selectedSize = document.querySelector('#size-select').value;
  if (selectedSize === "") {
    alert("사이즈를 선택해주세요.");
	return;
  }
	
  //console.log("addCart", code);
  fetch(`cartAdd.do?product_code=${code}&option=${selectedSize}`)
    .then(result => result.json())
	.then(result => {
		if (result.retCode == '200') {
			alert("장바구니에 추가 되었습니다.");
		} else if (result.retCode == '404') {
			alert("로그인을 하시기 바랍니다.")
		} else {
			alert("장바구니에 추가가 실패되었습니다.");
		}
	});
}

function buyProduct(code) {
	const selectedSize = document.querySelector('#size-select').value;
	if (selectedSize === "") {
	  alert("사이즈를 선택해주세요.");
	  return;
	}
	//console.log("buyProduct", code);
	window.location.href = `orderForm.do?product_code=${code}&option=${selectedSize}`;
}