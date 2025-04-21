package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class MyInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 if (req.getMethod().equals("GET")) {
	            // 내정보 변경 화면 진입
	            int userCode = (int) req.getSession().getAttribute("userCode");

	            LoginService service = new LoginServiceImpl();
	            LoginVO vo = service.getUserInfo(userCode);

	            req.setAttribute("user", vo);
	            req.getRequestDispatcher("common/myInfo.tiles").forward(req, resp);

	        } else if (req.getMethod().equals("POST")) {
	            // 정보 수정 처리
	            req.setCharacterEncoding("utf-8");
	            resp.setContentType("application/json;charset=utf-8");

	            int userCode = (int) req.getSession().getAttribute("userCode");
	            String email = req.getParameter("email");
	            String phone = req.getParameter("phone");

	            LoginVO vo = new LoginVO();
	            vo.setUserCode(userCode);
	            vo.setEmail(email);
	            vo.setPhone(phone);

	            LoginService service = new LoginServiceImpl();
	            int result = service.updateMyInfo(vo);

	            String json = "{\"success\":" + (result > 0) + "}";
	            resp.getWriter().write(json);
	        }
	    }
	}