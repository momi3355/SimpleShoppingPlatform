document.addEventListener("DOMContentLoaded", function () {
  const context = window.contextPath || '';

  // 1) Swiper 초기화
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

  // 2) 탭 클릭 이벤트
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

  // 3) 카테고리별 필터 로직
  const tabNames = ["outerwear", "top", "bottom", "shoes", "accessories"];
  tabNames.forEach(tab => {
    const genderFilter = document.getElementById(`${tab}-gender-filter`);
    const priceFilter  = document.getElementById(`${tab}-price-filter`);
    const cardsWrap    = document.querySelector(`#tab-${tab} .product-list-grid`);
    const cards        = cardsWrap ? Array.from(cardsWrap.querySelectorAll(".product-card")) : [];
    if (!genderFilter || !priceFilter || !cardsWrap) return;

    function applyFilter() {
      const gender   = genderFilter.value;
      const priceSort= priceFilter.value;
      let filtered = [...cards];

      // 성별 필터
      if (gender !== "all") {
        const korToEng = { '남성':'male', '여성':'female' };
        filtered = filtered.filter(c => korToEng[c.dataset.gender] === gender);
      }

      // 가격 정렬
      filtered.sort((a,b) => {
        const pa = parseInt(a.dataset.price,10);
        const pb = parseInt(b.dataset.price,10);
        if (priceSort === "cheap")     return pa - pb;
        if (priceSort === "expensive") return pb - pa;
        return 0;
      });

      cardsWrap.innerHTML = "";
      filtered.forEach(c => cardsWrap.appendChild(c));
    }

    genderFilter.addEventListener("change", applyFilter);
    priceFilter.addEventListener("change", applyFilter);
  });

  // 4) 신상품 “더보기” 버튼 AJAX
  let newPage = 1;
  let isNewLoading = false;
  const newBtn = document.getElementById("loadMoreBtn");
  const newContainer = document.getElementById("new-product-list");

  function loadNewMore(e) {
    e.preventDefault();
    if (isNewLoading) return;
    isNewLoading = true;
    newPage++;

    fetch(`${context}/newproductajax.do?page=${newPage}`)
      .then(res => res.json())
      .then(data => {
        if (!data || data.length === 0) {
          newBtn.style.display = "none";
          return;
        }

        data.forEach(product => {
          const card = document.createElement("div");
          card.className = "product-card";
          card.innerHTML = `
            <a href="${context}/productdetail.do?product_code=${product.productCode}">
              <div class="product-image">
                <img src="${product.imageUrlFir}" alt="${product.imageDescription}" />
              </div>
              <div class="product-info">
                <p class="brand">${product.productCategory}</p>
                <p class="name">${product.productName}</p>
                <p class="price">
                  ${product.originalPrice > product.price
                    ? `<span class="discount">${product.discountRate}%</span>` : ''}
                  ${product.price}원
                </p>
              </div>
            </a>`;
          newContainer.appendChild(card);
        });

        if (data.length < 10) {
          newBtn.style.display = "none";
        }
      })
      .catch(err => console.error("신상품 더보기 실패:", err))
      .finally(() => isNewLoading = false);
  }

  if (newBtn && newContainer) {
    newBtn.addEventListener("click", loadNewMore);
  }

  // ✅ 인기상품 “더보기” 버튼 AJAX
    let popularPage = 1; // 초기값 1 (JSP로 이미 1페이지 출력했으므로)
    let isPopularLoading = false;

    const popularBtn = document.getElementById("loadMorePopularBtn");
    const popularContainer = document.getElementById("popular-product-list");

    function loadPopularMore(e) {
      e.preventDefault();
      if (isPopularLoading) return;

      isPopularLoading = true;
      popularPage++; // 다음 페이지 호출

      fetch(`${context}/popularproductajax.do?page=${popularPage}`)
        .then(res => {
          if (!res.ok) throw new Error("서버 오류");
          return res.json();
        })
        .then(data => {
          if (!data || data.length === 0) {
            popularBtn.style.display = "none";
            return;
          }

          data.forEach((product, index) => {
            const card = document.createElement("div");
            card.className = "product-card";
            card.innerHTML = `
              <span class="ranking-badge">${(popularPage - 1) * 10 + index + 1}</span>
              <a href="${context}/productdetail.do?product_code=${product.productCode}">
                <div class="product-image">
                  <img src="${product.imageUrlFir}" alt="${product.imageDescription}" />
                </div>
                <div class="product-info">
                  <p class="brand">${product.productCategory}</p>
                  <p class="name">${product.productName}</p>
                  <p class="price">
                    ${product.originalPrice > product.price
                      ? `<span class="discount">${product.discountRate}%</span>` : ''}
                    ${product.price}원
                  </p>
                </div>
              </a>
              <div class="live-info">
                <span>${product.salesCount}명이 구매</span>
              </div>`;
            popularContainer.appendChild(card);
          });

          if (data.length < 10) {
            popularBtn.style.display = "none";
          }
        })
        .catch(err => {
          console.error("🔥 인기상품 더보기 실패:", err);
        })
        .finally(() => {
          isPopularLoading = false;
        });
    }

    // ✅ 버튼이 존재할 경우에만 이벤트 연결
    if (popularBtn && popularContainer) {
      popularBtn.addEventListener("click", loadPopularMore);
    } else {
      console.warn("⚠️ 인기상품 버튼 또는 컨테이너가 존재하지 않습니다.");
    }
  });