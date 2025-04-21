document.addEventListener("DOMContentLoaded", function () {
  // ✅ Swiper 초기화 (중복 선언 방지)
  const swiperContainer = document.querySelector(".mySwiper");
  if (swiperContainer) {
    new Swiper(".mySwiper", {
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

  // ✅ 필터 로직: 각 탭마다 동작하도록
  const tabNames = ["outerwear", "top", "bottom", "shoes", "accessories"];

  tabNames.forEach(tab => {
    const genderFilter = document.getElementById(`${tab}-gender-filter`);
    const priceFilter = document.getElementById(`${tab}-price-filter`);
    const cardsWrap = document.querySelector(`#tab-${tab} .product-list-grid`);
    const cards = cardsWrap ? Array.from(cardsWrap.querySelectorAll(".product-card")) : [];

    if (!genderFilter || !priceFilter || !cardsWrap) return;

    function applyFilter() {
      const gender = genderFilter.value;
      const priceSort = priceFilter.value;

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

      // 카드 다시 출력
      cardsWrap.innerHTML = "";
      filtered.forEach(card => cardsWrap.appendChild(card));
    }

    genderFilter.addEventListener("change", applyFilter);
    priceFilter.addEventListener("change", applyFilter);
  });
});
