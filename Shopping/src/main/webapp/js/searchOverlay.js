document.addEventListener('DOMContentLoaded', () => {
  const input = document.getElementById('searchKeyword');
  const confirmSearchBtn = document.getElementById('confirmSearchBtn');
  const categoryInput = document.getElementById('categoryInput');

  const recentList = document.getElementById('recentList');
  const recentBox = document.querySelector('.recent-searches');
  const deleteAllBtn = document.getElementById('deleteAllRecent');

  // ⭐ localStorage에서 최근 검색어 불러오기
  const loadRecentSearches = () => {
    const saved = JSON.parse(localStorage.getItem('recentKeywords')) || [];
    if (saved.length > 0) {
      recentBox.classList.add('show');
    }
    recentList.innerHTML = '';
    saved.forEach(keyword => {
      const li = document.createElement('li');
      li.textContent = keyword;
      recentList.appendChild(li);
    });
  };

  // ⭐ 최근 검색어 저장하기
  const saveRecentSearches = (keywords) => {
    localStorage.setItem('recentKeywords', JSON.stringify(keywords));
  };

  // ⭐ 최근 검색어 추가
  const updateRecent = (keyword) => {
    if (!keyword) return;

    let recentKeywords = JSON.parse(localStorage.getItem('recentKeywords')) || [];

    // 중복 제거
    recentKeywords = recentKeywords.filter(item => item !== keyword);

    // 앞에 추가
    recentKeywords.unshift(keyword);

    // 최대 10개로 제한
    if (recentKeywords.length > 10) {
      recentKeywords.pop();
    }

    saveRecentSearches(recentKeywords);
    loadRecentSearches(); // 다시 렌더링
  };

  // ⭐ 검색 실행
  const goToSearchPage = () => {
    const keyword = input.value.trim();
    const category = categoryInput ? categoryInput.value : '';

    if (keyword) {
      updateRecent(keyword);
      const url = `searchResult.do?keyword=${encodeURIComponent(keyword)}&category=${encodeURIComponent(category)}`;
      location.href = url;
    }
  };

  // 검색 버튼 클릭
  confirmSearchBtn.addEventListener('click', goToSearchPage);

  // Enter 키 입력
  input.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();
      goToSearchPage();
    }
  });

  // ⭐ 최근 검색어 모두 삭제
  if (deleteAllBtn) {
    deleteAllBtn.addEventListener('click', () => {
      localStorage.removeItem('recentKeywords');
      recentList.innerHTML = '';
      recentBox.classList.remove('show');
    });
  }

  // ⭐ 페이지 로드시 불러오기
  loadRecentSearches();
});
