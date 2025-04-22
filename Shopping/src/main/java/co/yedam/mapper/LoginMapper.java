package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.BoardVO;

import co.yedam.vo.LoginVO;

public interface LoginMapper {
	LoginVO loginCheck(String userId);
	
	LoginVO selectByCode(int userCode);
	
	LoginVO findId(LoginVO vo);
	
	int updatePassword(@Param("userId") String userId, 
            		   @Param("newPassword") String newPassword);
	
	LoginVO findPw(LoginVO vo);
	int resetPassword(@Param("userCode") int userCode, 
					  @Param("newPassword") String newPassword);
	
	LoginVO selectByKakaoId(String kakaoId);
	void insertKakaoUser(LoginVO vo);

	String selectPasswordByCode(int userCode);
	
	int updateInfo(LoginVO vo);
	
	int deleteUser(int userCode);
	
	List<BoardVO> selectNtCategory(String boardCategory);
	BoardVO selectNtCode(int boardCode);  
}
