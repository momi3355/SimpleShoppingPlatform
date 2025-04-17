package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.SignUpServiceImpl;
import co.yedam.service.SignUpService;

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
			//boolean isDuplicated = service.isUserIdDuplicated(userId);
			
			//resp.getWriter().print(isDuplicated ? "duplicate" : "available");
			return;
		}
		//email 중복체크
		if ("email".equals(checkType)) {
			String email = req.getParameter("email");
			//boolean isDuplicated = service.idEmailDuplicated(email);
			
			//resp.getWriter().print(isDuplicated ? "duplicate" : "available");
			return;
		}
		
		
	}

}
