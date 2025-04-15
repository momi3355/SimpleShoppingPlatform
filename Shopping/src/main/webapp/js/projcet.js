const swiper = new Swiper(".mySwiper", {
  slidesPerView: 3,
  slidesPerGroup: 3,
  spaceBetween: 0,
  loop: true,
  autoplay: {
    delay: 4000, // 3초마다 자동 넘김
    disableOnInteraction: false // 사용자가 버튼 눌러도 계속 자동 전환 유지
  },
  navigation: {
    nextEl: ".swiper-custom-next",
    prevEl: ".swiper-custom-prev",
  },
});
document.querySelector('.search-button').addEventListener('click', () => {
  const keyword = document.getElementById('searchInput').value;
  if (keyword.trim()) {
    window.location.href = `/search?query=${encodeURIComponent(keyword)}`;
  }
});
// 탭 클릭 이벤트
const tabs = document.querySelectorAll('.tab-item');
const panels = document.querySelectorAll('.tab-panel');

tabs.forEach(tab => {
  tab.addEventListener('click', () => {
    // 모든 탭, 패널 비활성화
    tabs.forEach(t => t.classList.remove('active'));
    panels.forEach(p => p.classList.remove('active'));

    // 현재 탭, 해당 패널 활성화
    tab.classList.add('active');
    const targetId = tab.dataset.tab;
    document.getElementById(`tab-${targetId}`).classList.add('active');
  });
});
