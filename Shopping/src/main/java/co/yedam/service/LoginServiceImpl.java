package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.vo.BoardVO;

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
	public LoginVO findId(LoginVO vo) {
		return loginmapper.findId(vo);
	}

	@Override
	public LoginVO findPw(LoginVO vo) {
		return loginmapper.findPw(vo);
	}

	@Override
	public int resetPassword(int userCode, String newPassword) {
		return loginmapper.resetPassword(userCode, newPassword);
	}

	@Override
	public LoginVO getUserByKakaoId(String kakaoId) {
		return loginmapper.selectByKakaoId(kakaoId);
	}

	@Override
	public void newKakaoUser(LoginVO vo) {
		loginmapper.insertKakaoUser(vo);
	}

	@Override
	public boolean checkPassword(int userCode, String pw) {
		String realPw = loginmapper.selectPasswordByCode(userCode);
		return realPw != null && realPw.equals(pw);

	}

	@Override
	public int updateMyInfo(LoginVO vo) {
		return loginmapper.updateInfo(vo);
	}

	@Override
	public int deleteUser(int userCode) {
		return loginmapper.deleteUser(userCode);
	}

	@Override
	public List<BoardVO> getNotice(String boardCategory) {
		return loginmapper.selectNtCategory(boardCategory);
	}

	@Override
	public BoardVO getNoticeCode(int boardCode) {
		return loginmapper.selectNtCode(boardCode);
	}

}