//아이디 입력 공백 에러
$(function () {
  $('#loginForm').on('submit', function (e) {
    let valid = true;

    const id = $('#id').val().trim();
    const pw = $('#pw').val().trim();

    $('#idError').text('');
    $('#pwError').text('');

    if (id === '') {
      $('#idError').text('아이디를 입력해주세요');
      valid = false;
    }

    if (pw === '') {
      $('#pwError').text('비밀번호를 입력해주세요');
      valid = false;
    }

    if (!valid) {
      e.preventDefault();
    }
  });

  // 입력 시 메시지 제거
  $('#id').on('input', function () {
    $('#idError').text('');
  });

  $('#pw').on('input', function () {
    $('#pwError').text('');
  });
});

//아이디찾기/비밀번호 찾기 팝업
function openFindModal(type = 'id') {
  $('#findModal').show();
  $('body').css('overflow', 'hidden');
  showTab(type);
}

function closeFindModal() {
  $('#findModal').hide();
  $('body').css('overflow', 'auto');
  $('#findIdResult, #findPwResult').text('');
  $('#findName, #findPhone, #findEmail, #pwFindId, #pwFindName, #pwFindPhone, #pwFindEmail').val('');
}

function showTab(type) {
  $('.tab').removeClass('active');
  $('.tab-content').hide();

  if (type === 'id') {
    $('#tab-id').show();
    $('.tab:eq(0)').addClass('active');
  } else {
    $('#tab-pw').show();
    $('.tab:eq(1)').addClass('active');
  }
}

// 아이디 찾기 AJAX
function submitFindId() {
  const name = $('#findName').val().trim();
  const phone = $('#findPhone').val().trim();
  const email = $('#findEmail').val().trim();

  if (!name || !phone || !email) {
    $('#findIdResult').text('모든 항목을 입력해주세요.');
    return;
  }

  $.post("findId.do", {
    userName: name,
    phone: phone,
    email: email
  }, function (data) {
    if (data.status === "success") {
      $('#findIdResult').html(`회원님의 아이디는 <strong>${data.userId}</strong> 입니다.`);
    } else {
      $('#findIdResult').text("일치하는 계정이 존재하지 않습니다.");
    }
  }).fail(function () {
    $('#findIdResult').text("요청 처리 중 오류가 발생했습니다.");
  });
}

// 비밀번호 찾기 AJAX (추후 재설정 화면 연결 가능)
function submitFindPw() {
  const id = $('#pwFindId').val().trim();
  const name = $('#pwFindName').val().trim();
  const phone = $('#pwFindPhone').val().trim();
  const email = $('#pwFindEmail').val().trim();

  if (!id || !name || !phone || !email) {
    $('#findPwResult').text('모든 항목을 입력해주세요.');
    return;
  }

  $.post("findPw.do", {
    userId: id,
    userName: name,
    phone: phone,
    email: email
  }, function (data) {
    if (data.success) {
      // 추후 재설정 페이지로 이동
      window.location.href = "resetPasswordForm.do?userCode=" + data.userCode;
    } else {
      $('#findPwResult').text("일치하는 계정이 존재하지 않습니다.");
    }
  });
}