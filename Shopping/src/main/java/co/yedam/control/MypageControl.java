package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.vo.LoginVO;

public class MypageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LoginVO loginVO = (LoginVO) req.getSession().getAttribute("loginVO");
		
		if (loginVO == null) {
			resp.sendRedirect("loginForm.do");
			return;
		}
		
		req.getRequestDispatcher("common/mypage.tiles").forward(req, resp);
	}
}
