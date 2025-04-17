package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.MainControl;
import co.yedam.control.MypageControl;
import co.yedam.control.ProductDetailControl;
import co.yedam.control.ajax.CartJsonControl;
import co.yedam.control.form.CartFromControl;
import co.yedam.control.form.OrderFromControl;
import co.yedam.control.SignUpControl;
import co.yedam.control.SignUpFormControl;

public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		
		// 상품 상세페이지
		map.put("/productdetail.do", new ProductDetailControl());
		
		map.put("/login.do", new LoginControl());
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/mypage.do", new MypageControl());
		
		/* [결제] */
		map.put("/cartFrom.do", new CartFromControl());
		map.put("/cartJson.do", new CartJsonControl());
		map.put("/orderFrom.do", new OrderFromControl());
		map.put("/signUp.do", new SignUpControl());
		map.put("/signUpForm.do", new SignUpFormControl());
		map.put("/mypage.do", new MypageControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		Control sub = map.get(path);
		sub.exec(req, resp);

	}
}
