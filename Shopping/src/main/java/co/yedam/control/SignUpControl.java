package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.SignUpService;
import co.yedam.service.SignUpServiceImpl;
import co.yedam.vo.LoginVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		
		String checkType = req.getParameter("checkType");
		SignUpService service = new SignUpServiceImpl();
		
		//id 중복체크
		if("id".equals(checkType)) {
			String userId = req.getParameter("userId");
			boolean isDuplicated = service.isUserIdDuplicated(userId);
			
			resp.getWriter().print(isDuplicated ? "duplicate" : "available");
			return;
		}
		//email 중복체크
		if ("email".equals(checkType)) {
			String email = req.getParameter("email");
			boolean isDuplicated = service.isEmailDuplicated(email);
			
			resp.getWriter().print(isDuplicated ? "duplicate" : "available");
			return;
		}
		
		// 회원가입 처리
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		LoginVO vo = new LoginVO();
        vo.setUserId(userId);
        vo.setPassword(password);
        vo.setUserName(userName);
        vo.setPhone(phone);
        vo.setEmail(email);
        
        boolean result = service.addUser(vo);
		
        if (result) {
        	if (result) {
        	    req.setAttribute("message", "회원가입이 완료되었습니다. 로그인 후 이용해 주세요.");
        	    req.getRequestDispatcher("common/login.tiles").forward(req, resp);
        	}
        } else {
            req.setAttribute("error", "다시 시도해주세요.");
            req.getRequestDispatcher("common/signUp.tiles").forward(req, resp);
        }
	}
}
	
