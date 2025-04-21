package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;

public class MyInfoPwControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");

        int userCode = (int) req.getSession().getAttribute("userCode");
        String inputPw = req.getParameter("password");

        LoginService service = new LoginServiceImpl();
        boolean isMatch = service.checkPassword(userCode, inputPw);

        String resultJson = "{\"result\":" + isMatch + "}";
        resp.getWriter().write(resultJson);
    }
}