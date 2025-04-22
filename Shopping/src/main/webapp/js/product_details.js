document.addEventListener("DOMContentLoaded", () => {
  const thumbnails = document.querySelectorAll(".gallery-thumbnails img");
  const images = document.querySelectorAll(".gallery-image-container img");
  const leftBtn = document.querySelector(".arrow.left");
  const rightBtn = document.querySelector(".arrow.right");
  const galleryMain = document.querySelector(".gallery-main");

  let currentIndex = 0;

  function updateGallery(index) {
    thumbnails.forEach(thumb => thumb.classList.remove("active"));
    images.forEach(img => img.classList.remove("active"));

    thumbnails[index].classList.add("active");
    images[index].classList.add("active");

    currentIndex = index;
  }

  thumbnails.forEach((thumb, index) => {
    thumb.addEventListener("click", () => updateGallery(index));
  });

  leftBtn.addEventListener("click", () => {
    if (currentIndex > 0) {
      updateGallery(currentIndex - 1);
    }
  });

  rightBtn.addEventListener("click", () => {
    if (currentIndex < images.length - 1) {
      updateGallery(currentIndex + 1);
    }
  });

  updateGallery(0);
});
// 상품상세 탭기능
document.addEventListener("DOMContentLoaded", () => {
  const tabButtons = document.querySelectorAll(".tab-btn");
  const tabContents = document.querySelectorAll(".tab-content");

  tabButtons.forEach((btn) => {
    btn.addEventListener("click", () => {
      const target = btn.dataset.tab;

      tabButtons.forEach((b) => b.classList.remove("active"));
      tabContents.forEach((content) => content.classList.remove("active"));

      btn.classList.add("active");
      document.getElementById(target).classList.add("active");

      // 리뷰 탭 클릭 시 fetch 실행
	  if (target === "review") {
	    fetch(`reviewlist.do?productCode=${productCode}`)
	      .then(d => d.text())
	      .then(d => {
	        document.getElementById(target).innerHTML = d;
	      })
	      .catch(err => console.error("리뷰 불러오기 실패:", err));
	  }
    });
  });
});
// 상품상세정보 
document.addEventListener("DOMContentLoaded", () => {
  const toggleBtn = document.getElementById("toggleInfoBtn");
  const productInfo = document.getElementById("productInfoImages");

  if (toggleBtn && productInfo) {
    toggleBtn.addEventListener("click", () => {
      productInfo.classList.toggle("collapsed");
      toggleBtn.querySelector("span").textContent = productInfo.classList.contains("collapsed") 
        ? "상품 정보 더보기" 
        : "상품 정보 접기";
    });
  }
});
// 사이즈 탭기능
document.addEventListener("DOMContentLoaded", () => {
  const heightInput = document.querySelector(".input[placeholder='키']");
  const weightInput = document.querySelector(".input[placeholder='몸무게']");
  const result = document.querySelector(".recommend-result");

  function updateSizeRecommendation() {
    const h = parseInt(heightInput.value, 10);
    const w = parseInt(weightInput.value, 10);

    if (h > 170 && w > 60) {
      result.textContent = "L - 80% 추천";
    } else if (h > 160 && w > 50) {
      result.textContent = "M - 90% 추천";
    } else {
      result.textContent = "S - 85% 추천";
    }
  }

  heightInput.addEventListener("input", updateSizeRecommendation);
  weightInput.addEventListener("input", updateSizeRecommendation);
});

function removefunc(button) {
  const reviewNo = button.dataset.reviewNo;
  const userCode = button.dataset.userCode;
  const reviewDiv = button.closest('.review');

  if (!confirm('이 리뷰를 삭제하시겠습니까?')) return;

  fetch('removeReview.do', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: `reviewNo=${reviewNo}&userCode=${userCode}`
  })
  .then(res => res.json())
  .then(result => {
    if (result.result === 'success') {
      alert('리뷰가 삭제되었습니다.');
      window.location.href = 'productdetail.do'; 
    } else {
      alert('삭제 실패');
    }
  })
};