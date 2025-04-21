
function addCart(code) {
  console.log("addCart", code);
  fetch(`cartAdd.do?product_code=${code}`)
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
	console.log("buyProduct", code);
}