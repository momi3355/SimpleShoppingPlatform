package co.yedam.service;

import co.yedam.vo.LoginVO;

public interface SignUpService {
    // 회원 등록
    boolean addUser(LoginVO vo);

    // 아이디 중복 체크
    boolean isUserIdDuplicated(String userId);

    // 이메일 중복 체크
    boolean isEmailDuplicated(String email);
}
