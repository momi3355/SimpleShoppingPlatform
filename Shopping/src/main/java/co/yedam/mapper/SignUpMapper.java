package co.yedam.mapper;

import co.yedam.vo.LoginVO;

public interface SignUpMapper {
    // 회원가입 처리
    int insertUser(LoginVO vo);

    // 아이디 중복 체크
    LoginVO selectByUserId(String userId);

    // 이메일 중복 체크
    LoginVO selectByEmail(String email);
}
