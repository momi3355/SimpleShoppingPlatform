package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;

import co.yedam.vo.LoginVO;

public interface LoginService {
	int login(String id, String pw);
	
	LoginVO getUserInfo(int userCode);
	
	LoginVO findId(LoginVO vo);
	LoginVO findPw(LoginVO vo); 
	
	int resetPassword(int userCode, String newPassword);
	
	LoginVO getUserByKakaoId(String kakaoId); 
	void newKakaoUser(LoginVO vo);   
	
	boolean checkPassword(int userCode, String pw);
	
	int updateMyInfo(LoginVO vo);
	
	int deleteUser(int userCode);
	
    List<BoardVO> getNotice(String boardCategory);
    BoardVO getNoticeCode(int boardCode);

}
