function toggleNotice(boardCode, element) {
  const detailDiv = $(element).closest('.notice-item').find('.notice-detail');
  const toggleBtn = $(element).closest('.notice-item').find('.notice-toggle-btn');

  if (detailDiv.is(':visible')) {
    detailDiv.slideUp();
    toggleBtn.text('▼');
  } else {
    if (detailDiv.html().trim() === '') {
      $.ajax({
        url: contextPath + "/noticeContent.do",
        data: { boardCode: boardCode },
        success: function (data) {
          if (data && !data.error) {
            let html = `

              <div class="notice-detail-body">${data.boardContent}</div>
            `;
            detailDiv.html(html);
            detailDiv.slideDown();
            toggleBtn.text('▲');
          } else {
            detailDiv.html("<div class='notice-detail-body'>내용이 없습니다.</div>");
            detailDiv.slideDown();
            toggleBtn.text('▲');
          }
        },
        error: function () {
          alert("공지사항 내용을 불러오지 못했습니다.");
        }
      });
    } else {
      detailDiv.slideDown();
      toggleBtn.text('▲');
    }
  }
}
