package co.yedam.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.SignUpMapper;
import co.yedam.vo.LoginVO;

public class SignUpServiceImpl implements SignUpService {
	SqlSession session = DataSource.getInstance().openSession(true); // auto commit
    SignUpMapper mapper = session.getMapper(SignUpMapper.class);

    @Override
    public boolean addUser(LoginVO vo) {
        return mapper.insertUser(vo) == 1;
    }

    @Override
    public boolean isUserIdDuplicated(String userId) {
        return mapper.selectByUserId(userId) != null;
    }

    @Override
    public boolean isEmailDuplicated(String email) {
        return mapper.selectByEmail(email) != null;
    }
}
