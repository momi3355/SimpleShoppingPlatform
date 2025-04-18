document.addEventListener('DOMContentLoaded', () => {
  const overlay = document.getElementById('searchOverlay');
  const closeOverlayBtn = document.getElementById('closeButton');
  const confirmSearchBtn = document.getElementById('confirmSearchBtn');
  const openOverlayBtn = document.getElementById('openSearchBtn'); // ✅ 바뀐 버튼 id 사용

  const input = document.getElementById('searchKeyword');
  const deleteAllBtn = document.getElementById('deleteAllRecent'); // 이 버튼 id도 HTML에 있어야 함
  const recentList = document.getElementById('recentList');
  const recentBox = document.querySelector('.recent-searches');

  // 요소 유효성 체크
  if (!overlay || !closeOverlayBtn || !openOverlayBtn || !confirmSearchBtn || !input || !recentList || !recentBox) {
    console.error('필요한 요소가 없습니다.');
    return;
  }

  // 검색창 열기
  openOverlayBtn.addEventListener('click', (e) => {
    e.preventDefault();
    overlay.style.display = 'block';
  });

  // 검색창 닫기
  closeOverlayBtn.addEventListener('click', () => {
    overlay.style.display = 'none';
  });

  // 오버레이 외부 클릭 시 닫기
  overlay.addEventListener('click', (e) => {
    if (e.target === overlay || e.target.classList.contains('overlay-background')) {
      overlay.style.display = 'none';
    }
  });

  // 검색 확정 시
  confirmSearchBtn.addEventListener('click', () => {
    const keyword = input.value.trim();
    if (keyword) {
      updateRecent(keyword);
      input.value = '';
    }
  });

  // 최근 검색어 모두 삭제
  if (deleteAllBtn) {
    deleteAllBtn.addEventListener('click', () => {
      recentList.innerHTML = '';
      recentBox.classList.remove('show');
    });
  }
});


