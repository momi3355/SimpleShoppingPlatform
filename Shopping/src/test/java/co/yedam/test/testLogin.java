package co.yedam.test;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.vo.LoginVO;
import co.yedam.mapper.LoginMapper;

public class testLogin {
    public static void main(String[] args) {
        String testId = "user01";
        String testPw = "pw1234";

        SqlSession session = DataSource.getInstance().openSession();
        LoginMapper mapper = session.getMapper(LoginMapper.class);

        LoginVO vo = mapper.loginCheck(testId);

        if (vo != null && vo.getPassword().equals(testPw)) {
            System.out.println("✅ 로그인 성공!");
            System.out.println("유저코드: " + vo.getUserCode());
            System.out.println("이름: " + vo.getUserName());
            System.out.println("이메일: " + vo.getEmail());
            System.out.println("전화번호: " + vo.getPhone());
        } else {
            System.out.println("❌ 로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        session.close();
    }
}
