package co.yedam.service;

import co.yedam.vo.LoginVO;

public interface LoginService {
	int login(String id, String pw);
	LoginVO getUserInfo(int userCode);
	LoginVO findId(String userName, String phone, String email);
	boolean changePassword(int userCode, String newpassword);
}
