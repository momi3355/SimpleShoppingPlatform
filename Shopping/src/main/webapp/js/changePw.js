$(function () {
  // 비밀번호 조건 검증 + 버튼 활성화
  $('#newPw, #confirmPw').on('input', function () {
    const newPw = $('#newPw').val();
    const confirmPw = $('#confirmPw').val();
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;

    if (!regex.test(newPw)) {
      $('#pwMessage').text('비밀번호는 영문 + 숫자 조합 8자 이상이어야 합니다.');
      $('#changePwBtn').prop('disabled', true);
    } else if (newPw !== confirmPw) {
      $('#pwMessage').text('비밀번호가 일치하지 않습니다.');
      $('#changePwBtn').prop('disabled', true);
    } else {
      $('#pwMessage').text('');
      $('#changePwBtn').prop('disabled', false);
    }
  });
});

// 현재 비밀번호 확인 → pw-reset 영역 표시
function checkCurrentPw() {
  const pw = $('#currentPw').val().trim();

  if (!pw) {
    $('#checkPwError').text('비밀번호를 입력해주세요.');
    return;
  }

  $.post('checkPw.do', { password: pw }, function (result) {
    if (result.success) {
      $('#pw-check').hide();
      $('#pw-reset').show();
    } else {
      $('#checkPwError').text('현재 비밀번호가 일치하지 않습니다.');
    }
  });
}

// 비밀번호 변경 처리
function submitNewPassword() {
  const newPw = $('#newPw').val().trim();

  if (!newPw) {
    $('#pwMessage').text('새 비밀번호를 입력해주세요.');
    return;
  }

  $.post('changePw.do', { newPw: newPw }, function (result) {
    if (result.success) {
      alert('비밀번호 변경이 완료되었습니다. 로그인 후 이용해주세요.');
      location.href = 'logout.do';
    } else {
      alert('비밀번호 변경에 실패했습니다.');
    }
  });
}

// 비밀번호 토글
function togglePassword(inputId, icon) {
  const input = document.getElementById(inputId);
  if (!input) return;

  if (input.type === "password") {
    input.type = "text";
    icon.classList.remove("fi-rr-eye");
    icon.classList.add("fi-rr-eye-crossed");
  } else {
    input.type = "password";
    icon.classList.remove("fi-rr-eye-crossed");
    icon.classList.add("fi-rr-eye");
  }
}
