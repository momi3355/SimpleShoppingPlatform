package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class LeaveAgreeControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userCode") == null) {
            resp.sendRedirect("loginForm.do");
            return;
        }

        int userCode = (int) session.getAttribute("userCode");

        // 사용자 정보 조회
        LoginService service = new LoginServiceImpl();
        LoginVO vo = service.getUserInfo(userCode);

        req.setAttribute("loginVO", vo); // JSP에서 이름 사용 시 대비
        req.getRequestDispatcher("common/leaveAgree.tiles").forward(req, resp);
	}

}
