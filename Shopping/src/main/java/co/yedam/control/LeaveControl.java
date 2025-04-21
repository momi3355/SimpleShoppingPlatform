package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;

public class LeaveControl implements Control {

	@Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userCode") == null) {
            resp.sendRedirect("loginForm.do");
            return;
        }

        int userCode = (int) session.getAttribute("userCode");

        // 회원 탈퇴 처리
        LoginService service = new LoginServiceImpl();
        service.deleteUser(userCode);

        // 세션 종료
        session.invalidate();

        // 완료 화면 이동
        req.getRequestDispatcher("common/leave.tiles").forward(req, resp);
	}
}