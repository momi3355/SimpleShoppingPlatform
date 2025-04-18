package co.yedam.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.LoginMapper;
import co.yedam.vo.LoginVO;

public class LoginServiceImpl implements LoginService {

    SqlSession session = DataSource.getInstance().openSession(true);
    LoginMapper loginmapper = session.getMapper(LoginMapper.class);

    @Override
    public int login(String id, String pw) {
        LoginVO vo = loginmapper.loginCheck(id);
        if (vo != null && vo.getPassword().equals(pw)) {
            return vo.getUserCode(); 
        }
        return 0;
    }

    @Override
    public LoginVO getUserInfo(int userCode) {
        return loginmapper.selectByCode(userCode);
    }

    @Override
    public LoginVO findId(String userName, String phone, String email) {
        return loginmapper.findId(userName, phone, email);
    }

	@Override
	public boolean changePassword(int userCode, String newpassword) {
		return loginmapper.updatePassword(userCode, newpassword) == 1;
	}
}