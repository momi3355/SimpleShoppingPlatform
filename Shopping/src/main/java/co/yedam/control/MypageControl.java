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

public class MypageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		Integer userCode = (Integer) session.getAttribute("userCode");
		
		if (userCode == null) {
			resp.sendRedirect("loginForm.do");
			return;
		}
		
		LoginService service = new LoginServiceImpl();
		LoginVO vo = service.getUserInfo(userCode);
		
		req.setAttribute("userName", vo.getUserName());
		req.getRequestDispatcher("common/mypage.tiles").forward(req, resp);
	}
}
