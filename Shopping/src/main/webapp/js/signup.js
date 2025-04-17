/**
 *  signup.js
 */
// 아이디 유효성 검사
$('#userId').on('blur', function () {
    const userId = $(this).val();
    const regex = /^[a-zA-Z0-9]{5,12}$/;

    if (!regex.test(userId)) {
        $('#idMessage').text('아이디는 영문, 숫자 5-12자로 입력해주세요').addClass('error').removeClass('success');
        return;
    }

    $.post("signUp.do", { checkType: 'id', userId: userId }, function (result) {
        if (result === 'duplicate') {
            $('#idMessage').text('이미 사용중인 아이디입니다.').addClass('error').removeClass('success');
        } else {
            $('#idMessage').text('사용 가능한 아이디입니다!').addClass('success').removeClass('error');
        }
    });
});

// 비밀번호 유효성 검사
$('#password').on('blur', function () {
    const pw = $(this).val();
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;

    if (!regex.test(pw)) {
        $('#passwordMessage').text('비밀번호는 영문, 숫자 조합 최소 8자 로 입력해주세요').addClass('error').removeClass('success');
    } else {
        $('#passwordMessage').text('').removeClass('error success');
    }
});

// 비밀번호 확인
$('#passwordCheck').on('input', function () {
    const pw = $('#password').val();
    const pwCheck = $(this).val();

    if (pw !== pwCheck) {
        $('#pwMessage').text('비밀번호가 일치하지 않습니다.').addClass('error').removeClass('success');
    } else {
        $('#pwMessage').text('비밀번호가 일치합니다.').addClass('success').removeClass('error');
    }
});

// 이메일 유효성 및 중복 체크
$('#email').on('blur', function () {
    let email = $(this).val();
    const hasKorean = /[ㄱ-ㅎㅏ-ㅣ가-힣]/.test(email);
    const regex = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;

    if (hasKorean || !regex.test(email)) {
        $('#emailMessage').text('이메일주소가 올바르지 않습니다').addClass('error').removeClass('success');
        return;
    }

    $.post("signUp.do", { checkType: 'email', email: email }, function (result) {
        if (result === 'duplicate') {
            $('#emailMessage').text('이미 사용중인 이메일입니다.').addClass('error').removeClass('success');
        } else {
            $('#emailMessage').text('사용 가능한 이메일입니다!').addClass('success').removeClass('error');
        }
    });
});

// 숫자만 입력
$('#phone').on('input', function () {
    this.value = this.value.replace(/[^0-9]/g, '');
});
