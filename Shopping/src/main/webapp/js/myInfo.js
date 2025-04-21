$(function () {
  let pwVerified = false;

  // 비밀번호 검증
  $('#password').on('input', function () {
    const password = $(this).val().trim();
    $('#pwMessage').text('');

    if (!password) {
      $('#pwMessage').text('비밀번호를 입력해주세요.');
      pwVerified = false;
      toggleSaveButton();
      return;
    }

    $.ajax({
      url: 'myInfoPw.do',
      type: 'post',
      data: { password },
      success: function (res) {
        if (res.result) {
          $('#pwMessage').text('비밀번호 확인 완료').css('color', 'green');
          pwVerified = true;
        } else {
          $('#pwMessage').text('비밀번호가 일치하지 않습니다.').css('color', 'red');
          pwVerified = false;
        }
        toggleSaveButton();
      },
      error: function () {
        $('#pwMessage').text('오류가 발생했습니다.');
        pwVerified = false;
        toggleSaveButton();
      }
    });
  });

  // 이메일 유효성 검사
  $('#email').on('input', function () {
    const email = $(this).val().trim();
    const regex = /^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,}$/;
    if (!regex.test(email)) {
      $('#emailMessage').text('이메일 형식이 올바르지 않습니다.');
    } else {
      $('#emailMessage').text('');
    }
    toggleSaveButton();
  });

  // 전화번호 유효성 검사
  $('#phone').on('input', function () {
    const phone = $(this).val().trim();
    const regex = /^\d{10,11}$/;
    if (!regex.test(phone)) {
      $('#phoneMessage').text('전화번호는 10~11자리 숫자만 가능합니다.');
    } else {
      $('#phoneMessage').text('');
    }
    toggleSaveButton();
  });

  // 저장버튼 활성화 조건 체크
  function toggleSaveButton() {
    const emailValid = $('#emailMessage').text() === '';
    const phoneValid = $('#phoneMessage').text() === '';
    if (pwVerified && emailValid && phoneValid) {
      $('#saveBtn').prop('disabled', false);
    } else {
      $('#saveBtn').prop('disabled', true);
    }
  }

  // 저장 버튼 클릭
  $('#saveBtn').on('click', function () {
    const email = $('#email').val().trim();
    const phone = $('#phone').val().trim();

    $.ajax({
      url: 'myInfo.do',
      type: 'post',
      data: { email, phone },
      success: function () {
        alert('정보가 성공적으로 수정되었습니다.');
        location.reload();
      },
      error: function () {
        alert('수정 중 오류가 발생했습니다.');
      }
    });
  });
  // 이메일, 전화번호 클릭 시 전체 선택
  $('#email, #phone').on('focus', function () {
    $(this).select();
  });
});
