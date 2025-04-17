document.addEventListener("DOMContentLoaded", function () {
  // ✅ Swiper 초기화 (중복 선언 방지 위해 let으로 선언)
  let mainSwiper;
  const swiperContainer = document.querySelector(".mySwiper");
  if (swiperContainer) {
    mainSwiper = new Swiper(".mySwiper", {
      slidesPerView: 3,
      slidesPerGroup: 3,
      spaceBetween: 0,
      loop: true,
      autoplay: {
        delay: 4000,
        disableOnInteraction: false
      },
      navigation: {
        nextEl: ".swiper-custom-next",
        prevEl: ".swiper-custom-prev"
      }
    });
  }

  // ✅ 탭 클릭 이벤트
  const tabs = document.querySelectorAll('.tab-item');
  const panels = document.querySelectorAll('.tab-panel');

  tabs.forEach(tab => {
    tab.addEventListener('click', () => {
      tabs.forEach(t => t.classList.remove('active'));
      panels.forEach(p => p.classList.remove('active'));

      tab.classList.add('active');
      const targetId = tab.dataset.tab;
      document.getElementById(`tab-${targetId}`).classList.add('active');
    });
  });

  // ✅ 아우터 필터 적용
  const genderFilter = document.getElementById("outer-gender-filter");
  const priceFilter = document.getElementById("outer-price-filter");
  const cardsWrap = document.querySelector("#tab-outerwear .product-list-grid");
  const cards = cardsWrap ? Array.from(cardsWrap.querySelectorAll(".product-card")) : [];

  function applyFilter() {
    if (!cardsWrap) return;

    const gender = genderFilter ? genderFilter.value : "all";
    const priceSort = priceFilter ? priceFilter.value : "allprice";

    let filtered = [...cards];

    // 성별 필터
    if (gender !== "all") {
      const korToEng = {
        '남성': 'male',
        '여성': 'female'
      };
      filtered = filtered.filter(card => {
        const genderData = korToEng[card.dataset.gender];
        return genderData === gender;
      });
    }

    // 가격 정렬
    filtered.sort((a, b) => {
      const priceA = parseInt(a.dataset.price);
      const priceB = parseInt(b.dataset.price);
      if (priceSort === "cheap") return priceA - priceB;
      if (priceSort === "expensive") return priceB - priceA;
      return 0;
    });

    // 카드 다시 append
    cardsWrap.innerHTML = "";
    filtered.forEach(card => cardsWrap.appendChild(card));
  }

  if (genderFilter) genderFilter.addEventListener("change", applyFilter);
  if (priceFilter) priceFilter.addEventListener("change", applyFilter);
});