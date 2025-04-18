document.addEventListener('DOMContentLoaded', () => {
  const overlay = document.getElementById('searchOverlay');
  const closeOverlayBtn = document.getElementById('closeButton');
  const confirmSearchBtn = document.getElementById('confirmSearchBtn');
  const openOverlayBtns = document.querySelectorAll('.open-search-overlay'); // ✅ 여러 버튼 대응

  const input = document.getElementById('searchKeyword');
  const deleteAllBtn = document.getElementById('deleteAllRecent');
  const recentList = document.getElementById('recentList');
  const recentBox = document.querySelector('.recent-searches');

  // 요소 유효성 체크
  if (!overlay || !closeOverlayBtn || !confirmSearchBtn || !input || !recentList || !recentBox) {
    console.error('필요한 요소가 없습니다.');
    return;
  }

  // ✅ 여러 개의 검색 버튼 클릭 시 오버레이 열기
  openOverlayBtns.forEach(btn => {
    btn.addEventListener('click', (e) => {
      e.preventDefault();
      overlay.style.display = 'block';
      input.focus(); // 🔍 검색창에 포커스
    });
  });

  // 검색창 닫기
  closeOverlayBtn.addEventListener('click', () => {
    overlay.style.display = 'none';
  });

  // 외부 클릭 시 닫기
  overlay.addEventListener('click', (e) => {
    if (e.target === overlay || e.target.classList.contains('overlay-background')) {
      overlay.style.display = 'none';
    }
  });

  // 최근 검색어 추가
  const updateRecent = (keyword) => {
    if (!keyword) return;

    const isDuplicate = [...recentList.children].some(item => item.textContent.trim() === keyword);
    if (isDuplicate) return;

    const li = document.createElement('li');
    li.textContent = keyword;
    recentList.appendChild(li);
    recentBox.classList.add('show');
  };

  // 검색 확정 시
  confirmSearchBtn.addEventListener('click', () => {
    const keyword = input.value.trim();
    if (keyword) {
      updateRecent(keyword);
      location.href = `searchResult.do?keyword=${encodeURIComponent(keyword)}`;
    }
  });

  // Enter 키로도 검색
  input.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();
      const keyword = input.value.trim();
      if (keyword) {
        updateRecent(keyword);
        location.href = `searchResult.do?keyword=${encodeURIComponent(keyword)}`;
      }
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
