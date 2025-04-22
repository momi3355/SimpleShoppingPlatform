<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>리뷰 작성</title>

<style>
.container {
	width: 100%;
	margin: 0 auto; /* 가운데 정렬 */
	padding: 0 20px; /* 좌우 여백 */
}

.textarea-wrapper {
	position: relative;
	width: 600px;
}

.review_box {
	width: 100%;
	height: 150px;
	border: 2px solid #9a9a9a;
	resize: none;
	font-family: 'Noto Sans KR', sans-serif;
	padding: 10px;
	box-sizing: border-box;
	border-radius: 5px;
}

button {
	font-family: 'Noto Sans KR', sans-serif;
}

#submitBtn {
	background-color: #000000;
	padding: 8px 15px 8px 15px;
	height: auto;
	width: 150px;
	box-sizing: border-box;
	border-radius: 5px;
	font-size: 15px;
	color: #ffffff;
	font-weight: 500;
	border: none;
	margin-bottom: 50px;
	margin-left: 450px;
}

#charCount {
	position: pixed;
	bottom: 12px;
	right: 15px;
	font-size: 12px;
	color: #666;
	background: white;
	padding: 0 4px;
	z-index: 1;
	pointer-events: none;
}

p {
	font-size: 18px;
	margin: 3px 3px 3px 3px;
	
}

h1 {
	margin-top: 0;
}

.rating {
	display: flex;
	flex-direction: row-reverse;
	justify-content: start;
	margin: 0 0 20px;
	clear: both;
}

.rating input {
	display: none;
}

.rating label {
	position: relative;
	width: 30px;
	font-size: 30px;
	color: #ccc;
	cursor: pointer;
}

.rating label::before {
	content: '★';
	position: absolute;
}

.rating input:checked ~ label::before {
	color: gold;
}

.rating label:hover::before, .rating label:hover ~ label::before {
	color: gold;
}

.productimage {
	float: left;
	height: 90px;
	width: 90px;
	margin-right: 10px;
}
</style>
</head>
<div class="container">
  <form action="addReview" method="post" accept-charset="UTF-8">
  	<input type="hidden" name="productCode" value="${param.productCode }">
  	<input type="hidden" name="userCode" value="${sessionScope.userCode }">
	<div style="margin-top: 50px; margin-bottom: 50px;">
		<h2 style="margin-top: 100px;">이 상품 어떠셨나요?</h2>
		<br>
		<!-- 상품이미지, 상품이름, 상품옵션 -->
		<div class="productitem">
			
		</div>
	</div>

		<!-- 별점 등록  -->
		<div class="rating">
		  <input type="radio" id="star5" name="rating" value="5"><label for="star5" title="5점"></label> 
		  <input type="radio" id="star4" name="rating" value="4"><label for="star4" title="4점"></label>
		  <input type="radio" id="star3" name="rating" value="3"><label for="star3" title="3점"></label> 
		  <input type="radio" id="star2" name="rating" value="2"><label for="star2" title="2점"></label>
		  <input type="radio" id="star1" name="rating" value="1"><label for="star1" title="1점"></label>
		</div>

	<hr style="border: solid 1px black; margin-top: 70px; margin-bottom: 30px">

	<h2>어떤 점이 좋았나요?</h2>
	<p style="margin-bottom: 5px;">
		<b>본문 입력(필수)</b>
	</p>

	<div class="textarea-wrapper">
		<textarea class="review_box" name="content"
			placeholder="상품을 사용하시면서 느꼈던 의견을 자세히 공유해주세요. (20자 이상)" maxlength="500"></textarea>
		<span id="charCount">0</span>
		<button type="button" id="submitBtn"><b>등록하기</b></button>
	</div>
  </form>
</div>


<script>
fetch(`productInfo.do?productCode=${param.productCode }`)
	.then(result => result.json())
	.then(result => {
	let html = `<img class="productimage" src="\${result.imageUrlFir}">
			    <p><b>\${result.productName}</b></p> 
			       <p style="font-size: 14px">\${result.price}원</p>`;
	document.querySelector('.productitem').innerHTML = html;
	});

const productCode = "${param.productCode}";
const userCode = "${sessionScope.userCode}";
const textarea = document.querySelector('.review_box');
const charCount = document.getElementById('charCount');
const submitBtn = document.getElementById('submitBtn'); 
const reviewform = document.getElementById('reviewform'); 
const rating = document.querySelector('.rating'); // 별점

textarea.addEventListener('input', () => {
  charCount.textContent = textarea.value.length;
});

submitBtn.addEventListener('click', (e) => {
	  e.preventDefault(); // 폼의 기본 동작 막기

	  const length = textarea.value.trim().length;
	  const starScore = document.querySelector('input[name="rating"]:checked')?.value; // 선택된 별점 값

	  if (!starScore || parseInt(starScore) === 0) {
	    alert('별점을 추가해주세요.');
	    return;
	  }

	  if (length < 20) {
	    alert('리뷰는 20자 이상 입력해야 합니다.');
	    return;
	  }

	  // AJAX로 데이터 전송
	  const formData = new FormData();
	  formData.append("productCode", document.querySelector('input[name="productCode"]').value);
	  formData.append("userCode", document.querySelector('input[name="userCode"]').value);
	  formData.append("rating", starScore); // 별점
	  formData.append("content", textarea.value); // 리뷰 내용
	  
	  fetch("addReview.do", {
	    method: "POST",
	    body: formData
	  })
	  .then(response => response.json()) // 서버로부터 응답 받기
	  .then(data => {
	    if (data.retCode === "OK") {
	      alert('리뷰를 등록했습니다.');
	      window.location.href = "main.do"; // 성공하면 main.do로 이동
	    } else {
	      alert('리뷰 등록에 실패했습니다.');
	    }
	  })
	  .catch(error => {
	    console.error('Error:', error);
	    alert('서버 오류가 발생했습니다.');
	  });
	});

</script>
</html>
