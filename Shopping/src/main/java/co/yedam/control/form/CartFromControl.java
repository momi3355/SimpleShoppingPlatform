package co.yedam.control.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.LoginVO;

public class CartFromControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//임시로 처리
//		LoginVO login = new LoginVO();
//		login.setUserCode(1);
//		login.setUserName("홍길동");
//		login.setUserId("user01");
//		login.setPassword("pw1234");
//		
//		req.getSession().setAttribute("loginVO", login);
		req.setAttribute("user_code", 1);
		req.getRequestDispatcher("common/cart.tiles").forward(req, resp);
	}
}
