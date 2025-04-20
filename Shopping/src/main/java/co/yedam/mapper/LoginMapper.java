package co.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.LoginVO;

public interface LoginMapper {
	LoginVO loginCheck(String userId);
	LoginVO selectByCode(int userCode);
	LoginVO findId(@Param("userName") String userName, 
				   @Param("phone") String phone, 
				   @Param("email") String email);
	int updatePassword(@Param("userId") String userId, 
            		   @Param("newPassword") String newPassword);
	LoginVO findPw(LoginVO vo);
	int resetPassword(@Param("userCode") int userCode, @Param("newPassword") String newPassword);
	
	LoginVO selectByKakaoId(String kakaoId);
	void insertKakaoUser(LoginVO vo);
	
}
