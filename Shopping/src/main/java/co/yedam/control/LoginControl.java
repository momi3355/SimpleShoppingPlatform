package co.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.LoginMapper;
import co.yedam.vo.LoginVO;

public class LoginControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = DataSource.getInstance().openSession();
        LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        LoginVO vo = mapper.loginCheck(id);
 
        if (vo != null && vo.getPassword().equals(pw)) {
            req.getSession().setAttribute("loginUser", vo);
            resp.sendRedirect("main.do");
        } else {
            req.getSession().setAttribute("loginError", "아이디 또는 비밀번호를 확인하세요.");
            resp.sendRedirect("loginForm.do");
        }
    }
}
