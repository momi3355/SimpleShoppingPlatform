
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
  if (value != 0) {
    getaddress(value);
    document.querySelector('#add-btn').setAttribute("disabled", "true");
    document.querySelector('#add-btn').className = "address-btn disabled";
    document.querySelector('#remove-btn').removeAttribute("disabled");
    document.querySelector('#remove-btn').className = "address-btn remove";
  } else {
    inputlist.forEach(item => {
      item.value = "";
    });
    document.querySelector('#add-btn').removeAttribute("disabled");
    document.querySelector('#add-btn').className = "address-btn add";
    document.querySelector('#remove-btn').setAttribute("disabled", "true");
    document.querySelector('#remove-btn').className = "address-btn disabled";
  }
});

if (combo.value != 0) {
  document.querySelector('#add-btn').setAttribute("disabled", "true");
  document.querySelector('#add-btn').className = "address-btn disabled";
  document.querySelector('#remove-btn').removeAttribute("disabled");
  document.querySelector('#remove-btn').className = "address-btn remove";
} else {
  document.querySelector('#add-btn').removeAttribute("disabled");
  document.querySelector('#add-btn').className = "address-btn add";
  document.querySelector('#remove-btn').setAttribute("disabled", "true");
  document.querySelector('#remove-btn').className = "address-btn disabled";
}

document.querySelector('#remove-btn')
  .addEventListener('click', e => {
    let config = confirm("배송정보를 삭제하시겠습니까?");
    if (config) {
      fetch(`removeAddress.do?deliCode=${combo.value}`)
        .then(result => result.json())
        .then(result => {
          if (result.retCode == '200') {
            alert("정상적으로 삭제가 되었습니다");
            window.location.href = "address.do";
          } else {
            alert("삭제가 되지 않았습니다.");
          }
        }).catch(err => console.error(err));
    }
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