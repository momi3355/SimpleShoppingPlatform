package co.yedam.vo;

import lombok.Data;

@Data
public class LoginVO {
	private int userCode;
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String userDate;
	private String kakaoId;
}
