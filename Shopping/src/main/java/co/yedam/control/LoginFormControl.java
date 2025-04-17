package co.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import co.yedam.common.Control;

public class LoginFormControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // 기존 로그인 에러 메시지 처리
        Object error = session.getAttribute("loginError");
        if (error != null) {
            req.setAttribute("message", error);
            session.removeAttribute("loginError");
        }

        // 회원가입 성공 메시지 처리
        if (req.getAttribute("message") != null) {
            // 그대로 전달됨
        }

        req.getRequestDispatcher("common/login.tiles").forward(req, resp);
    }
}
