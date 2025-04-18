package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.LoginMapper;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;

public class LoginControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        LoginService service = new LoginServiceImpl();
        int userCode = service.login(id,pw);
 
        if (userCode != 0) {
        	req.getSession().setAttribute("userCode", userCode);
        	resp.sendRedirect("main.do");
        } else {
        	req.getSession().setAttribute("loginError", "아이디 또는 비밀번호를 확인해주세요.");
        	resp.sendRedirect("loginForm.do");
        }
    }
}
