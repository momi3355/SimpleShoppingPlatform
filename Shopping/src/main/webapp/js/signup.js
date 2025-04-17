$(function () {
  let isIdAvailable = false;
  let isEmailAvailable = false;

  const setError = (id, msg) => {
    $(`#${id}`).text(msg).addClass('error').removeClass('success');
  };

  const clear = (id) => {
    $(`#${id}`).text('').removeClass('error success');
  };

  const isEmpty = val => val.trim() === '';

  // 아이디 검사 + 중복
  $('#userId').on('input', function () {
    const userId = $(this).val();
    const regex = /^[a-zA-Z0-9]{5,12}$/;

    if (!regex.test(userId)) {
      setError('idMessage', '아이디는 영문, 숫자 5-12자로 입력해주세요');
      isIdAvailable = false;
      return;
    }

    $.post("signUp.do", { checkType: 'id', userId }, function (result) {
      if (result === 'duplicate') {
        setError('idMessage', '이미 사용중인 아이디입니다.');
        isIdAvailable = false;
      } else {
        $('#idMessage').text('사용 가능한 아이디입니다!').addClass('success').removeClass('error');
        isIdAvailable = true;
      }
    });
  });

  // 이메일 검사 + 중복
  $('#email').on('input', function () {
    const email = $(this).val();
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const hasKorean = /[ㄱ-ㅎㅏ-ㅣ가-힣]/.test(email);

    if (hasKorean || !regex.test(email)) {
      setError('emailMessage', '이메일주소가 올바르지 않습니다');
      isEmailAvailable = false;
      return;
    }

    $.post("signUp.do", { checkType: 'email', email }, function (result) {
      if (result === 'duplicate') {
        setError('emailMessage', '이미 사용중인 이메일입니다.');
        isEmailAvailable = false;
      } else {
        $('#emailMessage').text('사용 가능한 이메일입니다!').addClass('success').removeClass('error');
        isEmailAvailable = true;
      }
    });
  });

  // 비밀번호 검사
  $('#password').on('input', function () {
    const pw = $(this).val();
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;
    if (!regex.test(pw)) {
      setError('passwordMessage', '비밀번호는 영문, 숫자 조합 최소 8자');
    } else {
      clear('passwordMessage');
    }
  });

  // 비밀번호 확인
  $('#passwordCheck').on('input', function () {
    const pw = $('#password').val();
    const pwCheck = $(this).val();
    if (pw !== pwCheck) {
      setError('pwMessage', '비밀번호가 일치하지 않습니다.');
    } else {
      $('#pwMessage').text('비밀번호가 일치합니다.').addClass('success').removeClass('error');
    }
  });

  // 이름/전화번호 실시간 제거 및 숫자 제한
  $('#userName').on('input', () => clear('nameMessage'));
  $('#phone').on('input', function () {
    clear('phoneMessage');
    this.value = this.value.replace(/[^0-9]/g, '');
  });

  // 제출 검사
  $('#signupForm').on('submit', function (e) {
    let valid = true;
    const pw = $('#password').val();
    const pwCheck = $('#passwordCheck').val();
    const name = $('#userName').val();
    const phone = $('#phone').val();
    const pwValid = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/.test(pw);

    if (!isIdAvailable) {
      setError('idMessage', '아이디를 확인해주세요');
      valid = false;
    }
    if (!isEmailAvailable) {
      setError('emailMessage', '이메일을 확인해주세요');
      valid = false;
    }
    if (!pwValid) {
      setError('passwordMessage', '비밀번호를 확인해주세요');
      valid = false;
    }
    if (pw !== pwCheck) {
      setError('pwMessage', '비밀번호가 일치하지 않습니다.');
      valid = false;
    }
    if (isEmpty(name)) {
      setError('nameMessage', '이름을 입력해주세요');
      valid = false;
    }
    if (isEmpty(phone)) {
      setError('phoneMessage', '전화번호를 입력해주세요');
      valid = false;
    }

    if (!valid) e.preventDefault();
  });
});
