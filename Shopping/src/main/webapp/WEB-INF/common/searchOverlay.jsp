<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="searchOverlay" class="search-overlay">
  <div class="overlay-background"></div>
  <div class="overlay-content">
    <header class="search-header">
      <div class="search-input-box">
        <input type="text" id="searchKeyword" placeholder="검색어를 입력하세요" />
        <button id="confirmSearchBtn" class="search-button" aria-label="검색">
          <svg width="100%" height="100%" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12 12L16.5 16.5M13.5 8.5C13.5 11.2614 11.2614 13.5 8.5 13.5C5.73858 13.5 3.5 11.2614 3.5 8.5C3.5 5.73858 5.73858 3.5 8.5 3.5C11.2614 3.5 13.5 5.73858 13.5 8.5Z"
              class="stroke-gray-500" vector-effect="non-scaling-stroke" stroke-width="1.4" stroke="gray">
            </path>
          </svg>
        </button>
        <button id="closeButton" class="close-button" aria-label="닫기">
          <svg width="100%" height="100%" viewBox="0 0 20 20" fill="none">
            <path d="M5 5L15 15M5 15L15 5" stroke-width="1.4" stroke="gray" />
          </svg>
        </button>
      </div>
    </header>

    <div class="search-content">
      <section class="recent-searches">
        <header>
          <span class="title">최근 검색어</span>
          <button class="clear-all" id="deleteAllRecent">모두삭제</button>
        </header>
        <ul id="recentList"></ul>
      </section>

      <article class="popular-keywords">
        <header class="popular-header">
          <span class="title">인기 검색어</span>
        </header>
        <ol class="keyword-list">
          <li>
            <button>
              <span class="rank-number">1</span>
              <span class="keyword">아우터</span>
              <span class="rank-icon up"></span>
            </button>
          </li>
           <li>
            <button>
              <span class="rank-number">2</span>
              <span class="keyword">신발</span>
              <span class="rank-icon down"></span>
            </button>
          </li>
           <li>
            <button>
              <span class="rank-number">3</span>
              <span class="keyword">상의</span>
              <span class="rank-icon stay"></span>
            </button>
          </li>
           <li>
            <button>
              <span class="rank-number">4</span>
              <span class="keyword">패션소품</span>
              <span class="rank-icon up"></span>
            </button>
          </li>
           <li>
            <button>
              <span class="rank-number">5</span>
              <span class="keyword">하의</span>
              <span class="rank-icon down"></span>
            </button>
          </li>
        </ol>
      </article>
    </div>
  </div>
</div>