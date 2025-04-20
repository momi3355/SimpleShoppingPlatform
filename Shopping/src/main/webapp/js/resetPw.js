$(function () {
  // 비밀번호 유효성 검사 및 버튼 활성화
  $('#newPw, #confirmPw').on('input', function () {
    const newPw = $('#newPw').val();
    const confirmPw = $('#confirmPw').val();
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;

    if (!regex.test(newPw)) {
      $('#resetPwMessage').text('비밀번호는 영문 + 숫자 조합 8자 이상이어야 합니다.');
      $('#submitBtn').prop('disabled', true);
    } else if (newPw !== confirmPw) {
      $('#resetPwMessage').text('비밀번호가 일치하지 않습니다.');
      $('#submitBtn').prop('disabled', true);
    } else {
      $('#resetPwMessage').text('');
      $('#submitBtn').prop('disabled', false);
    }
  });

  // 비밀번호 재설정 폼 제출 처리
  $('#resetPwForm').on('submit', function (e) {
    e.preventDefault();

    const newPw = $('#newPw').val();
    const userCode = $('input[name="userCode"]').val();

    $.post('resetPassword.do', { userCode, newPassword: newPw }, function (result) {
      if (result.success) {
        alert('비밀번호 변경이 완료되었습니다. 로그인 후 이용해주세요.');
        location.href = 'loginForm.do';
      } else {
        alert('비밀번호 변경에 실패했습니다.');
      }
    });
  });
});

// 비밀번호 보기 토글
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
